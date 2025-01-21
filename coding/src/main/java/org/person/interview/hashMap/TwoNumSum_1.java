package org.person.interview.hashMap;

import java.util.HashMap;
import java.util.Map;

public class TwoNumSum_1 {

  public static int[] twoSum(int[] nums, int target) {
    Map<Integer, Integer> dict = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      if (dict.containsKey(target - nums[i])) {
        return new int[] {i, dict.get(target - nums[i])};
      }

      dict.put(nums[i], i);
    }
    return new int[0];
  }

  public static void main(String[] args) {
    int[] nums = {2, 7, 11, 15};
    int[] res = twoSum(nums, 9);
    System.out.println(res);
  }
}
