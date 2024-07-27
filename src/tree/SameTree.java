package tree;

import java.util.Arrays;

public class SameTree {

  public static void main(String[] args) {
    TreeNode p = TreeNode.createBinaryTree(Arrays.asList(1, null, 2));
    TreeNode q = TreeNode.createBinaryTree(Arrays.asList(1, 2, null));
    System.out.println(isSameTree(p, q));
  }

  public static boolean isSameTree(TreeNode p, TreeNode q) {
    if (p == null && q == null) return true;
    if (p == null || q == null) return false;
    if (p.val != q.val) return false;
    return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
  }
}
