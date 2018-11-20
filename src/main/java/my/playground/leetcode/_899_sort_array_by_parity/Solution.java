package my.playground.leetcode._899_sort_array_by_parity;

public class Solution {

  public static void main(String[] args) {
    System.out.println(new Solution().sortArrayByParity(new int[] {3,1,2,4}));
  }

  public int[] sortArrayByParity(int[] A) {
    int L_index = -1;

    for (int i = 0; i < A.length; i++) {
      if (A[i] % 2 != 0) {
        if (L_index == -1) {
          L_index = i;
        }
        continue;
      }

      if (L_index != -1) {
        int buffer = A[L_index];
        A[L_index] = A[i];
        A[i] = buffer;
        L_index++;
      }
    }

    return A;
  }

}
