import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.io.*;
import java.util.concurrent.*;

/**
 * GUI_Main - Algorithm Explorer (Sanal Terminalli ve Multi-Threaded Versiyon)
 */
public class GUI_Main extends JFrame {

    // ── Senin Güncellediğin Renk Paleti ─────────────────────────────────────────
    private static final Color BG_DARK = new Color(18, 18, 30);
    private static final Color PANEL_BG = new Color(28, 28, 45);
    private static final Color CARD_BG = new Color(38, 38, 60);
    private static final Color ACCENT_BLUE = new Color(80, 140, 255);
    private static final Color ACCENT_GREEN = new Color(100, 255, 140); // Parlak yeşil
    private static final Color ACCENT_PURP = new Color(160, 90, 255);
    private static final Color TEXT_WHITE = new Color(245, 245, 255);   // Parlak beyaz
    private static final Color TEXT_GRAY = new Color(210, 210, 230);    // Net gri
    private static final Color TERMINAL_BG = new Color(10, 10, 15);

    // ── Fonts ──────────────────────────────────────────────────────────────────
    private static final Font FONT_TITLE = new Font("Segoe UI", Font.BOLD, 22);
    private static final Font FONT_NORMAL = new Font("Segoe UI", Font.PLAIN, 13);
    private static final Font FONT_MONO = new Font("Consolas", Font.PLAIN, 14);

    // ── Bileşenler ve Sistem Değişkenleri ─────────────────────────────────────
    private JTextArea consoleOutput;
    private JTextField consoleInput;
    private JPanel centerPanel;
    private ConsoleInputStream inPipe;
    private Thread currentAlgorithmThread; // GUI'nin donmasını engelleyecek ayrı iş parçacığı

    // Orijinal Algoritma Sınıfların (Hiç dokunulmadı)
    private final Number_Algorithm numberAlg = new Number_Algorithm();
    private final Sorting_Algorithm sortingAlg = new Sorting_Algorithm();
    private final Selecting_Algorithm selectingAlg = new Selecting_Algorithm();

    public GUI_Main() {
        super("Algorithm Explorer - Sanal Terminal");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1100, 750);
        setMinimumSize(new Dimension(900, 600));
        setLocationRelativeTo(null);
        getContentPane().setBackground(BG_DARK);
        setLayout(new BorderLayout());

        // Java'nın Scanner (System.in) okumasını GUI'ye bağlayan hack!
        setupVirtualTerminal();

        buildUI();
        setVisible(true);
    }

    private void buildUI() {
        // Üst Başlık
        JPanel topBar = new JPanel(new BorderLayout());
        topBar.setBackground(PANEL_BG);
        topBar.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createMatteBorder(0, 0, 1, 0, ACCENT_BLUE),
                new EmptyBorder(10, 20, 10, 20)
        ));
        JLabel title = new JLabel("⚙ Algorithm Explorer");
        title.setFont(FONT_TITLE); title.setForeground(TEXT_WHITE);

        JLabel sub = new JLabel("Donmaları önlemek için Multi-Threaded Sanal Terminal kullanılıyor");
        sub.setFont(FONT_NORMAL); sub.setForeground(TEXT_GRAY);

        JPanel left = new JPanel(new GridLayout(2, 1));
        left.setOpaque(false); left.add(title); left.add(sub);
        topBar.add(left, BorderLayout.WEST);

        add(topBar, BorderLayout.NORTH);

        // Sol Menü (Kategoriler)
        JPanel sidebar = new JPanel();
        sidebar.setLayout(new BoxLayout(sidebar, BoxLayout.Y_AXIS));
        sidebar.setBackground(PANEL_BG);
        sidebar.setPreferredSize(new Dimension(220, 0));
        sidebar.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createMatteBorder(0, 0, 0, 1, new Color(60, 60, 90)),
                new EmptyBorder(15, 10, 15, 10)
        ));

        JLabel catLabel = new JLabel("CATEGORIES");
        catLabel.setFont(new Font("Segoe UI", Font.BOLD, 10));
        catLabel.setForeground(TEXT_GRAY);
        catLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        sidebar.add(catLabel);
        sidebar.add(Box.createRigidArea(new Dimension(0, 10)));

        sidebar.add(createCategoryBtn("🔢 Number Algorithms", 1, ACCENT_BLUE));
        sidebar.add(Box.createRigidArea(new Dimension(0, 10)));
        sidebar.add(createCategoryBtn("📊 Sorting Algorithms", 2, ACCENT_GREEN));
        sidebar.add(Box.createRigidArea(new Dimension(0, 10)));
        sidebar.add(createCategoryBtn("🔍 Search & Graph", 3, ACCENT_PURP));

        add(sidebar, BorderLayout.WEST);

        // Orta Kısım (Butonlar ve Terminal)
        centerPanel = new JPanel(new BorderLayout(10, 10));
        centerPanel.setBackground(BG_DARK);
        centerPanel.setBorder(new EmptyBorder(15, 15, 15, 15));

        // Terminal Ekranı (Çıktı ve Girdi Alanı)
        consoleOutput = new JTextArea();
        consoleOutput.setFont(FONT_MONO);
        consoleOutput.setForeground(ACCENT_GREEN); // Senin parlak yeşilin
        consoleOutput.setBackground(TERMINAL_BG);
        consoleOutput.setCaretColor(ACCENT_GREEN);
        consoleOutput.setEditable(false);
        consoleOutput.setMargin(new Insets(10, 10, 10, 10));

        consoleInput = new JTextField();
        consoleInput.setFont(FONT_MONO);
        consoleInput.setForeground(TEXT_WHITE);
        consoleInput.setBackground(new Color(48, 48, 75));
        consoleInput.setCaretColor(Color.WHITE);
        consoleInput.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(80, 80, 120), 1),
                new EmptyBorder(8, 8, 8, 8)
        ));

        // Kullanıcı Enter'a basınca veriyi Sanal Terminale gönderir
        consoleInput.addActionListener(e -> {
            String text = consoleInput.getText();
            consoleOutput.append("> " + text + "\n"); // Ekranda yazılanı göster
            inPipe.writeString(text);                 // Algoritmanın içindeki Scanner'a yolla
            consoleInput.setText("");
        });

        JPanel terminalPanel = new JPanel(new BorderLayout());
        terminalPanel.add(new JScrollPane(consoleOutput), BorderLayout.CENTER);

        JPanel inputWrapper = new JPanel(new BorderLayout());
        inputWrapper.setBackground(BG_DARK);
        JLabel inputLbl = new JLabel(" Buraya yaz ve Enter'a bas: ");
        inputLbl.setForeground(TEXT_GRAY); inputLbl.setFont(FONT_NORMAL);
        inputWrapper.add(inputLbl, BorderLayout.WEST);
        inputWrapper.add(consoleInput, BorderLayout.CENTER);

        terminalPanel.add(inputWrapper, BorderLayout.SOUTH);
        terminalPanel.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(new Color(60,60,90)), " Terminal (Çıktılar ve Girişler) ",
                0, 0, FONT_NORMAL, TEXT_GRAY));
        terminalPanel.setBackground(BG_DARK);

        centerPanel.add(terminalPanel, BorderLayout.CENTER);
        add(centerPanel, BorderLayout.CENTER);

        // Başlangıçta Number algoritma menüsünü yükle
        loadAlgorithms(1);
    }

    private JButton createCategoryBtn(String text, int type, Color accent) {
        JButton btn = new JButton(text);
        btn.setFont(new Font("Segoe UI", Font.BOLD, 13));
        btn.setForeground(TEXT_WHITE);
        btn.setBackground(CARD_BG);
        btn.setFocusPainted(false);
        btn.setMaximumSize(new Dimension(200, 40));
        btn.setAlignmentX(Component.CENTER_ALIGNMENT);
        btn.setBorder(BorderFactory.createLineBorder(new Color(60, 60, 90), 1));
        btn.addActionListener(e -> loadAlgorithms(type));
        return btn;
    }

    // Seçilen kategoriye göre üst tarafa algoritma butonlarını dizer
    private void loadAlgorithms(int type) {
        if (((BorderLayout)centerPanel.getLayout()).getLayoutComponent(BorderLayout.NORTH) != null) {
            centerPanel.remove(((BorderLayout)centerPanel.getLayout()).getLayoutComponent(BorderLayout.NORTH));
        }

        JPanel btnPanel = new JPanel(new GridLayout(0, 4, 6, 6));
        btnPanel.setBackground(BG_DARK);

        String[] names = getAlgorithmNames(type);
        for (int i = 0; i < names.length; i++) {
            final int index = i + 1;
            JButton btn = new JButton((i+1) + ". " + names[i]);
            btn.setFont(new Font("Segoe UI", Font.PLAIN, 11));
            btn.setBackground(CARD_BG);
            btn.setForeground(TEXT_WHITE);
            btn.setFocusPainted(false);
            btn.addActionListener(e -> runAlgorithm(type, index));
            btnPanel.add(btn);
        }

        centerPanel.add(btnPanel, BorderLayout.NORTH);
        centerPanel.revalidate();
        centerPanel.repaint();
    }

    // ── En Kritik Kısım: Arayüzü Dondurmamak İçin Ayrı Bir Thread Açıyoruz ──
    private void runAlgorithm(int category, int choice) {
        // Eğer eski bir algoritma hala klavye girişi bekliyorsa onu sonlandır
        if (currentAlgorithmThread != null && currentAlgorithmThread.isAlive()) {
            currentAlgorithmThread.interrupt();
        }

        consoleOutput.setText(""); // Terminali temizle
        inPipe.clear(); // Bekleyen eski girdileri temizle

        // Algoritmayı ana ekrandan BAĞIMSIZ bir iş parçacığında çalıştırıyoruz
        currentAlgorithmThread = new Thread(() -> {
            try {
                if (category == 1) {
                    switch (choice) {
                        case 1: numberAlg.PerfectNumber(); break;
                        case 2: numberAlg.FibonacciNumbers(); break;
                        case 3: numberAlg.ArmstrongNumbers(); break;
                        case 4: numberAlg.TribonacciNumbers(); break;
                        case 5: numberAlg.PalindromeNumbers(); break;
                        case 6: numberAlg.CullenNumbers(); break;
                        case 7: numberAlg.LasaNumbers(); break;
                        case 8: numberAlg.FermatNumbers(); break;
                        case 9: numberAlg.AmicableNumbers(); break;
                        case 10: numberAlg.AbundantNumbers(); break;
                        case 11: numberAlg.LucasSeries(); break;
                        case 12: numberAlg.TetranacciNumbers(); break;
                        case 13: numberAlg.TwinPrimes(); break;
                        case 14: numberAlg.WoodallNumbers(); break;
                        case 15: numberAlg.MersenneNumbers(); break;
                        case 16: numberAlg.HarshadNumbers(); break;
                        case 17: numberAlg.CyclicNumbers(); break;
                        case 18: numberAlg.TauNumbers(); break;
                        case 19: numberAlg.BetrothedNumbers(); break;
                        case 20: numberAlg.KaprekarConstant(); break;
                    }
                } else if (category == 2) {
                    switch (choice) {
                        case 1: sortingAlg.InsertionSort(); break;
                        case 2: sortingAlg.SelectionSort(); break;
                        case 3: sortingAlg.BubbleSort(); break;
                        case 4: sortingAlg.DivideAndConquerSort(); break;
                        case 5: sortingAlg.ShellSort(); break;
                        case 6: sortingAlg.MergeSort(); break;
                        case 7: sortingAlg.QuickSort(); break;
                        case 8: sortingAlg.QuickSort3(); break;
                        case 9: sortingAlg.HeapSort(); break;
                        case 10: sortingAlg.RadixSort(); break;
                        case 11: sortingAlg.ShakerSort(); break;
                        case 12: sortingAlg.RandomSort(); break;
                        case 13: sortingAlg.LuckySort(); break;
                        case 14: sortingAlg.StoogeSort(); break;
                        case 15: sortingAlg.FlashSort(); break;
                        case 16: sortingAlg.CombSort(); break;
                        case 17: sortingAlg.GnomeSort(); break;
                        case 18: sortingAlg.PermutationSort(); break;
                        case 19: sortingAlg.StrandSort(); break;
                        case 20: sortingAlg.BucketSort(); break;
                    }
                } else if (category == 3) {
                    switch (choice) {
                        case 1: selectingAlg.LinearSearch(); break;
                        case 2: selectingAlg.BinarySearch(); break;
                        case 3: selectingAlg.InterpolationSearch(); break;
                        case 4: selectingAlg.GraphAlgorithms(); break;
                        case 5: selectingAlg.UniformCostSearch(); break;
                        case 6: selectingAlg.FloydWarshall(); break;
                        case 7: selectingAlg.PrimsAlgorithm(); break;
                        case 8: selectingAlg.KruskalsAlgorithm(); break;
                        case 9: selectingAlg.DijkstraAlgorithm(); break;
                        case 10: selectingAlg.BellmanFordAlgorithm(); break;
                        case 11: selectingAlg.BinarySearchTree(); break;
                        case 12: selectingAlg.PruferSequence(); break;
                        case 13: selectingAlg.TextSearchAlgorithms(); break;
                        case 14: selectingAlg.HorspoolSearch(); break;
                        case 15: selectingAlg.BruteForceSearch(); break;
                    }
                }
                System.out.println("\n---The process is complete.---");
            } catch (Exception ex) {
                // Thread arayüz tarafından kesilirse yoksay
            }
        });
        currentAlgorithmThread.start();
        consoleInput.requestFocus(); // İmleci otomatik giriş kutusuna taşı
    }

    private String[] getAlgorithmNames(int type) {
        if (type == 1) return new String[]{
                "Perfect", "Fibonacci", "Armstrong", "Tribonacci", "Palindrome",
                "Cullen", "Lasa", "Fermat", "Amicable", "Abundant", "Lucas",
                "Tetranacci", "Twin Primes", "Woodall", "Mersenne", "Harshad",
                "Cyclic", "Tau", "Betrothed", "Kaprekar"
        };
        if (type == 2) return new String[]{
                "Insertion", "Selection", "Bubble", "Divide&Conq.", "Shell",
                "Merge", "Quick", "Quick3", "Heap", "Radix", "Shaker", "Random",
                "Lucky", "Stooge", "Flash", "Comb", "Gnome", "Permutation",
                "Strand", "Bucket"
        };
        return new String[]{
                "Linear", "Binary", "Interpolation", "BFS/DFS", "Uniform Cost",
                "Floyd-Warsh.", "Prim's", "Kruskal's", "Dijkstra", "Bellman-Ford",
                "BST", "Prufer Seq.", "Text Search", "Horspool", "Brute Force"
        };
    }

    // ══════════════════════════════════════════════════════════════════════════
    // SYSTEM.IN VE SYSTEM.OUT HACK (Sanal Terminal Altyapısı)
    // ══════════════════════════════════════════════════════════════════════════
    private void setupVirtualTerminal() {
        inPipe = new ConsoleInputStream();
        System.setIn(inPipe); // Standart klavye girişini bizim kutuya bağlar

        OutputStream outPipe = new OutputStream() {
            @Override
            public void write(int b) {
                SwingUtilities.invokeLater(() -> {
                    consoleOutput.append(String.valueOf((char) b));
                    consoleOutput.setCaretPosition(consoleOutput.getDocument().getLength());
                });
            }
            @Override
            public void write(byte[] b, int off, int len) {
                String s = new String(b, off, len);
                SwingUtilities.invokeLater(() -> {
                    consoleOutput.append(s);
                    consoleOutput.setCaretPosition(consoleOutput.getDocument().getLength());
                });
            }
        };
        System.setOut(new PrintStream(outPipe, true)); // Println çıktılarını arayüze bağlar
        System.setErr(new PrintStream(outPipe, true));
    }

    // İŞTE HATAYI ÇÖZEN O YENİ SINIF BURASI
    class ConsoleInputStream extends InputStream {
        private final BlockingQueue<Integer> queue = new LinkedBlockingQueue<>();

        public void writeString(String s) {
            for (char c : s.toCharArray()) queue.add((int) c);
            queue.add((int) '\n'); // Scanner'ın okuyabilmesi için Enter (Yeni satır)
        }

        public void clear() { queue.clear(); }

        @Override
        public int read() {
            try { return queue.take(); } // Arayüzü dondurmaz, sadece Thread'i uyutur!
            catch (InterruptedException e) { return -1; }
        }

        // BU KISIM EKLENDİ: Scanner'ın açgözlü beklemesini engeller!
        @Override
        public int read(byte[] b, int off, int len) {
            if (len == 0) return 0;
            try {
                // İlk karakter gelene kadar bekle
                b[off] = (byte) queue.take().intValue();
                int count = 1;
                // Eğer kuyrukta bekleyen başka karakter varsa, hiç beklemeden hepsini al ve Scanner'a fırlat
                while (count < len && !queue.isEmpty()) {
                    b[off + count] = (byte) queue.poll().intValue();
                    count++;
                }
                return count; // Scanner'a "Al kardeşim şimdilik bende bu kadar var" der ve işlemi başlatır
            } catch (InterruptedException e) {
                return -1;
            }
        }
    }

    // ── Senin Güncellediğin Nimbus Teması ──────────────────────────────────────
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
            UIManager.put("Button.background", new Color(38, 38, 60));
            UIManager.put("Button.foreground", new Color(245, 245, 255));
            UIManager.put("Panel.background", new Color(28, 28, 45));
        } catch (Exception ignored) {
        }
        SwingUtilities.invokeLater(GUI_Main::new);
    }
}