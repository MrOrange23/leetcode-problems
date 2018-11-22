package my.playground.leetcode._920_three_equal_parts;

public class Solution {

  public static void main(String[] args) {
    Solution s = new Solution();
    //System.out.println(s.threeEqualParts(new int[] {1,0,1,0,1}));
    //System.out.println(s.threeEqualParts(new int[] {0,0,0,0,0}));
    //System.out.println(s.threeEqualParts(new int[] {0,1,1,0,0,0,0,0,1,0,0,1,0,0,1}));
    //System.out.println(s.threeEqualParts(new int[] {0,1,0,1,1}));
    //System.out.println(s.threeEqualParts(new int[] {0,1,0,1,1,0,1,1,0,1}));
  }

  public int[] threeEqualParts(int[] A) {
    int L_index = findFirstReal(A, 0);

    if (L_index == -1)
      return new int[] {0, A.length - 1};

    int length = 1;

    while(A.length - L_index >= (length * 3)) {
      int M_index = findFirstReal(A, L_index + length);
      int R_index = findFirstReal(A, M_index + length);

      if (equals(A, L_index, M_index, R_index, length) && R_index + length == A.length)
        return new int[] {L_index + length - 1, M_index + length};

      length++;
    }
    return new int[] {-1, -1};
  }

  int findFirstReal(int[] A, int startPosition) {
    for (int i = startPosition; i < A.length; i++)
      if (A[i] == 1)
        return i;

    return -1;
  }

  boolean equals(int[] source, int L_index, int M_index, int R_index, int length) {
    for (int i = 0; i < length; i++)
      if (source[L_index + i] != source[M_index + i] || source[M_index + i] != source[R_index + i])
        return false;

    return true;
  }

}
