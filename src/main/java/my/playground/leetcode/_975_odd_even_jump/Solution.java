package my.playground.leetcode._975_odd_even_jump;

import java.util.HashSet;
import java.util.Set;

public class Solution {

  public static void main(String... args) {
    int[] A = new int[]{14,13,15};
    System.out.println(new Solution().oddEvenJumps(A));
  }

  public int oddEvenJumps(int[] A) {
    int count = 0;
    for (int i = 0; i < A.length; i++) {
      count += jump(i, A, true, new HashSet<>(), new HashSet<>());
    }
    return count;
  }

  Set<Integer> validOddIndexes = new HashSet<>();
  Set<Integer> validEvenIndexes = new HashSet<>();
  Set<Integer> deadEvenIndexes = new HashSet<>();
  Set<Integer> deadOddIndexes = new HashSet<>();

  int jump(int index, int[] A, boolean isOddJump, Set<Integer> oddIndexes, Set<Integer> evenIndexes) {
    if (index == A.length - 1) {
      validOddIndexes.addAll(oddIndexes);
      validEvenIndexes.addAll(evenIndexes);
      return 1;
    }

    if (isOddJump) {
      if (deadOddIndexes.contains(index))
        return 0;
      if (validOddIndexes.contains(index))
        return 1;

      int smallestValue = Integer.MAX_VALUE;
      int smallestIndex = -1;
      for (int i = index + 1; i < A.length; i++) {
        if (A[index] <= A[i] && A[i] < smallestValue) {
          smallestValue = A[i];
          smallestIndex = i;
        }
      }
      oddIndexes.add(index);

      if (smallestIndex == -1) {
        deadOddIndexes.addAll(oddIndexes);
        return 0;
      } else {
        return jump(smallestIndex, A, !isOddJump, oddIndexes, evenIndexes);
      }

    } else {
      if (deadEvenIndexes.contains(index))
        return 0;
      if (validEvenIndexes.contains(index))
        return 1;

      int largestValue = Integer.MIN_VALUE;
      int largestIndex = -1;
      for (int i = index + 1; i < A.length; i++) {
        if (A[index] >= A[i] && A[i] > largestValue) {
          largestValue = A[i];
          largestIndex = i;
        }
      }
      evenIndexes.add(index);

      if (largestIndex == -1) {
        deadEvenIndexes.addAll(evenIndexes);
        return 0;
      } else {
        return jump(largestIndex, A, !isOddJump, oddIndexes, evenIndexes);
      }
    }
  }


}
