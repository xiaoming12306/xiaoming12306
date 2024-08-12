package com.baidu.interview.sz;

public class max子数组和53 {
  public static int maxSubArray(int[] nums) {
    int pre = 0;
    int maxAns = nums[0];
    for (int x : nums) {
      pre = Math.max(pre + x, x);
      maxAns = Math.max(maxAns, pre);
    }

    return maxAns;
  }

  public static void main(String[] args) {
    int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
    System.out.println(maxSubArray(nums));
  }
}
