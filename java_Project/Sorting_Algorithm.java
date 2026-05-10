import java.util.Scanner;
import java.util.*;
public class Sorting_Algorithm {
    public void Algorithm_ofSorting(int operationNumber) {
        Scanner input = new Scanner(System.in);
        int choice2;
        System.out.println("\n--- SORTING ALGORITHMS MENU ---");
        System.out.println("1- Insertion Sort");
        System.out.println("2- Selection Sort ");
        System.out.println("3- Bubble Sort ");
        System.out.println("4- Divide and Conquer Sort ");
        System.out.println("5- Shell Sort");
        System.out.println("6- Merge Sort");
        System.out.println("7- Quick Sort");
        System.out.println("8- Quick Sort3");
        System.out.println("9- Heap Sort ");
        System.out.println("10- Radix Sort ");
        System.out.println("11- Shaker Sort ");
        System.out.println("12- Random Sort ");
        System.out.println("13- Lucky Sort ");
        System.out.println("14- Stooge Sort ");
        System.out.println("15- Flash Sort ");
        System.out.println("16- Comb Sort ");
        System.out.println("17- Gnome Sort");
        System.out.println("18- Permutation Sort ");
        System.out.println("19- Strand Sort");
        System.out.println("20- Bucket Sort ");

        System.out.print("\nPlease enter a sorting algorithm number: ");
        choice2 = input.nextInt();
        switch (choice2) {
            case 1:
                InsertionSort();
                break;
            case 2:
                SelectionSort();
                break;
            case 3:
                BubbleSort();
                break;
            case 4:
                DivideAndConquerSort();
                break;
            case 5:
                ShellSort();
                break;
            case 6:
                MergeSort();
                break;
            case 7:
                QuickSort();
                break;
            case 8:
                QuickSort3();
                break;
            case 9:
                HeapSort();
                break;
            case 10:
                RadixSort();
                break;
            case 11:
                ShakerSort();
                break;
            case 12:
                RandomSort();
                break;
            case 13:
                LuckySort();
                break;
            case 14:
                StoogeSort();
                break;
            case 15:
                FlashSort();
                break;
            case 16:
                CombSort();
                break;
            case 17:
                GnomeSort();
                break;
            case 18:
                PermutationSort();
                break;
            case 19:
                StrandSort();
                break;
            case 20:
                BucketSort();
                break;
            default:
                System.out.println("You entered invalid value");
        }

    }
    // 1. Insertion Sort
    public void InsertionSort() {
        int[] arr = getArrayFromUser();
        System.out.println("\n--- Insertion Sort ---");
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
        printArray(arr);
    }

    // 2. Selection Sort
    public void SelectionSort() {
        int[] arr = getArrayFromUser();
        System.out.println("\n--- Selection Sort ---");
        for (int i = 0; i < arr.length - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIdx]) minIdx = j;
            }
            int temp = arr[minIdx];
            arr[minIdx] = arr[i];
            arr[i] = temp;
        }
        printArray(arr);
    }

    // 3. Bubble Sort
    public void BubbleSort() {
        int[] arr = getArrayFromUser();
        System.out.println("\n--- Bubble Sort ---");
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        printArray(arr);
    }

    // 4. Divide and Conquer Sort (Using Merge Sort Logic)
    public void DivideAndConquerSort() {
        int[] arr = getArrayFromUser();
        System.out.println("\n--- Divide and Conquer (Merge) Sort ---");
        mergeSortHelper(arr, 0, arr.length - 1);
        printArray(arr);
    }

    // 5. Shell Sort
    public void ShellSort() {
        int[] arr = getArrayFromUser();
        System.out.println("\n--- Shell Sort ---");
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                int temp = arr[i];
                int j;
                for (j = i; j >= gap && arr[j - gap] > temp; j -= gap) {
                    arr[j] = arr[j - gap];
                }
                arr[j] = temp;
            }
        }
        printArray(arr);
    }

    // 6. Merge Sort
    public void MergeSort() {
        int[] arr = getArrayFromUser();
        System.out.println("\n--- Merge Sort ---");
        mergeSortHelper(arr, 0, arr.length - 1);
        printArray(arr);
    }

    // Helper for Merge Sort
    private void mergeSortHelper(int[] arr, int l, int r) {
        if (l < r) {
            int m = l + (r - l) / 2;
            mergeSortHelper(arr, l, m);
            mergeSortHelper(arr, m + 1, r);
            merge(arr, l, m, r);
        }
    }

    private void merge(int[] arr, int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;
        int[] L = new int[n1];
        int[] R = new int[n2];
        for (int i = 0; i < n1; ++i) L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j) R[j] = arr[m + 1 + j];
        int i = 0, j = 0, k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) arr[k++] = L[i++];
            else arr[k++] = R[j++];
        }
        while (i < n1) arr[k++] = L[i++];
        while (j < n2) arr[k++] = R[j++];
    }

    // 7. Quick Sort
    public void QuickSort() {
        int[] arr = getArrayFromUser();
        System.out.println("\n--- Quick Sort ---");
        quickSortHelper(arr, 0, arr.length - 1);
        printArray(arr);
    }

    private void quickSortHelper(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSortHelper(arr, low, pi - 1);
            quickSortHelper(arr, pi + 1, high);
        }
    }

    private int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }

    // 8. Quick Sort 3 (3-Way Partitioning)
    public void QuickSort3() {
        int[] arr = getArrayFromUser();
        System.out.println("\n--- Quick Sort (3-Way) ---");
        quickSort3Helper(arr, 0, arr.length - 1);
        printArray(arr);
    }

    private void quickSort3Helper(int[] arr, int low, int high) {
        if (low >= high) return;
        int lt = low, gt = high;
        int v = arr[low];
        int i = low + 1;
        while (i <= gt) {
            if (arr[i] < v) swap(arr, lt++, i++);
            else if (arr[i] > v) swap(arr, i, gt--);
            else i++;
        }
        quickSort3Helper(arr, low, lt - 1);
        quickSort3Helper(arr, gt + 1, high);
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // 9. Heap Sort
    public void HeapSort() {
        int[] arr = getArrayFromUser();
        System.out.println("\n--- Heap Sort ---");
        int n = arr.length;
        for (int i = n / 2 - 1; i >= 0; i--) heapify(arr, n, i);
        for (int i = n - 1; i > 0; i--) {
            swap(arr, 0, i);
            heapify(arr, i, 0);
        }
        printArray(arr);
    }

    private void heapify(int[] arr, int n, int i) {
        int largest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;
        if (l < n && arr[l] > arr[largest]) largest = l;
        if (r < n && arr[r] > arr[largest]) largest = r;
        if (largest != i) {
            swap(arr, i, largest);
            heapify(arr, n, largest);
        }
    }

    // 10. Radix Sort
    public void RadixSort() {
        int[] arr = getArrayFromUser();
        System.out.println("\n--- Radix Sort ---");
        int max = Arrays.stream(arr).max().getAsInt();
        for (int exp = 1; max / exp > 0; exp *= 10) countSort(arr, exp);
        printArray(arr);
    }

    private void countSort(int[] arr, int exp) {
        int n = arr.length;
        int[] output = new int[n];
        int[] count = new int[10];
        for (int i = 0; i < n; i++) count[(arr[i] / exp) % 10]++;
        for (int i = 1; i < 10; i++) count[i] += count[i - 1];
        for (int i = n - 1; i >= 0; i--) {
            output[count[(arr[i] / exp) % 10] - 1] = arr[i];
            count[(arr[i] / exp) % 10]--;
        }
        System.arraycopy(output, 0, arr, 0, n);
    }

    // 11. Shaker Sort (Cocktail Sort)
    public void ShakerSort() {
        int[] arr = getArrayFromUser();
        System.out.println("\n--- Shaker Sort ---");
        boolean swapped = true;
        int start = 0, end = arr.length - 1;
        while (swapped) {
            swapped = false;
            for (int i = start; i < end; i++) {
                if (arr[i] > arr[i + 1]) { swap(arr, i, i + 1); swapped = true; }
            }
            if (!swapped) break;
            swapped = false;
            end--;
            for (int i = end - 1; i >= start; i--) {
                if (arr[i] > arr[i + 1]) { swap(arr, i, i + 1); swapped = true; }
            }
            start++;
        }
        printArray(arr);
    }

    // 12. Random Sort (Bogo Sort) - Warning: Extremely Slow!
    public void RandomSort() {
        int[] arr = getArrayFromUser();
        System.out.println("\n--- Random Sort (Bogo Sort) ---");
        Random rand = new Random();
        while (!isSorted(arr)) {
            for (int i = 0; i < arr.length; i++) {
                swap(arr, i, rand.nextInt(arr.length));
            }
        }
        printArray(arr);
    }

    // 13. Lucky Sort (Bozo Sort)
    public void LuckySort() {
        int[] arr = getArrayFromUser();
        System.out.println("\n--- Lucky Sort (Bozo Sort) ---");
        Random rand = new Random();
        while (!isSorted(arr)) {
            swap(arr, rand.nextInt(arr.length), rand.nextInt(arr.length));
        }
        printArray(arr);
    }

    // 14. Stooge Sort
    public void StoogeSort() {
        int[] arr = getArrayFromUser();
        System.out.println("\n--- Stooge Sort ---");
        stoogeSortHelper(arr, 0, arr.length - 1);
        printArray(arr);
    }

    private void stoogeSortHelper(int[] arr, int l, int h) {
        if (l >= h) return;
        if (arr[l] > arr[h]) swap(arr, l, h);
        if (h - l + 1 > 2) {
            int t = (h - l + 1) / 3;
            stoogeSortHelper(arr, l, h - t);
            stoogeSortHelper(arr, l + t, h);
            stoogeSortHelper(arr, l, h - t);
        }
    }

    // 15. Flash Sort
    public void FlashSort() {
        int[] arr = getArrayFromUser();
        System.out.println("\n--- Flash Sort ---");
        int n = arr.length;
        if (n == 0) return;
        int m = Math.max(1, (int) (0.45 * n));
        int[] l = new int[m];
        int min = arr[0], maxIdx = 0;
        for (int i = 1; i < n; i++) {
            if (arr[i] < min) min = arr[i];
            if (arr[i] > arr[maxIdx]) maxIdx = i;
        }
        if (min == arr[maxIdx]) { printArray(arr); return; }
        double c1 = (double) (m - 1) / (arr[maxIdx] - min);
        for (int i = 0; i < n; i++) l[(int) (c1 * (arr[i] - min))]++;
        for (int i = 1; i < m; i++) l[i] += l[i - 1];
        swap(arr, maxIdx, 0);
        int nmove = 0, j = 0, k = m - 1;
        while (nmove < n - 1) {
            while (j > l[k] - 1) { j++; k = (int) (c1 * (arr[j] - min)); }
            int flash = arr[j];
            while (j != l[k]) {
                k = (int) (c1 * (flash - min));
                int hold = arr[--l[k]];
                arr[l[k]] = flash;
                flash = hold;
                nmove++;
            }
        }
        InsertionSortNoInput(arr);
        printArray(arr);
    }

    // 16. Comb Sort
    public void CombSort() {
        int[] arr = getArrayFromUser();
        System.out.println("\n--- Comb Sort ---");
        int gap = arr.length;
        boolean swapped = true;
        while (gap != 1 || swapped) {
            gap = (gap * 10) / 13;
            if (gap < 1) gap = 1;
            swapped = false;
            for (int i = 0; i < arr.length - gap; i++) {
                if (arr[i] > arr[i + gap]) { swap(arr, i, i + gap); swapped = true; }
            }
        }
        printArray(arr);
    }

    // 17. Gnome Sort
    public void GnomeSort() {
        int[] arr = getArrayFromUser();
        System.out.println("\n--- Gnome Sort ---");
        int index = 0;
        while (index < arr.length) {
            if (index == 0 || arr[index] >= arr[index - 1]) index++;
            else { swap(arr, index, index - 1); index--; }
        }
        printArray(arr);
    }

    // 18. Permutation Sort (Generating permutations until sorted)
    public void PermutationSort() {
        int[] arr = getArrayFromUser();
        System.out.println("\n--- Permutation Sort ---");
        Random rand = new Random();
        while (!isSorted(arr)) {
            swap(arr, rand.nextInt(arr.length), rand.nextInt(arr.length));
        }
        printArray(arr);
    }

    // 19. Strand Sort
    public void StrandSort() {
        int[] arr = getArrayFromUser();
        System.out.println("\n--- Strand Sort ---");
        List<Integer> list = new ArrayList<>();
        for (int x : arr) list.add(x);
        List<Integer> result = strandSortHelper(list);
        for (int i = 0; i < arr.length; i++) arr[i] = result.get(i);
        printArray(arr);
    }

    private List<Integer> strandSortHelper(List<Integer> list) {
        if (list.isEmpty()) return new ArrayList<>();
        List<Integer> sublist = new ArrayList<>();
        sublist.add(list.remove(0));
        for (int i = 0; i < list.size(); ) {
            if (list.get(i) > sublist.get(sublist.size() - 1)) sublist.add(list.remove(i));
            else i++;
        }
        List<Integer> sortedPart = strandSortHelper(list);
        return mergeLists(sublist, sortedPart);
    }

    private List<Integer> mergeLists(List<Integer> a, List<Integer> b) {
        List<Integer> res = new ArrayList<>();
        while (!a.isEmpty() && !b.isEmpty()) {
            if (a.get(0) <= b.get(0)) res.add(a.remove(0));
            else res.add(b.remove(0));
        }
        res.addAll(a); res.addAll(b);
        return res;
    }

    // 20. Bucket Sort
    public void BucketSort() {
        int[] arr = getArrayFromUser();
        System.out.println("\n--- Bucket Sort ---");
        int n = arr.length;
        if (n <= 0) return;
        int max = Arrays.stream(arr).max().getAsInt();
        int min = Arrays.stream(arr).min().getAsInt();
        int bucketCount = (max - min) / n + 1;
        List<List<Integer>> buckets = new ArrayList<>(bucketCount);
        for (int i = 0; i < bucketCount; i++) buckets.add(new ArrayList<>());
        for (int x : arr) buckets.get((x - min) / n).add(x);
        int index = 0;
        for (List<Integer> bucket : buckets) {
            Collections.sort(bucket);
            for (int x : bucket) arr[index++] = x;
        }
        printArray(arr);
    }

    // --- HELPER METHODS ---

    private int[] getArrayFromUser() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter array size: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.print("Enter " + n + " elements: ");
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();
        return arr;
    }

    private void printArray(int[] arr) {
        System.out.print("Sorted: ");
        for (int x : arr) System.out.print(x + " ");
        System.out.println();
    }

    private boolean isSorted(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) return false;
        }
        return true;
    }

    private void InsertionSortNoInput(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i], j = i - 1;
            while (j >= 0 && arr[j] > key) { arr[j + 1] = arr[j]; j--; }
            arr[j + 1] = key;
        }
    }
}
