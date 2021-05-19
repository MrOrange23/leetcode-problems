package my.playground.leetcode._968_binnary_tree_cameras;

import my.playground.leetcode.TreeNode;

public class Solution {

  public int minCameraCover(TreeNode root) {
    return calc(root.left, root.right, true);
  }

  private int calc(TreeNode left, TreeNode right, boolean isIntermediate) {
    if (left == null && right == null)
      return 0;

    if (!isIntermediate)
      return (left != null ? calc(left.left, left.right, true) : 0)
           + (right != null ? calc(right.left, right.right, true) : 0);

    return ((left != null && right != null) && (hasChild(left) || hasChild(right)) ? 2 : 1)
        + (left != null ? calc(left.left, left.right, false) : 0)
        + (right != null ? calc(right.left, right.right, false) : 0);
  }

  private boolean hasChild(TreeNode node) {
    return node.left != null || node.right != null;
  }

  public static void main(String[] args) {
    System.out.println();
  }

}
