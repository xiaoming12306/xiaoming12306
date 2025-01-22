package org.person.interview.tanxin;

public class TyII_45 {
  /**
   * 给定一个长度为 n 的 0 索引整数数组 nums。初始位置为 nums[0]。
   *
   * <p>每个元素 nums[i] 表示从索引 i 向后跳转的最大长度。换句话说，如果你在 nums[i] 处，你可以跳转到任意 nums[i + j] 处:
   *
   * <p>0 <= j <= nums[i] i + j < n
   *
   * <p>返回到达 nums[n - 1] 的最小跳跃次数。生成的测试用例可以到达 nums[n - 1]。
   *
   * @param nums
   * @return
   */
  public static int jump(int[] nums) {
    int steps = 0;
    int postition = nums.length;

    int end = 0;
    int maxPostition = 0;
    for (int i = 0; i < postition - 1; i++) {
      maxPostition = Math.max(maxPostition, i + nums[i]);
      if (i == end) {
        end = maxPostition;
        steps++;
      }
    }

    return steps;
  }

  public static void main(String[] args) {
    int[] nums = {2, 3, 1, 1, 4};
    int steps = jump(nums);
    System.out.println(steps);
  }
}
