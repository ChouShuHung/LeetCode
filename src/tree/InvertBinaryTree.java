package tree;

import java.util.Arrays;

public class InvertBinaryTree {

  public static void main(String[] args) {
    TreeNode root = TreeNode.createTree(Arrays.asList(4, 2, 7, 1, 3, 6, 9));
    TreeNode.printTree(root);
  }

  public TreeNode invertTree(TreeNode root) {
    if (root == null) return null;
    TreeNode node = new TreeNode(root.val);
    node.right = invertTree(root.left);
    node.left = invertTree(root.right);
    return node;
  }
}
