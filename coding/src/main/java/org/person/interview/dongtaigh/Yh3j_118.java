package org.person.interview.dongtaigh;

import java.util.ArrayList;
import java.util.List;

public class Yh3j_118 {
  // 给定一个非负整数 numRows，生成「杨辉三角」的前 numRows 行。
  // 在「杨辉三角」中，每个数是它左上方和右上方的数的和。

  public static List<List<Integer>> generate(int numRows) {
    List<List<Integer>> res = new ArrayList<>();
    // 1
    // 1 1
    // 1 2 1
    // 1 3 3 1 // i = 3
    for (int i = 0; i < numRows; i++) {
      List<Integer> row = new ArrayList<>();
      for (int j = 0; j <= i; j++) {
        if (j == 0 || j == i) {
          row.add(1);
        } else {
          row.add(res.get(i - 1).get(j - 1) + res.get(i - 1).get(j));
        }
      }
      res.add(row);
    }

    return res;
  }

  public static void main(String[] args) {
    int numRows = 5;
    System.out.println(generate(numRows));
  }
}
