package tree;

import java.util.Arrays;

public class ValidateBST {

  public static void main(String[] args) {
    TreeNode root = TreeNode.createBinaryTree(Arrays.asList(2, 1, 3));
    // System.out.println(isValidBST(root));
    root = TreeNode.createBinaryTree(Arrays.asList(5, 4, 6, null, null, 3, 7));
    System.out.println(isValidBST(root));
  }

  public static boolean isValidBST(TreeNode root) {
    return dfs(root, null, null);
  }

  private static boolean dfs(TreeNode root, Integer min, Integer max) {
    if (root == null) return true;

    // Left part should less than the max
    // right part should greater than the min
    // Otherwise is violated BST

    if (max != null && root.val >= max || min != null && root.val <= min) {
      return false;
    }
    return dfs(root.left, min, root.val) && dfs(root.right, root.val, max);
  }
}
