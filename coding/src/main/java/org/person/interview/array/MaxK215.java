package org.person.interview.array;
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

  // 方法二: 快排思想
  public static int findKthLargest1(int[] nums, int k) {
      int n = nums.length;
      return quickSelect(nums, 0, n - 1, n - k);
  }

  private static int quickSelect(int[] nums, int l, int r, int k) {
    if (l == r) {
      return nums[k]; // 代码排序结束, 直接取下标节点
    }

    int x = nums[l]; // 最左边基准数
    int i = l - 1;
    int j = r + 1;
    while (i < j) {
      do i++; while (nums[i] < x);
      do j--; while (nums[j] > x);
      if (i < j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
      }
    }

    if (k <= j) {
      return quickSelect(nums, l, j, k);
    } else {
      return quickSelect(nums, j + 1, r, k);
    }
  }

  public static void main(String[] args) {
    int[] nums = {3, 2, 1, 5, 6, 4};
    System.out.println(findKthLargest1(nums, 2));
  }
}
