package org.person.interview.hs;

import java.util.ArrayList;
import java.util.List;

public class ZhSum_39 {

  /**
   * 给你一个 无重复元素 的整数数组 candidates 和一个目标整数 target ，找出 candidates 中可以使数字和为目标数 target 的 所有 不同组合
   * ，并以列表形式返回。你可以按 任意顺序 返回这些组合。
   *
   * <p>candidates 中的 同一个 数字可以 无限制重复被选取 。如果至少一个数字的被选数量不同，则两种组合是不同的。
   *
   * <p>对于给定的输入，保证和为 target 的不同组合数少于 150 个。
   *
   * @param candidates
   * @param target
   * @return
   */
  public static List<List<Integer>> combinationSum(int[] candidates, int target) {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> res1 = new ArrayList<>();
    int start = 0;
    // 回溯寻找结果
    dfs(res, res1, start, candidates, target);
    return res;
  }

  private static void dfs(
      List<List<Integer>> res, List<Integer> res1, int start, int[] candidates, int target) {
    // 定义终止条件
    if (target == 0) {
      res.add(new ArrayList<>(res1));
      return;
    }

    // 处理
    for (int i = start; i < candidates.length; i++) {
      if (target - candidates[i] < 0) {
        break;
      }
      res1.add(candidates[i]);
      dfs(res, res1, i, candidates, target - candidates[i]);
      res1.remove(res1.size() - 1);
    }
  }

  public static void main(String[] args) {
    int[] candidates = {2, 3, 6, 7};
    int target = 7;
    System.out.println(combinationSum(candidates, target));
  }
}
