package org.person.interview.array;

import java.util.*;

public class ZMYG_49 {
  /**
   * 给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
   *
   * <p>字母异位词 是由重新排列源单词的所有字母得到的一个新单词。 示例 1: 输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
   * 输出: [["bat"],["nat","tan"],["ate","eat","tea"]] 示例 2: 输入: strs = [""] 输出: [[""]] 示例 3: 输入: strs
   * = ["a"] 输出: [["a"]]
   */
  public static List<List<String>> groupAnagrams(String[] strs) {
    List<List<String>> res = new ArrayList<>();

    Map<String, List<String>> dcMap = new HashMap<>();
    for (String str : strs) {
      char[] array = str.toCharArray();
      Arrays.sort(array);
      String key = new String(array);
      List<String> res1 = dcMap.get(key);
      if (res1 == null) {
        res1 = new ArrayList<>();
      }
      res1.add(str);
      dcMap.put(key, res1);
    }
    for (Map.Entry<String, List<String>> dc : dcMap.entrySet()) {
      res.add(dc.getValue());
    }

    return res;
  }

  public static void main(String[] args) {
    String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
    System.out.println(groupAnagrams(strs));
  }
}
