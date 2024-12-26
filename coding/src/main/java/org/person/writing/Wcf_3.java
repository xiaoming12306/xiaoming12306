package org.person.writing;

import java.util.HashMap;
import java.util.Map;

public class Wcf_3 {
  // 滑动窗口 + dict
  public static int lengthOfLongestSubstring(String s) {
    Map<Character, Integer> dict = new HashMap<>();
    int i = -1;
    int res = 0;
    for (int j = 0; j < s.length(); j++) {
      if (dict.containsKey(s.charAt(j))) {
        i = Math.max(i, dict.get(s.charAt(j)));
      }
      dict.put(s.charAt(j), j);
      res = Math.max(res, j - i);
    }
    return i;
  }

  public static void main(String[] args) {
    String s = "abcabcbb";
    System.out.println(lengthOfLongestSubstring(s));
  }
}
