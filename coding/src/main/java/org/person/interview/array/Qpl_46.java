package org.person.interview.array;

import java.util.ArrayList;
import java.util.List;

public class Qpl_46 {
  public static List<List<Integer>> qpl(int[] nums) {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> res1 = new ArrayList<>();
    // 递归寻找排列可能
    back(res, res1, nums);
    return res;
  }

  private static void back(List<List<Integer>> res, List<Integer> res1, int[] nums) {
    // 终止条件
    if (res1.size() == nums.length) {
      res.add(new ArrayList<>(res1));
    }
    // 处理逻辑
    for (int num : nums) {
      if (!res1.contains(num)) {
        res1.add(num);
        back(res, res1, nums);
        // 回溯寻找，移除最后一个元素，查找可能
        res1.remove(res1.size() - 1);
      }
    }
  }

  public static void main(String[] args) {
    int[] numb = {1, 2, 3};
    System.out.println(qpl(numb));
  }
}
