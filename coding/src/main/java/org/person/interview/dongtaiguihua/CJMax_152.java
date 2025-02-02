package org.person.interview.dongtaiguihua;

public class CJMax_152 {

  public static int maxProduct(int[] nums) {
    long maxF = nums[0];
    long minF = nums[0];
    int ans = nums[0];
    int length = nums.length;
    for (int i = 1; i < length; i++) {
      long mx = maxF;
      long mn = minF;
      maxF = Math.max(mx * nums[i], Math.max(nums[i], mn * nums[i]));
      minF = Math.min(mn * nums[i], Math.min(nums[i], mx * nums[i]));
      if (minF < -1 << 31) {
        minF = nums[i];
      }
      ans = Math.max((int) maxF, ans);
    }
    return ans;
  }

  public static void main(String[] args) {
    int[] nums = {2, 3, -2, 4};
    int res = maxProduct(nums);
    System.out.println(res);
  }
}
