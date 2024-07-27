package tree;

import java.util.Arrays;

public class SerializeAndDeserializeBT {

  static int maxSum = Integer.MIN_VALUE;

  public static void main(String[] args) {
    TreeNode root = TreeNode.createBinaryTree(
      Arrays.asList(1, 2, 3, null, null, 4, 5)
    );
    // TreeNode.printTree(root);
    // Codec ser = new Codec();
    // Codec deser = new Codec();
    // TreeNode ans = deser.deserialize(ser.serialize(root));
    // TreeNode.printTree(ans);
  }

  //todo
  static class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
      if (root == null) {
        return "N";
      }
      return (
        String.valueOf(root.val) + serialize(root.left) + serialize(root.right)
      );
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
      if (data == null || data.isEmpty()) return null;
      Integer value = "N".equals(String.valueOf(data.charAt(0)))
        ? null
        : Character.getNumericValue(data.charAt(0));
      if (value == null) return null;
      TreeNode root = new TreeNode(value);
      data = data.length() == 1 ? data : data.substring(1);
      root.left = deserialize(data);
      root.right = deserialize(data);
      return root;
    }
  }
}
