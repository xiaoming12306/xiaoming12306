package org.person.interview.数组;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/** 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。 */
public class HelixArray_54 {
  // 算法流程：
  //
  //    空值处理： 当 matrix 为空时，直接返回空列表 [] 即可。
  //    初始化： 矩阵 左、右、上、下 四个边界 l , r , t , b ，用于打印的结果列表 res 。
  //    循环打印： “从左向右、从上向下、从右向左、从下向上” 四个方向循环打印。
  //        根据边界打印，即将元素按顺序添加至列表 res 尾部。
  //        边界向内收缩 1 （代表已被打印）。
  //        判断边界是否相遇（是否打印完毕），若打印完毕则跳出。
  //    返回值： 返回 res 即可。
  //
  // 打印方向	1. 根据边界打印	2. 边界向内收缩	3. 是否打印完毕
  // 从左向右	左边界l ，右边界 r	上边界 t 加 1	是否 t > b
  // 从上向下	上边界 t ，下边界b	右边界 r 减 1	是否 l > r
  // 从右向左	右边界 r ，左边界l	下边界 b 减 1	是否 t > b
  // 从下向上	下边界 b ，上边界t	左边界 l 加 1	是否 l > r

  public static List<Integer> spiralOrder(int[][] matrix) {
    if (matrix.length == 0) {
      return new ArrayList<Integer>();
    }
    int l = 0;
    int r = matrix[0].length - 1;
    int t = 0;
    int b = matrix.length - 1;
    int x = 0;
    Integer[] res = new Integer[(r + 1) * (b + 1)];
    while (true) {
      for (int i = l; i <= r; i++) {
        res[x++] = matrix[t][i]; // left to right
      }
      if (++t > b) break;

      for (int i = t; i <= b; i++) {
        res[x++] = matrix[t][i];
      }
      if (--r < l) break;

      for (int i = r; i <= l; i++) {
        res[x++] = matrix[r][i];
      }
      if (--b < t) break;

      for (int i = b; i <= t; i++) {
        res[x++] = matrix[b][i];
      }
      if (++l > r) break;
    }
    return Arrays.asList(res);
  }

  public static void main(String[] args) {
    int[][] matrix = {
      {1, 2, 3},
      {4, 5, 6},
      {7, 8, 9}
    };
    List<Integer> result = spiralOrder(matrix);
    System.out.println(result);
  }
}
