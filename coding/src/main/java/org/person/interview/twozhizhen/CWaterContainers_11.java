package org.person.interview.twozhizhen;

public class CWaterContainers_11 {

  /**
   * 给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
   *
   * <p>找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
   *
   * <p>返回容器可以储存的最大水量。
   *
   * <p>说明：你不能倾斜容器。
   *
   * @param height
   * @return
   */
  public static int maxArea(int[] height) {
    // S(i,j)=min(h[i],h[j])×(j−i)
    // 1. 定义双指针
    int i = 0;
    int j = height.length - 1;
    int res = 0;
    while (i < j) {
      // 2. 宽度
      int kl = j - i;
      int curArea; // 当前面积
      if (height[i] < height[j]) { // 左边小 移动左指针
        curArea = height[i] * kl;
        i++;
      } else { // 右边小 移动右指针
        curArea = height[j] * kl;
        j--;
      }

      if (curArea > res) {
        res = curArea;
      }
    }
    return res;
  }

  public static void main(String[] args) {
    int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
    int res = maxArea(height);
    System.out.println(res);
  }
}
