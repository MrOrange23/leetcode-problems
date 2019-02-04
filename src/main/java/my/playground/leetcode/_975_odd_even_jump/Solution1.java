package my.playground.leetcode._975_odd_even_jump;

import java.util.HashSet;
import java.util.Set;

public class Solution1 {

  public static void main(String... args) {
    int[] A = new int[]{5,1,3,4,2};
    System.out.println(oddEvenJumps(A));
  }

  static int oddEvenJumps(int[] A) {
    int count = 0;
    for (int i = 0; i < A.length; i++) {
      count += jump(i, A, true);
    }
    return count;
  }

  static Set<Integer> deadIndexes = new HashSet<>();

  static int jump(int index, int[] A, boolean isOddJump) {
    if (index == A.length - 1) {
      return 1;
    }
    if (isOddJump) {
      int smallestValue = Integer.MAX_VALUE;
      int smallestIndex = -1;
      for (int i = index + 1; i < A.length; i++) {
        if (A[index] <= A[i] && A[i] < smallestValue) {
          smallestValue = A[i];
          smallestIndex = i;
        }
      }
      if (smallestIndex == -1) {
        deadIndexes.add(smallestIndex);
        return 0;
      } else {
        return jump(smallestIndex, A, !isOddJump);
      }
    } else {
      int largestValue = Integer.MIN_VALUE;
      int largestIndex = -1;
      for (int i = index + 1; i < A.length; i++) {
        if (A[index] >= A[i] && A[i] > largestValue) {
          largestValue = A[i];
          largestIndex = i;
        }
      }
      if (largestIndex == -1) {
        deadIndexes.add(largestIndex);
        return 0;
      } else {
        return jump(largestIndex, A, !isOddJump);
      }
    }
  }

}
