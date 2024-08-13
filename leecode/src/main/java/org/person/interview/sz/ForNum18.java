package main.java.org.person.interview.sz;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ForNum18 {
  /*
  * Given an array nums of n integers, return an array of all the unique quadruplets [nums, nums, nums, nums] such that:
  0 <= a, b, c, d < n a, b, c, and d are distinct. nums + nums + nums + nums == target You may return the answer in any order.
  Example 1:
  Input: nums = [1,0,-1,0,-2,2], target = 0
  Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
  Example 2:
  Input: nums = [2,2,2,2,2], target = 8
  Output: [[2,2,2,2]]
  * */

  public static List<List<Integer>> fourSum(int[] nums, int target) {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> resOne = new ArrayList<>();
    if (nums.length < 4) {
      return res;
    }
    Arrays.sort(nums);
    long sum = 0;
    for (int i = 0; i < nums.length - 3; i++) {
      if (i > 0 && nums[i] == nums[i - 1]) {
        continue;
      }
      for (int j = i + 1; j < nums.length - 2; j++) {
        if (j > i + 1 && nums[j] == nums[j - 1]) {
          continue;
        }
        int L = j + 1;
        int R = nums.length - 1;
        while (L < R) {
          sum = (long) nums[i] + (long) nums[j] + (long) nums[L] + (long) nums[R];
          if (sum > target) {
            R--;
          } else if (sum < target) {
            L++;
          } else {
            resOne.add(nums[i]);
            resOne.add(nums[j]);
            resOne.add(nums[L]);
            resOne.add(nums[R]);
            res.add(resOne);
            resOne = new ArrayList<>();
            while (L < R && nums[L] == nums[L + 1]) {
              L++;
            }

            while (L < R && nums[R] == nums[R - 1]) {
              R--;
            }
            L++;
            R--;
          }
        }
      }
    }
    return res;
  }

  public static void main(String[] args) {
    int[] nums = {2, 3, 3, 2, 2, 2};
    List<List<Integer>> res = fourSum(nums, 8);
    for (List<Integer> list : res) {
      System.out.println(list.toString());
    }
  }
}
