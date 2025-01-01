package org.person.interview.array;

import java.util.HashMap;
import java.util.Map;

public class SumK_560 {
  /**
   * 给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的子数组的个数 。
   *
   * <p>子数组是数组中元素的连续非空序列。
   *
   * @param nums
   */
  public static int subarraySum(int[] nums, int k) {
    int cn = 0;
    int pre = 0;
    Map<Integer, Integer> mp = new HashMap<>();
    mp.put(0, 1);
    for (int i = 0; i < nums.length; i++) {
      pre += nums[i];
      if (mp.containsKey(pre - k)) {
        cn += mp.get(pre - k);
      }
      mp.put(pre, mp.getOrDefault(pre, 0) + 1);
    }

    return cn;
  }

  public static void main(String[] args) {
    int[] nums = {1, 1, 1};
    System.out.println(subarraySum(nums, 2));
  }
}
