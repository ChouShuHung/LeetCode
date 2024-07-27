package tree;

import java.util.Arrays;

public class LowestComonAncestorOfBST {

  public static void main(String[] args) {
    TreeNode root = TreeNode.createBinaryTree(
      Arrays.asList(6, 2, 8, 0, 4, 7, 9, null, null, 3, 5)
    );
    System.out.println(
      lowestCommonAncestor(root, new TreeNode(2), new TreeNode(8)).val
    );
  }

  public static TreeNode lowestCommonAncestor(
    TreeNode root,
    TreeNode p,
    TreeNode q
  ) {
    if (p.val > root.val && q.val > root.val) return lowestCommonAncestor(
      root.right,
      p,
      q
    );
    if (p.val < root.val && q.val < root.val) return lowestCommonAncestor(
      root.left,
      p,
      q
    );
    return root;
  }
}
