package org.person.interview.数组;

public class 移动0 {
  public static void moveZeroes(int[] nums) {
    int j = 0;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] != 0) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j++] = temp;
      }
    }
  }

  public static void main(String[] args) {
    int[] nums = {0, 1, 0, 2, 3, 0, 9};
    moveZeroes(nums);
    for (int i = 0; i < nums.length; i++) {
      System.out.println(nums[i]);
    }
  }
}
