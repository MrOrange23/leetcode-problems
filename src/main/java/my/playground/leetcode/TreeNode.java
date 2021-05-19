package my.playground.leetcode;

public class TreeNode {

  public int val;
  public TreeNode left;
  public TreeNode right;

  public TreeNode(int x) {
    val = x;
  }


  public static void main(String[] args) {
    for (int i = 0; i <= 100; i++) {
      System.out.println("i=" + i + " fib = " + fib(i));
    }
  }

  static long fib(int n) {
    if (n == 0)
      return 0;

    if (n <= 2)
      return 1;

    long[] arr = new long[n + 1];
    arr[0] = 0;
    arr[1] = 1;
    arr[2] = 1;

    for (int i = 3; i <= n; i ++) {
      arr[i] = arr[i - 1] + arr[i - 2];
    }

    return arr[n];
  }

}
