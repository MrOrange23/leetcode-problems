package my.playground.leetcode._1038_binar_search_tree_to_greater_sum_tree;

import my.playground.leetcode.TreeNode;

public class Solution {

  public TreeNode bstToGst(TreeNode root) {
    int sum = sum(root.right);
  }

  private int sum(TreeNode node) {
    if (node == null)
      return 0;

    return node.val
        + (node.left != null ? sum(node.left) : 0)
        + (node.right != null ? sum(node.right) : 0);
  }


  private int[] source(int max) {
    int[] result = new int[max + 1];
    int sum = 0;
    while(max >= 0) {
      sum += max;
      result[max] = sum;
      max--;
    }
    return result;
  }

}
