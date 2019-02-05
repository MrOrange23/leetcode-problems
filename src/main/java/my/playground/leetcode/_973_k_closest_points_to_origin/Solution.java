package my.playground.leetcode._973_k_closest_points_to_origin;

import java.util.Collection;
import java.util.Iterator;
import java.util.SortedMap;
import java.util.TreeMap;

public class Solution {

  public int[][] kClosest(int[][] points, int K) {
    SortedMap<Integer, int[]> map = new TreeMap<>();

    for (int i = 0; i < points.length; i++) {
      int[] point = points[i];
      int distance = calcDistance(0, 0, point[0], point[1]);

      map.put(distance, point);
    }

    Collection<int[]> cc = map.values();
    int[][] res = new int[K][];

    int i = 0;
    Iterator<int[]> it = cc.iterator();
    while (i < K && it.hasNext()) {
      res[i] = it.next();
      i++;
    }

    return res;
  }

  private int calcDistance(int p1, int p2, int q1, int q2) {
    return (int) Math.pow(q1 - p1, 2) + (int) Math.pow(q2 - p2, 2);
  }

  public static void main(String[] args) {
    //int[][] points = new int[][] {new int[]{1,3}, new int[]{-2,2}};
    int[][] points = new int[][] {new int[]{-5,4}, new int[]{-6,-5}, new int[]{4,6}};
    int K = 2;

    int[][] result = new Solution().kClosest(points, K);

    System.out.println("" + result);
  }
}