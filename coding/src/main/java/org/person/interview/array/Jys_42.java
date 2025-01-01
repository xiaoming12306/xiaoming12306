package org.person.interview.array;

public class Jys_42 {
  /**
   * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
   *
   * @param height
   */
  public static int trap(int[] height) {
    // 使用双指针方法实现

    int ans = 0; // 定义返回结果
    int left = 0; // 定义左指针
    int right = height.length - 1; // 定义右右指针
    int preMax = 0;
    int sufMax = 0;

    while (left < right) {
      preMax = Math.max(preMax, height[left]);
      sufMax = Math.max(sufMax, height[right]);
      ans += preMax < sufMax ? preMax - height[left++] : sufMax - height[right--];
    }
    return ans;
  }

  public static void main(String[] args) {
    int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
    System.out.println(trap(height));
  }
}
