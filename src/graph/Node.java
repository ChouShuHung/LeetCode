package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Node {

  public int val;
  public List<Node> neighbors;

  public Node() {
    val = 0;
    neighbors = new ArrayList<>();
  }

  public Node(int _val) {
    val = _val;
    neighbors = new ArrayList<>();
  }

  public Node(int _val, List<Node> _neighbors) {
    val = _val;
    neighbors = _neighbors;
  }

  public static Node createNode(int[][] adjacencyList) {
    if (adjacencyList == null || adjacencyList.length == 0) return null;

    Map<Integer, Node> map = new HashMap<>();
    for (int i = 1; i <= adjacencyList.length; i++) {
      map.put(i, new Node(i));
    }

    for (int i = 0; i < adjacencyList.length; i++) {
      Node node = map.get(i + 1);
      for (int neighbor : adjacencyList[i]) {
        node.neighbors.add(map.get(neighbor));
      }
    }

    return map.get(1);
  }

  public static String printNeighbors(Node node) {
    if (node == null) return "[]";

    Set<Node> visited = new HashSet<>();
    StringBuilder result = new StringBuilder("[");
    dfs(node, visited, result);
    result.setCharAt(result.length() - 1, ']');

    return result.toString();
  }

  private static void dfs(Node node, Set<Node> visited, StringBuilder result) {
    if (visited.contains(node)) return;
    visited.add(node);

    result.append(node.val).append(": [");
    for (Node neighbor : node.neighbors) {
      dfs(neighbor, visited, result);
      result.append(", ");
    }
    if (result.charAt(result.length() - 2) == ',') {
      result.setLength(result.length() - 2);
    }
    result.append("], ");
  }

}
