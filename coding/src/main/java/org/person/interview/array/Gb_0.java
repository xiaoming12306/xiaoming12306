package org.person.interview.array;

public class Gb_0 {
  public static void mergeSort(int[] nums) {
    // 进行归并
    mergeSort(nums, 0, nums.length - 1);
  }

  private static void mergeSort(int[] nums, int left, int right) {
    if (left < right) {
      int mid = left + (right - left) / 2;
      // 对左半部分数组进行排序
      mergeSort(nums, left, mid);

      // 对右半部分数组进行排序
      mergeSort(nums, mid + 1, right);

      // 合并2个数组
      merge(nums, mid, left, right);
    }
  }

  private static void merge(int[] nums, int mid, int left, int right) {
    int[] numsLeft = new int[mid - left + 1];
    int[] numsRight = new int[right - mid];

    // 将元数组左边复制到numsLeft
    for (int i = 0; i < numsLeft.length; i++) {
      numsLeft[i] = nums[left + i];
    }

    // 将元数组右边复制到numsRight
    for (int j = 0; j < numsRight.length; j++) {
      numsRight[j] = nums[mid + 1 + j];
    }

    int i = 0;
    int j = 0;
    int k = left;
    while (i < numsLeft.length && j < numsRight.length) {
      if (numsLeft[i] < numsRight[j]) {
        nums[k++] = numsLeft[i++];
      } else {
        nums[k++] = numsRight[j++];
      }
    }

    // 处理剩余元素
    while (i < numsLeft.length) {
      nums[k++] = numsLeft[i++];
    }

    while (j < numsRight.length) {
      nums[k++] = numsRight[j++];
    }
  }

  public static void main(String[] args) {
    int[] nums = {0, -1, 3, 2, 6, 8};
    mergeSort(nums);
    for (int num : nums) {
      System.out.println(num);
    }
  }
}
