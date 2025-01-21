package org.person.interview.twozhizhen;

public class Move0_283 {

  /**
   * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
   *
   * <p>请注意 ，必须在不复制数组的情况下原地对数组进行操作。
   *
   * @param array
   */
  public static void moveZeroes(int[] array) {
    int length = array.length;
    int left = 0, right = 0;

    while (right < length) {
      if (array[right] != 0) {
        swap(array, left, right);
        left++;
      }

      right++;
    }
  }

  private static void swap(int[] array, int left, int right) {
    int tmp = array[left];
    array[left] = array[right];
    array[right] = tmp;
  }

  public static void main(String[] args) {
    int[] array = {0, 1, 0, 3, 12};
    moveZeroes(array);
    for (int a : array) {
      System.out.println(a);
    }
  }
}
