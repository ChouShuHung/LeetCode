package tree;

import java.util.Arrays;

public class SubtreeOfAnotherTree {

  public static void main(String[] args) {
    TreeNode root = TreeNode.createBinaryTree(
    //   Arrays.asList(3, 4, 5, 1, 2, null, null, null, null, 0)
      Arrays.asList(3, 4, 5, 1, 2)
    );
    TreeNode subRoot = TreeNode.createBinaryTree(Arrays.asList(4, 1, 2));
    System.out.println(isSubtree(root, subRoot));
  }

  public static boolean isSubtree(TreeNode root, TreeNode subRoot) {
    if (subRoot == null || isSameTree(root, subRoot)) return true;
    if (root == null) return false;
    return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
  }

  private static boolean isSameTree(TreeNode root, TreeNode subRoot) {
    if (root == null && subRoot == null) return true;
    if (root == null || subRoot == null) return false;
    if (root.val != subRoot.val) return false;
    return (
      isSameTree(root.left, subRoot.left) &&
      isSameTree(root.right, subRoot.right)
    );
  }
}
