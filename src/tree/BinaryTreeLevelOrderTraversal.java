package tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BinaryTreeLevelOrderTraversal {

  public static void main(String[] args) {
    TreeNode root = TreeNode.createBinaryTree(
      Arrays.asList(3, 9, 20, null, null, 15, 7)
    );
    System.out.println(levelOrder(root).toString());
  }

  public static List<List<Integer>> levelOrder(TreeNode root) {
    List<List<Integer>> levelOrders = new ArrayList<>();
    getLevelOfNode(levelOrders, root, 0);
    return levelOrders;
  }

  private static void getLevelOfNode(
    List<List<Integer>> levelOrders,
    TreeNode root,
    int index
  ) {
    if (root != null) {
      if (levelOrders.size() <= index) {
        levelOrders.add(new ArrayList<>());
      }
      levelOrders.get(index).add(root.val);

      if (root.left != null) getLevelOfNode(levelOrders, root.left, index + 1);
      if (root.right != null) getLevelOfNode(
        levelOrders,
        root.right,
        index + 1
      );
    }
  }
}
