package org.person.interview.HashMap;

import java.util.HashSet;
import java.util.Set;

public class ZcLx_128 {
  /**
   * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。 请你设计并实现时间复杂度为 O(n) 的算法解决此问题。 示例 1： 输入：nums =
   * [100,4,200,1,3,2] 输出：4 解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。 示例 2： 输入：nums = [0,3,7,2,5,8,4,6,0,1]
   * 输出：9
   */
  public static int longestConsecutive(int[] nums) {
    // 由于算法要求是O(n)  因此不能排序
    // 1. 考虑去重问题 数组转set
    Set<Integer> numSet = new HashSet<>();
    for (int num : nums) {
      numSet.add(num);
    }

    int longLength = 0;

    // 遍历set 判断是否连续 差值为1
    for (int n : numSet) {
      if (!numSet.contains(n - 1)) {
        int cur = n;
        int curLength = 1;
        while (numSet.contains(cur + 1)) {
          cur += 1;
          curLength += 1;
        }
        longLength = Math.max(longLength, curLength);
      }
    }

    return longLength;
  }

  public static void main(String[] args) {
    int[] nums = {100, 4, 200, 1, 3, 2};
    System.out.println(longestConsecutive(nums));
  }
}
