package my.playground.leetcode._890_monotonic_array;

public class Solution {

  public static void main(String[] args) {
    System.out.println(new Solution().isMonotonic(new int[] {5,3,2,4,1}));  // false
    System.out.println(new Solution().isMonotonic(new int[] {6,5,4,4}));    // true
  }

  public boolean isMonotonic(int[] A) {
    boolean grow = A[A.length - 1] - A[0] >= 0;

    int prev = A[0];
    for (int i : A) {
      if (i == prev) continue;

      if ((i - prev > 0) != grow)
        return false;

      prev = i;
    }
    return true;
  }

}
