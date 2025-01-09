package org.person.interview.array;

public class Kp_0 {

  public static void quickSort(int[] nums) {
    quickSort(nums, 0, nums.length - 1);
  }

  private static void quickSort(int[] nums, int left, int right) {
    if (left < right) {
      // 分区获取, 获取基准值的位置
      int pivot = partition(nums, left, right);
      // 基准值左边进行排序
      quickSort(nums, left, pivot - 1);
      // 基准值右边进行排序
      quickSort(nums, pivot + 1, right);
    }
  }

  private static int partition(int[] nums, int left, int right) {
    int pivot = nums[left];
    while (left < right) {
      // 从右往左找到第一个小于基准值的元素
      while (left < right && nums[right] >= pivot) {
        right--;
      }
      nums[left] = nums[right];

      // 从左往右找到第一个大于基准值的元素
      while (left < right && nums[left] <= pivot) {
        left++;
      }
      nums[right] = nums[left];
    }
    nums[left] = pivot;
    return left;
  }

  public static void main(String[] args) {
    int[] nums = {4, 2, 5, 1, 6, 7};
    quickSort(nums);
    for (int num : nums) {
      System.out.println(num);
    }
  }
}
