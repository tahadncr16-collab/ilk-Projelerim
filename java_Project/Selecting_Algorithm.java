import java.util.Scanner;
import java.util.*;
class BSTNode {
    int key;
    BSTNode left, right;
    public BSTNode(int item) {
        key = item;
        left = right = null;
    }
}
class Edge implements Comparable<Edge> {
    int source, dest, weight;
    public Edge(int s, int d, int w) { source = s; dest = d; weight = w; }
    public int compareTo(Edge other) { return this.weight - other.weight; }
}
public class Selecting_Algorithm {
    public void Algorithm_ofSelecting() {
        Scanner input = new Scanner(System.in);
        int choice3;
        System.out.println("\n--- SEARCH AND GRAPH ALGORITHMS MENU ---");
        System.out.println("1- Linear Search ");
        System.out.println("2- Binary Search ");
        System.out.println("3- Interpolation Search ");
        System.out.println("4- Graph Algorithms ");
        System.out.println("5- Uniform Cost Search ");
        System.out.println("6- Floyd-Warshall Algorithm");
        System.out.println("7- Prim's Algorithm");
        System.out.println("8- Kruskal's Algorithm");
        System.out.println("9- Dijkstra's Algorithm");
        System.out.println("10- Bellman-Ford Algorithm");
        System.out.println("11- Binary Search Tree ");
        System.out.println("12- Prufer Sequence ");
        System.out.println("13- Text Search Algorithms ");
        System.out.println("14- Horspool Search Algorithm");
        System.out.println("15- Brute Force Text Search ");
        System.out.print("\nPlease enter an algorithm number: ");
        choice3 = input.nextInt();
        switch (choice3) {
            case 1:
                LinearSearch();
                break;
            case 2:
                BinarySearch();
                break;
            case 3:
                InterpolationSearch();
                break;
            case 4:
                GraphAlgorithms();
                break;
            case 5:
                UniformCostSearch();
                break;
            case 6:
                FloydWarshall();
                break;
            case 7:
                PrimsAlgorithm();
                break;
            case 8:
                KruskalsAlgorithm();
                break;
            case 9:
                DijkstraAlgorithm();
                break;
            case 10:
                BellmanFordAlgorithm();
                break;
            case 11:
                BinarySearchTree();
                break;
            case 12:
                PruferSequence();
                break;
            case 13:
                TextSearchAlgorithms();
                break;
            case 14:
                HorspoolSearch();
                break;
            case 15:
                BruteForceSearch();
                break;
            default:
                System.out.println("Invalid selection!");
                break;
        }
    }
    public void LinearSearch() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\n--- Linear Search ---");
        System.out.print("Enter array size: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.print("Enter " + n + " elements: ");
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();
        System.out.print("Enter value to find: ");
        int target = sc.nextInt();

        boolean found = false;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                System.out.println("Value " + target + " found at index: " + i);
                found = true;
            }
        }
        if (!found) System.out.println("Value " + target + " not found.");
    }
    public void BinarySearch() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\n--- Binary Search ---");
        System.out.print("Enter array size: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.print("Enter " + n + " elements: ");
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();
        Arrays.sort(arr);
        System.out.print("Enter value to find: ");
        int target = sc.nextInt();

        int low = 0, high = arr.length - 1;
        boolean found = false;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == target) {
                System.out.println("Value " + target + " found at index: " + mid + " (after sorting)");
                found = true;
                break;
            }
            if (arr[mid] < target) low = mid + 1;
            else high = mid - 1;
        }
        if (!found) System.out.println("Value " + target + " not found.");
    }
    public void InterpolationSearch() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\n--- Interpolation Search ---");
        System.out.print("Enter array size: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.print("Enter " + n + " elements: ");
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();
        Arrays.sort(arr);
        System.out.print("Enter value to find: ");
        int target = sc.nextInt();

        int low = 0, high = arr.length - 1;
        boolean found = false;
        while (low <= high && target >= arr[low] && target <= arr[high]) {
            if (low == high) {
                if (arr[low] == target) {
                    System.out.println("Value " + target + " found at index: " + low);
                    found = true;
                }
                break;
            }
            if (arr[high] == arr[low]) {
                if (arr[low] == target) {
                    System.out.println("Value " + target + " found at index: " + low);
                    found = true;
                }
                break;
            }
            int pos = low + (((high - low) / (arr[high] - arr[low])) * (target - arr[low]));
            if (arr[pos] == target) {
                System.out.println("Value " + target + " found at index: " + pos + " (after sorting)");
                found = true;
                break;
            }
            if (arr[pos] < target) low = pos + 1;
            else high = pos - 1;
        }
        if (!found) System.out.println("Value " + target + " not found.");
    }
    public void GraphAlgorithms() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\n--- Graph Algorithms (BFS & DFS) ---");
        System.out.print("Enter number of nodes: ");
        int V = sc.nextInt();
        System.out.print("Enter number of edges: ");
        int E = sc.nextInt();

        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());

        System.out.println("Enter edges (u v):");
        for (int i = 0; i < E; i++) {
            int u = sc.nextInt(), v = sc.nextInt();
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        System.out.print("Enter start node: ");
        int start = sc.nextInt();

        // BFS
        System.out.print("BFS: ");
        boolean[] visitedBFS = new boolean[V];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visitedBFS[start] = true;
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            System.out.print(curr + " ");
            for (int neighbor : adj.get(curr))
                if (!visitedBFS[neighbor]) {
                    visitedBFS[neighbor] = true;
                    queue.add(neighbor);
                }
        }
        System.out.println();

        // DFS
        System.out.print("DFS: ");
        boolean[] visitedDFS = new boolean[V];
        dfsHelper(adj, start, visitedDFS);
        System.out.println();
    }

    private void dfsHelper(List<List<Integer>> adj, int node, boolean[] visited) {
        visited[node] = true;
        System.out.print(node + " ");
        for (int neighbor : adj.get(node))
            if (!visited[neighbor])
                dfsHelper(adj, neighbor, visited);
    }
    public void UniformCostSearch() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\n--- Uniform Cost Search ---");
        System.out.print("Enter number of nodes: ");
        int V = sc.nextInt();
        System.out.print("Enter number of edges: ");
        int E = sc.nextInt();

        List<int[]>[] graph = new ArrayList[V];
        for (int i = 0; i < V; i++) graph[i] = new ArrayList<>();

        System.out.println("Enter edges (source destination weight):");
        for (int i = 0; i < E; i++) {
            int u = sc.nextInt(), v = sc.nextInt(), w = sc.nextInt();
            graph[u].add(new int[]{v, w});
            graph[v].add(new int[]{u, w});
        }

        System.out.print("Enter start node: ");
        int start = sc.nextInt();
        System.out.print("Enter goal node: ");
        int goal = sc.nextInt();

        int[] cost = new int[V];
        Arrays.fill(cost, Integer.MAX_VALUE);
        cost[start] = 0;
        int[] parent = new int[V];
        Arrays.fill(parent, -1);
        boolean[] visited = new boolean[V];

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.add(new int[]{start, 0});

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int node = curr[0];
            if (visited[node]) continue;
            visited[node] = true;
            if (node == goal) break;
            for (int[] neighbor : graph[node]) {
                int next = neighbor[0], weight = neighbor[1];
                if (!visited[next] && cost[node] + weight < cost[next]) {
                    cost[next] = cost[node] + weight;
                    parent[next] = node;
                    pq.add(new int[]{next, cost[next]});
                }
            }
        }

        if (cost[goal] == Integer.MAX_VALUE) {
            System.out.println("No path found from " + start + " to " + goal);
        } else {
            System.out.println("Minimum cost: " + cost[goal]);
            List<Integer> path = new ArrayList<>();
            for (int at = goal; at != -1; at = parent[at]) path.add(at);
            Collections.reverse(path);
            System.out.println("Path: " + path);
        }
    }
    public void FloydWarshall() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\n--- Floyd-Warshall Algorithm ---");
        System.out.print("Enter number of vertices: ");
        int V = sc.nextInt();
        int INF = 99999;
        int[][] dist = new int[V][V];

        for (int i = 0; i < V; i++) Arrays.fill(dist[i], INF);
        for (int i = 0; i < V; i++) dist[i][i] = 0;

        System.out.print("Enter number of edges: ");
        int E = sc.nextInt();
        System.out.println("Enter edges (source destination weight):");
        for (int i = 0; i < E; i++) {
            int u = sc.nextInt(), v = sc.nextInt(), w = sc.nextInt();
            dist[u][v] = w;
            dist[v][u] = w;
        }

        for (int k = 0; k < V; k++)
            for (int i = 0; i < V; i++)
                for (int j = 0; j < V; j++)
                    if (dist[i][k] != INF && dist[k][j] != INF)
                        dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);

        System.out.println("Shortest distances matrix:");
        System.out.print("     ");
        for (int i = 0; i < V; i++) System.out.printf("%6d", i);
        System.out.println();
        for (int i = 0; i < V; i++) {
            System.out.printf("%4d:", i);
            for (int j = 0; j < V; j++)
                System.out.printf("%6s", dist[i][j] == INF ? "INF" : dist[i][j]);
            System.out.println();
        }
    }
    public void PrimsAlgorithm() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\n--- Prim's Algorithm (MST) ---");
        System.out.print("Enter number of vertices: ");
        int V = sc.nextInt();
        int INF = 99999;
        int[][] graph = new int[V][V];

        System.out.print("Enter number of edges: ");
        int E = sc.nextInt();
        System.out.println("Enter edges (source destination weight):");
        for (int i = 0; i < E; i++) {
            int u = sc.nextInt(), v = sc.nextInt(), w = sc.nextInt();
            graph[u][v] = w;
            graph[v][u] = w;
        }

        int[] key = new int[V];
        int[] parent = new int[V];
        boolean[] inMST = new boolean[V];
        Arrays.fill(key, INF);
        key[0] = 0;
        parent[0] = -1;

        for (int count = 0; count < V - 1; count++) {
            int u = -1;
            for (int v = 0; v < V; v++)
                if (!inMST[v] && (u == -1 || key[v] < key[u])) u = v;
            inMST[u] = true;
            for (int v = 0; v < V; v++)
                if (graph[u][v] != 0 && !inMST[v] && graph[u][v] < key[v]) {
                    key[v] = graph[u][v];
                    parent[v] = u;
                }
        }

        int totalWeight = 0;
        System.out.println("MST Edges:");
        for (int i = 1; i < V; i++) {
            System.out.println("  " + parent[i] + " -- " + i + "  weight: " + graph[parent[i]][i]);
            totalWeight += graph[parent[i]][i];
        }
        System.out.println("Total MST weight: " + totalWeight);
    }
    public void KruskalsAlgorithm() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\n--- Kruskal's Algorithm (MST) ---");
        System.out.print("Enter number of vertices: ");
        int V = sc.nextInt();
        System.out.print("Enter number of edges: ");
        int E = sc.nextInt();

        List<Edge> edges = new ArrayList<>();
        System.out.println("Enter edges (source destination weight):");
        for (int i = 0; i < E; i++) {
            int u = sc.nextInt(), v = sc.nextInt(), w = sc.nextInt();
            edges.add(new Edge(u, v, w));
        }
        Collections.sort(edges);

        int[] parent = new int[V];
        int[] rank = new int[V];
        for (int i = 0; i < V; i++) parent[i] = i;

        int totalWeight = 0;
        int edgeCount = 0;
        System.out.println("MST Edges:");
        for (Edge e : edges) {
            if (edgeCount == V - 1) break;
            int rootU = findParent(parent, e.source);
            int rootV = findParent(parent, e.dest);
            if (rootU != rootV) {
                System.out.println("  " + e.source + " -- " + e.dest + "  weight: " + e.weight);
                totalWeight += e.weight;
                edgeCount++;
                if (rank[rootU] < rank[rootV]) parent[rootU] = rootV;
                else if (rank[rootU] > rank[rootV]) parent[rootV] = rootU;
                else { parent[rootV] = rootU; rank[rootU]++; }
            }
        }
        System.out.println("Total MST weight: " + totalWeight);
    }

    private int findParent(int[] parent, int i) {
        if (parent[i] != i) parent[i] = findParent(parent, parent[i]);
        return parent[i];
    }
    public void DijkstraAlgorithm() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\n--- Dijkstra's Algorithm ---");
        System.out.print("Enter number of vertices: ");
        int V = sc.nextInt();
        System.out.print("Enter number of edges: ");
        int E = sc.nextInt();

        List<int[]>[] graph = new ArrayList[V];
        for (int i = 0; i < V; i++) graph[i] = new ArrayList<>();

        System.out.println("Enter edges (source destination weight):");
        for (int i = 0; i < E; i++) {
            int u = sc.nextInt(), v = sc.nextInt(), w = sc.nextInt();
            graph[u].add(new int[]{v, w});
            graph[v].add(new int[]{u, w});
        }

        System.out.print("Enter start node: ");
        int start = sc.nextInt();

        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        boolean[] visited = new boolean[V];
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.add(new int[]{start, 0});

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int u = curr[0], d = curr[1];
            if (visited[u]) continue;
            visited[u] = true;
            for (int[] neighbor : graph[u]) {
                int v = neighbor[0], w = neighbor[1];
                if (!visited[v] && dist[u] + w < dist[v]) {
                    dist[v] = dist[u] + w;
                    pq.add(new int[]{v, dist[v]});
                }
            }
        }

        System.out.println("Shortest distances from node " + start + ":");
        for (int i = 0; i < V; i++)
            System.out.println("  To node " + i + ": " + (dist[i] == Integer.MAX_VALUE ? "INF" : dist[i]));
    }

    public void BellmanFordAlgorithm() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\n--- Bellman-Ford Algorithm ---");
        System.out.print("Enter number of vertices: ");
        int V = sc.nextInt();
        System.out.print("Enter number of edges: ");
        int E = sc.nextInt();

        List<Edge> edges = new ArrayList<>();
        System.out.println("Enter edges (source destination weight, negative weights allowed):");
        for (int i = 0; i < E; i++) {
            int u = sc.nextInt(), v = sc.nextInt(), w = sc.nextInt();
            edges.add(new Edge(u, v, w));
        }

        System.out.print("Enter start node: ");
        int start = sc.nextInt();

        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        for (int i = 0; i < V - 1; i++)
            for (Edge e : edges)
                if (dist[e.source] != Integer.MAX_VALUE && dist[e.source] + e.weight < dist[e.dest])
                    dist[e.dest] = dist[e.source] + e.weight;

        boolean hasNegCycle = false;
        for (Edge e : edges)
            if (dist[e.source] != Integer.MAX_VALUE && dist[e.source] + e.weight < dist[e.dest]) {
                hasNegCycle = true;
                break;
            }

        if (hasNegCycle) {
            System.out.println("Negative weight cycle detected!");
        } else {
            System.out.println("Shortest distances from node " + start + ":");
            for (int i = 0; i < V; i++)
                System.out.println("  To node " + i + ": " + (dist[i] == Integer.MAX_VALUE ? "INF" : dist[i]));
        }
    }
    public void BinarySearchTree() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\n--- Binary Search Tree ---");
        System.out.print("Enter the number of values to insert: ");
        int n = sc.nextInt();

        System.out.print("Enter " + n + " values: ");
        BSTNode root = null;
        for (int i = 0; i < n; i++) {
            root = insertRec(root, sc.nextInt());
        }

        // Display traversals
        System.out.print("In-order traversal (sorted): ");
        inorderRec(root);
        System.out.println();

        System.out.print("Pre-order traversal        : ");
        preorderRec(root);
        System.out.println();

        System.out.print("Post-order traversal       : ");
        postorderRec(root);
        System.out.println();

        // Search operation
        System.out.print("Enter a value to search for: ");
        int key = sc.nextInt();
        if (searchRec(root, key)) {
            System.out.println(key + " was found in the BST.");
        } else {
            System.out.println(key + " was not found in the BST.");
        }

        // Delete operation
        System.out.print("Enter a value to delete: ");
        int del = sc.nextInt();
        root = deleteRec(root, del);

        System.out.print("In-order traversal after deletion: ");
        inorderRec(root);
        System.out.println();
    }

    // Recursive helper method to insert a new key into the BST
    private BSTNode insertRec(BSTNode root, int key) {
        // If the tree is empty, return a new node
        if (root == null) {
            return new BSTNode(key);
        }

        // Otherwise, recur down the tree
        if (key < root.key) {
            root.left = insertRec(root.left, key);
        } else if (key > root.key) {
            root.right = insertRec(root.right, key);
        }

        // Return the (unchanged) node pointer
        return root;
    }

    // Recursive helper method for in-order traversal (Left, Root, Right)
    private void inorderRec(BSTNode root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.key + " ");
            inorderRec(root.right);
        }
    }

    // Recursive helper method for pre-order traversal (Root, Left, Right)
    private void preorderRec(BSTNode root) {
        if (root != null) {
            System.out.print(root.key + " ");
            preorderRec(root.left);
            preorderRec(root.right);
        }
    }

    // Recursive helper method for post-order traversal (Left, Right, Root)
    private void postorderRec(BSTNode root) {
        if (root != null) {
            postorderRec(root.left);
            postorderRec(root.right);
            System.out.print(root.key + " ");
        }
    }

    // Recursive helper method to search for a key in the BST
    private boolean searchRec(BSTNode root, int key) {
        // Base Cases: root is null or key is present at root
        if (root == null) {
            return false;
        }
        if (root.key == key) {
            return true;
        }

        // Key is greater than root's key
        if (root.key < key) {
            return searchRec(root.right, key);
        }

        // Key is smaller than root's key
        return searchRec(root.left, key);
    }

    // Recursive helper method to delete a key from the BST
    private BSTNode deleteRec(BSTNode root, int key) {
        // Base Case: If the tree is empty
        if (root == null) {
            return null;
        }

        // Traverse the tree to find the node to delete
        if (key < root.key) {
            root.left = deleteRec(root.left, key);
        } else if (key > root.key) {
            root.right = deleteRec(root.right, key);
        } else {
            // Node with only one child or no child
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            // Node with two children: Get the inorder successor (smallest in the right subtree)
            BSTNode minNode = root.right;
            while (minNode.left != null) {
                minNode = minNode.left;
            }

            // Copy the inorder successor's content to this node
            root.key = minNode.key;

            // Delete the inorder successor
            root.right = deleteRec(root.right, minNode.key);
        }
        return root;
    }
    public void PruferSequence() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\n--- Prufer Sequence (Tree to Sequence) ---");
        System.out.print("Enter the number of nodes (V) in the tree: ");
        int V = sc.nextInt();

        // Bir Prüfer dizisi oluşturmak için ağaçta en az 3 düğüm olmalıdır.
        if (V <= 2) {
            System.out.println("Error: To create a purifier array, the tree must have more than two nodes.");
            return;
        }

        // Ağacın her bir düğümü için komşularını tutacağımız liste
        List<Set<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new HashSet<>());
        }

        // Her düğümün derecesini (bağlantı sayısını) tutan dizi
        int[] degree = new int[V];

        // Ağaçların her zaman (V-1) tane kenarı (edge) vardır.
        System.out.println((V - 1) + " Enter the edge (u v) leaving a space between them (0 and " + (V - 1) + " inter-):");
        for (int i = 0; i < V - 1; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            adj.get(u).add(v);
            adj.get(v).add(u);
            degree[u]++;
            degree[v]++;
        }

        System.out.print("Prufer Sequence: ");

        // V-2 adımda yaprakları kopararak diziyi oluşturacağız
        for (int i = 0; i < V - 2; i++) {
            int minLeaf = -1;

            // 1. Adım: Derecesi 1 olan (yaprak) en küçük numaralı düğümü bul
            for (int j = 0; j < V; j++) {
                if (degree[j] == 1) {
                    minLeaf = j;
                    break;
                }
            }

            // 2. Adım: Bu yaprağın tek komşusunu bul ve Prüfer dizisine yazdır
            int neighbor = adj.get(minLeaf).iterator().next();
            System.out.print(neighbor + " ");

            // 3. Adım: Yaprak düğümü ve komşusu arasındaki bağı kopar
            degree[minLeaf]--;     // Yaprağın derecesi 0 oldu
            degree[neighbor]--;    // Komşunun derecesi 1 azaldı
            adj.get(minLeaf).remove(neighbor);
            adj.get(neighbor).remove(minLeaf);
        }
        System.out.println(); // Yeni satır
    }
    // 13- Temel Metin Arama (Java'nın yerleşik fonksiyonu kullanılarak)
    public void TextSearchAlgorithms() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\n--- Text Search Algorithms ---");
        System.out.print("Enter the main text: ");
        sc.nextLine();
        String text = sc.nextLine();
        System.out.print("Enter the pattern: ");
        String pattern = sc.nextLine();

        if (pattern.isEmpty() || text.isEmpty()) {
            System.out.println("Text or pattern cannot be empty.");
            return;
        }

        // KMP
        System.out.println("\n[KMP Search]");
        int[] lps = buildLPS(pattern);
        int i = 0, j = 0;
        boolean found = false;
        while (i < text.length()) {
            if (text.charAt(i) == pattern.charAt(j)) { i++; j++; }
            if (j == pattern.length()) {
                System.out.println("Pattern found at index: " + (i - j));
                j = lps[j - 1];
                found = true;
            } else if (i < text.length() && text.charAt(i) != pattern.charAt(j)) {
                if (j != 0) j = lps[j - 1];
                else i++;
            }
        }
        if (!found) System.out.println("Pattern not found.");

        // Rabin-Karp
        System.out.println("\n[Rabin-Karp Search]");
        int d = 256, q = 101, m = pattern.length(), n = text.length();
        int h = 1, p = 0, t = 0;
        found = false;
        for (int k = 0; k < m - 1; k++) h = (h * d) % q;
        for (int k = 0; k < m; k++) {
            p = (d * p + pattern.charAt(k)) % q;
            t = (d * t + text.charAt(k)) % q;
        }
        for (int k = 0; k <= n - m; k++) {
            if (p == t && text.substring(k, k + m).equals(pattern)) {
                System.out.println("Pattern found at index: " + k);
                found = true;
            }
            if (k < n - m) {
                t = (d * (t - text.charAt(k) * h) + text.charAt(k + m)) % q;
                if (t < 0) t += q;
            }
        }
        if (!found) System.out.println("Pattern not found.");
    }

    private int[] buildLPS(String pattern) {
        int m = pattern.length();
        int[] lps = new int[m];
        int len = 0, i = 1;
        while (i < m) {
            if (pattern.charAt(i) == pattern.charAt(len)) { lps[i++] = ++len; }
            else { if (len != 0) len = lps[len - 1]; else lps[i++] = 0; }
        }
        return lps;
    }

    // 14- Horspool Arama Algoritması
    public void HorspoolSearch() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\n--- 14. Horspool Search Algorithm ---");
        System.out.print("Enter the main text: ");
        String text = sc.nextLine();
        System.out.print(" Enter the word (pattern) to search for:");
        String pattern = sc.nextLine();

        int n = text.length();
        int m = pattern.length();

        if (m == 0 || m > n) {
            System.out.println("Error: The search term cannot be 0 in length or greater than the main text length.");
            return;
        }

        // Shift (Kaydırma) tablosunu oluştur (Boyer-Moore-Horspool mantığı)
        int[] shift = new int[256];
        for (int i = 0; i < 256; i++) {
            shift[i] = m; // Varsayılan kaydırma miktarı desenin kendi uzunluğudur
        }
        for (int i = 0; i < m - 1; i++) {
            shift[pattern.charAt(i)] = m - 1 - i; // Desenin içindeki harflerin kaydırma değerlerini güncelle
        }

        // Arama İşlemi
        int i = m - 1; // Eşleşmeye desenin son harfinden başlanır
        boolean found = false;

        while (i < n) {
            int k = 0;
            // Desenin sonundan başına doğru harfleri karşılaştır
            while (k < m && pattern.charAt(m - 1 - k) == text.charAt(i - k)) {
                k++;
            }
            if (k == m) {
                System.out.println("Match found! Initial index: " + (i - m + 1));
                found = true;
                i += shift[text.charAt(i)]; // Eşleşme bulduktan sonra aramaya devam etmek için kaydır
            } else {
                // Eşleşmezse, metindeki mevcut harfe göre tabloya bakıp kaydır
                i += shift[text.charAt(i)];
            }
        }

        if (!found) {
            System.out.println("No matches found.");
        }
    }

    // 15- Brute Force (Kaba Kuvvet) Metin Arama Algoritması
    public void BruteForceSearch() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\n--- 15. Brute Force Text Search ---");
        System.out.print("Enter the main text: ");
        String text = sc.nextLine();
        System.out.print("Enter the word (pattern) to search for: ");
        String pattern = sc.nextLine();

        int n = text.length();
        int m = pattern.length();
        boolean found = false;

        // Metin üzerinde harf harf kayarak ilerle
        for (int i = 0; i <= n - m; i++) {
            int j = 0;
            // Desen ile metni karakter karakter karşılaştır
            while (j < m && text.charAt(i + j) == pattern.charAt(j)) {
                j++;
            }
            // Tüm karakterler eşleştiyse
            if (j == m) {
                System.out.println("Match found! Initial index: " + i);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No matches found.");
        }
    }


}