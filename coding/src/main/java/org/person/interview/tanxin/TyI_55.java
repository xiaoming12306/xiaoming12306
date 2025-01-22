package org.person.interview.tanxin;

public class TyI_55 {

  /**
   * 给你一个非负整数数组 nums ，你最初位于数组的 第一个下标 。数组中的每个元素代表你在该位置可以跳跃的最大长度。
   *
   * <p>判断你是否能够到达最后一个下标，如果可以，返回 true ；否则，返回 false 。
   *
   * @param nums
   * @return
   */
  public static boolean canJump(int[] nums) {
    int n = nums.length;
    int right = 0;
    for (int i = 0; i < n; i++) {
      right = Math.max(right, i + nums[i]);
      if (right >= n - 1) {
        return true;
      }
    }
    return false;
  }

  public static void main(String[] args) {
    int[] nums = {2, 3, 1, 1, 4};
    boolean flag = canJump(nums);
    System.out.println(flag);
  }
}
