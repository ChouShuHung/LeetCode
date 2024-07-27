package graph;

public class CountConnectedComponents {
    public static void main(String[] args) {
        int[][] edges1 = new int[][] {{0, 1}, {0, 2}, {0, 3}};
        int[][] edges2 = new int[][] {{0, 1}, {1, 2}, {2, 3}, {4, 5}, {1,2}};
        int[][] edges3 = new int[][] {{0, 1}, {2, 3}, {4, 5}, {1, 2}, {3, 4}};
        // System.out.println(countComponents(4, edges1)); // 1
        System.out.println(countComponents(6, edges2)); // 2
        // System.out.println(countComponents(6, edges3)); // 1
        System.out.println(countComponents(1, new int[][] {})); // 1
    }

    public static int countComponents(int n, int[][] edges) {
        if (n > 0 && edges.length == 0)
            return n;
        int[] parent = new int[n];
        int[] rank = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 1;
        }

        int result = n;
        for (int[] edge : edges) {
            // Union find
            int root1 = find(parent, edge[0]);
            int root2 = find(parent, edge[1]);

            if (root1 == root2)
                continue;

            if (rank[root2] > rank[root1]) {
                parent[root1] = root2;
                rank[root2] += rank[root1];
            } else {
                parent[root2] = root1;
                rank[root1] += rank[root2];
            }
            result--;
        }
        return result;
    }

    private static int find(int[] parent, int i) {
        if (parent[i] != i) {
            parent[i] = find(parent, parent[i]);
        }

        return parent[i];
    }
}
