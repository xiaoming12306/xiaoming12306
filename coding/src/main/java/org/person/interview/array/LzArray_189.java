package org.person.interview.array;

public class LzArray_189 {
  /**
   * 给定一个整数数组 nums，将数组中的元素向右轮转 k 个位置，其中 k 是非负数。
   *
   * @param nums
   * @param k
   */
  public static void rotate(int[] nums, int k) {
    int n = nums.length;
    k %= n;
    reverse(nums, 0, n - 1);
    reverse(nums, 0, k - 1);
    reverse(nums, k, n - 1);
  }

  private static void reverse(int[] nums, int i, int j) {
    while (i < j) {
      int temp = nums[i];
      nums[i++] = nums[j];
      nums[j--] = temp;
    }
  }

  public static void main(String[] args) {
    int[] nums = {1, 2, 3, 4, 5, 6, 7};
    int k = 3;
    rotate(nums, k);
    System.out.println(nums);
  }
}
