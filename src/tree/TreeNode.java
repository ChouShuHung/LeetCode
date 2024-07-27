package tree;

import java.util.List;

public class TreeNode {

  int val;
  TreeNode left;
  TreeNode right;

  TreeNode() {}

  TreeNode(int val) {
    this.val = val;
  }

  TreeNode(int val, TreeNode left, TreeNode right) {
    this.val = val;
    this.left = left;
    this.right = right;
  }

  public static TreeNode createTree(List<Integer> values) {
    // Create a tree based on the list of values
    if (values.isEmpty()) {
      return null;
    }
    TreeNode root = new TreeNode(values.get(0));
    TreeNode current = root;
    int index = 1;
    while (index < values.size()) {
      if (index % 2 == 1) {
        if (values.get(index) != null) {
          current.left = new TreeNode(values.get(index));
          current = current.left;
        }
        index++;
      } else {
        if (values.get(index) != null) {
          current.right = new TreeNode(values.get(index));
          current = current.right;
        }
        index++;
      }
    }
    return root;
  }
  public static TreeNode createBinaryTree(List<Integer> values) {
    return createBinaryTreeHelper(values, 0);
}
private static TreeNode createBinaryTreeHelper(List<Integer> values, int index) {
    if (values.isEmpty() || index >= values.size() || values.get(index) == null) {
        return null;
    }

    TreeNode node = new TreeNode(values.get(index));
    node.left = createBinaryTreeHelper(values, 2 * index + 1);
    node.right = createBinaryTreeHelper(values, 2 * index + 2);

    return node;
}

  public static void printTree(TreeNode root) {
    if (root == null) {
      return;
    }
    System.out.print(root.val + " ");
    printTree(root.left);
    printTree(root.right);
  }
}
