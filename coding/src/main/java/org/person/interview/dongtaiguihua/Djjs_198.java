package org.person.interview.dongtaiguihua;

public class Djjs_198 {

  /**
   * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
   *
   * <p>给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
   *
   * @param nums
   * @return
   */
  public static int rob(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }
    int length = nums.length;
    if (length == 1) {
      return nums[0];
    }

    int first = nums[0];
    int second = Math.max(nums[0], nums[1]);
    for (int i = 2; i < length; i++) {
      int temp = second;
      second = Math.max(first + nums[i], second);
      first = temp;
    }
    return second;
  }

  public static void main(String[] args) {
    int[] nums = {1, 10, 5, 7, 9};
    int res = rob(nums);
    System.out.println(res);
  }
}
