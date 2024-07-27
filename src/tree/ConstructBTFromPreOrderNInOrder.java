package tree;

import java.util.Arrays;

public class ConstructBTFromPreOrderNInOrder {

  public static void main(String[] args) {
    int[] preorder = { 3, 9, 20, 15, 7 }, inorder = { 9, 3, 15, 20, 7 };
    TreeNode.printTree(buildTree(preorder, inorder));
  }

  // preorder starts from root
  // inorder starts from root.left
  public static TreeNode buildTree(int[] preorder, int[] inorder) {
    if (preorder.length == 0 || inorder.length == 0) return null;

    TreeNode root = new TreeNode(preorder[0]);

    int mid = 0;
    for (int i = 0; i < inorder.length; i++) {
      if (root.val == inorder[i]) {
        mid = i;
      }
    }
    root.left =
      buildTree(
        Arrays.copyOfRange(preorder, 1, mid + 1),
        Arrays.copyOfRange(inorder, 0, mid)
      );
    root.right =
      buildTree(
        Arrays.copyOfRange(preorder, mid + 1, preorder.length),
        Arrays.copyOfRange(inorder, mid + 1, inorder.length)
      );
    return root;
  }

  static int p;
  static int i;

  public static TreeNode buildTree100(int[] preorder, int[] inorder) {
      p = 0;
      i = 0;
      return build(preorder, inorder, Integer.MIN_VALUE);
  }

  private static TreeNode build(int[] preorder, int[] inorder, int stop) {
      if(p == preorder.length) {
          return null;
      }

      if(inorder[i] == stop) {
          i++;
          return null;
      }

      TreeNode root = new TreeNode(preorder[p]);
      p++;
      root.left = build(preorder, inorder, root.val);
      root.right = build(preorder, inorder, stop);

      return root;
  }
}
