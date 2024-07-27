package tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KthSmallestElementBST {

  public static void main(String[] args) {
    TreeNode root = TreeNode.createBinaryTree(Arrays.asList(1, null, 2));
    System.out.println(kthSmallest(root, 2));
  }

  // Given the root of a binary search tree, and an integer k,
  // return the kth smallest value (1-indexed) of all the values of the nodes in the tree.
  public static int kthSmallest(TreeNode root, int k) {
    if (root == null || k == 0) return 0;
    List<Integer> inorderBST = new ArrayList<>();
    getInOrderBST(root, inorderBST, k);
    return inorderBST.get(k - 1);
  }

  private static void getInOrderBST(
    TreeNode root,
    List<Integer> inorderBST,
    int k
  ) {
    if (inorderBST.size() >= k) return;
    if (root.left != null) getInOrderBST(root.left, inorderBST, k);
    inorderBST.add(root.val);
  }
}
