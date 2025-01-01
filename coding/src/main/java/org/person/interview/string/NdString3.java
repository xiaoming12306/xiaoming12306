package org.person.interview.string;

import java.util.HashMap;
import java.util.Map;

/** 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串的长度。 */
public class NdString3 {

  public static int lengthOfLongestSubstring(String s) {
    // 滑动窗口 + 哈希表
    // 哈希表 dic 统计： 指针 j 遍历字符 s ，哈希表统计字符 s[j] 最后一次出现的索引 。
    // 更新左指针 i ： 根据上轮左指针 i 和 dic[s[j]] ，每轮更新左边界 i ，保证区间 [i+1,j] 内无重复字符且最大。
    Map<Character, Integer> dict = new HashMap<Character, Integer>();
    int i = 0;
    int res = 0;
    int n = s.length();
    for (int j = 0; j < n; j++) {
      if (dict.containsKey(s.charAt(j))) {
        i = Math.max(i, dict.get(s.charAt(j)));
      }
      dict.put(s.charAt(j), j);
      res = Math.max(res, j - i);
    }

    return res;
  }

  public static void main(String[] args) {
    String s = "abcabcbb";
    int length = lengthOfLongestSubstring(s);
    System.out.println("Max string lenth is : " + length);
  }
}
