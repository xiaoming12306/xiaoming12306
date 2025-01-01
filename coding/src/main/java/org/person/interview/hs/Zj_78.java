package org.person.interview.hs;

import java.util.ArrayList;
import java.util.List;

public class Zj_78 {
  // 方法一: 递归
  public static List<List<Integer>> zj(int[] nums) {
    List<List<Integer>> res = new ArrayList<>();
    res.add(new ArrayList<>());
    for (int num : nums) {
      List<List<Integer>> newRes = new ArrayList<>();
      for (List<Integer> ne : res) {
        List<Integer> newRe = new ArrayList<>(ne);
        newRe.add(num);
        newRes.add(newRe);
      }
      res.addAll(newRes);
    }
    return res;
  }

  // 方法二: 回溯
  public static List<List<Integer>> hs(int[] nums) {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> res1 = new ArrayList<>();
    // 回溯寻找子集
    dfs(res, res1, 0, nums);
    return res;
  }

  private static void dfs(List<List<Integer>> res, List<Integer> res1, int idx, int[] nums) {
    // 终止条件
    if (idx == nums.length) {
      res.add(new ArrayList<>(res1));
      return;

    }

    // 处理逻辑
    dfs(res, res1, idx + 1, nums);
    res1.add(nums[idx]);
    dfs(res, res1, idx + 1, nums);
    res1.remove(res1.size() - 1);
  }

  public static void main(String[] args) {
    int[] nums = {1, 2, 3};
    System.out.println(hs(nums));
    //        System.out.println(zj(nums));
  }
}
