package org.person.interview.数组;
/**
 * 给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。 你必须设计并实现时间复杂度为 O(n)
 * 的算法解决此问题。
 */
import java.util.Arrays;

public class MaxK215 {

  // 方法一： api解决方法
  public static int findKthLargest(int[] nums, int k) {
    Arrays.sort(nums);
    int n = nums.length;
    int res = 0;
    for (int i = 0; i < n; i++) {
      res = nums[n - k];
    }
    return res;
  }

  public static void main(String[] args) {
    int[] nums = {3, 2, 1, 5, 6, 4};
    System.out.println(findKthLargest(nums, 2));
  }
}
