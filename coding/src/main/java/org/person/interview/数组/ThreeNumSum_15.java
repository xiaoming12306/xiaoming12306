package org.person.interview.数组;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeNumSum_15 {
  /**
   * 给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，同时还满足 nums[i] +
   * nums[j] + nums[k] == 0 。请你返回所有和为 0 且不重复的三元组。 注意：答案中不可以包含重复的三元组。
   */
  public static List<List<Integer>> threeNum(int[] num) {
    List<List<Integer>> res = new ArrayList<>();
    if (num == null || num.length < 3) {
      return res;
    }

    // 1. 排序
    Arrays.sort(num);

    /**
     * 先将 nums 排序，时间复杂度为 O(NlogN)。 固定 3 个指针中最左（最小）元素的指针 k，双指针 i，j 分设在数组索引 (k,len(nums)) 两端。 双指针 i ,
     * j 交替向中间移动，记录对于每个固定指针 k 的所有满足 nums[k] + nums[i] + nums[j] == 0 的 i,j 组合： 当 nums[k] > 0
     * 时直接break跳出：因为 nums[j] >= nums[i] >= nums[k] > 0，即 3 个元素都大于 0 ，在此固定指针 k 之后不可能再找到结果了。 当 k >
     * 0且nums[k] == nums[k - 1]时即跳过此元素nums[k]：因为已经将 nums[k - 1] 的所有组合加入到结果中，本次双指针搜索只会得到重复组合。 i，j
     * 分设在数组索引 (k,len(nums)) 两端，当i < j时循环计算s = nums[k] + nums[i] + nums[j]，并按照以下规则执行双指针移动： 当s < 0时，i
     * += 1并跳过所有重复的nums[i]； 当s > 0时，j -= 1并跳过所有重复的nums[j]； 当s == 0时，记录组合[k, i, j]至res，执行i += 1和j -=
     * 1并跳过所有重复的nums[i]和nums[j]，防止记录到重复组合。
     */

    // 2.3 个指针中最左（最小）元素的指针 k，双指针 i，j 分设在数组索引 (k,len(nums)) 两端。

    for (int k = 0; k < num.length - 2; k++) {
      if (num[k] > 0) break;
      if (k > 0 && num[k] == num[k - 1]) continue;
      int i = k + 1;
      int j = num.length - 1;
      while (i < j) {
        int sum = num[k] + num[i] + num[j];
        if (sum < 0) {
          i++;
          while (i < j && num[i] == num[i - 1]) {
            i++;
          }
        } else if (sum > 0) {
          j--;
          while (i < j && num[j] == num[j + 1]) {
            j--;
          }
        } else {
          List<Integer> res1 = new ArrayList<>();
          res1.add(num[k]);
          res1.add(num[i]);
          res1.add(num[j]);
          res.add(res1);
          i++;
          while (i < j && num[i] == num[i - 1]) {
            i++;
          }
          j--;
          while (i < j && num[j] == num[j + 1]) {
            j--;
          }
        }
      }
    }

    return res;
  }

  public static void main(String[] args) {
    int[] num = {-1, 0, 1, 2, -1, -4};
    System.out.println(threeNum(num));
  }
}
