package my.playground.leetcode._967_numbers_with_same_differences;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;

class Solution {

  public int[] numsSameConsecDiff(int N, int K) {
    if (N == 1)
      return new int[] {0,1,2,3,4,5,6,7,8,9};

    List<Integer> list = new ArrayList<>();
    for (int i = 1; i <= 9; i++) {
      if (i - K > 0) {
        list.add(toItem(i, i - K, N));
      }
      if (i + K <= 9) {
        list.add(toItem(i, i + K, N));
      }
    }

    return null;
  }

  private static int toItem(int first, int second, int count) {
    return 1;
  }

  public static void main(String... args) throws Exception {
    System.out.println(Arrays.toString(new Solution().numsSameConsecDiff(1, 2)));
  }
}