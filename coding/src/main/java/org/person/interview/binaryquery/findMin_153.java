package org.person.interview.binaryquery;

public class findMin_153 {

  /**
   * 已知一个长度为 n 的数组，预先按照升序排列，经由 1 到 n 次 旋转 后，得到输入数组。例如，原数组 nums = [0,1,2,4,5,6,7] 在变化后可能得到：
   *
   * <p>若旋转 4 次，则可以得到 [4,5,6,7,0,1,2] 若旋转 7 次，则可以得到 [0,1,2,4,5,6,7]
   *
   * <p>注意，数组 [a[0], a[1], a[2], ..., a[n-1]] 旋转一次 的结果为数组 [a[n-1], a[0], a[1], a[2], ..., a[n-2]] 。
   *
   * <p>给你一个元素值 互不相同 的数组 nums ，它原来是一个升序排列的数组，并按上述情形进行了多次旋转。请你找出并返回数组中的 最小元素 。
   *
   * <p>你必须设计一个时间复杂度为 O(log n) 的算法解决此问题。
   *
   * @param nums
   */
  public static int findMin(int[] nums) {
    int low = 0;
    int high = nums.length - 1;
    while (low < high) {
      int mid = low + (high - low) / 2;
      if (nums[mid] < nums[high]) {
        high = mid;
      } else {
        low = mid + 1;
      }
    }
    return nums[low];
  }

  public static void main(String[] args) {
    int[] nums = {3, 4, 5, 1, 2};
    int num = findMin(nums);
    System.out.println(num);
    int[] nums1 = {4, 5, 6, 7, 0, 1, 2};
    int num1 = findMin(nums1);
    System.out.println(num1);
  }
}
