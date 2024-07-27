package tree;

import java.util.Arrays;

public class MaxDepthBinaryTree {

  public static void main(String[] args) {
    TreeNode root = TreeNode.createBinaryTree(
      Arrays.asList(3, 9, 20, null, null, 15, 7)
    );
    // TreeNode.printTree(root);
    System.out.println(maxDepth(root));
  }

  public static int maxDepth(TreeNode root) {
    if (root == null) return 0;
    return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
  }
}
