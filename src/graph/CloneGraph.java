package graph;

import java.util.ArrayList;
import java.util.HashMap;

public class CloneGraph {

  public static HashMap<Node, Node> map = new HashMap<>();

  public static void main(String[] args) {
    Node node = Node.createNode(
      new int[][] { { 2, 4 }, { 1, 3 }, { 2, 4 }, { 1, 3 } }
    );
    System.out.println(Node.printNeighbors(cloneGraph(node)));
  }

  public static Node cloneGraph(Node node) {
    if (node == null) return null;

    if (map.containsKey(node)) return map.get(node);

    Node cloneNode = new Node(node.val, new ArrayList<>());
    map.put(node, cloneNode);

    for (Node neighbor : node.neighbors) {
      cloneNode.neighbors.add(cloneGraph(neighbor));
    }
    return cloneNode;
  }
}
