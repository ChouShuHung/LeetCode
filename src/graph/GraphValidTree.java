package graph;

public class GraphValidTree {

    public static void main(String[] args) {
        int[][] edges = {{0, 1}, {2, 3}};
        // int[][] edges = {{0, 1}, {0, 2}, {0, 3}, {1, 4}};
        // int[][] edges = {{0, 1}, {1, 2}, {2, 3}, {1, 3}, {1, 4}};
        System.out.println(validTree(4, edges));
        // System.out.println(validTree(5, edges));
    }

    /**
     * Overall, the code checks for cycles in a graph by using a disjoint set data structure and
     * path compression to find the root of each node.
     * 
     * Disjoint-set/Union-find forest(minimun cost[Kruskal] or no cycle) Graph = (vertex, edge) G =
     * (V,E)
     * 
     * @param n
     * @param edges
     * @return
     */
    public static boolean validTree(int n, int[][] edges) {
        // This is to ensure that the graph is a valid tree
        // because a tree with n nodes will have n-1 edges to be connected.
        // if (edges.length >= n)
        if (edges.length != n - 1)
            return false; // Check if the number of edges is n-1

        // disjoint set data structure to keep track of the connected components in the graph.
        // Each node in the graph is initially its own parent.
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        // When an edge is added to the graph,
        // the code checks if the two nodes are already connected.
        // If they are, then there is a cycle and the method returns false.
        // Otherwise, the code unions the two nodes' parent sets.
        for (int[] edge : edges) {
            int root1 = find(parent, edge[0]);
            int root2 = find(parent, edge[1]);
            if (root1 == root2)
                return false; // Check for cycles
            parent[root1] = root2;
        }
        return true;
    }

    // The code finds the root of a node by repeatedly
    // following the parent pointers until it reaches a node
    // whose parent is itself.
    // This is done by path compression,
    // which reduces the height of the tree by making each node point directly to the root.
    private static int find(int[] parent, int i) {
        if (parent[i] != i) {
            parent[i] = find(parent, parent[i]);
        }
        return parent[i];
    }
}
