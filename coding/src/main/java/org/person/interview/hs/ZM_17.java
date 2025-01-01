package org.person.interview.hs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ZM_17 {

  /**
   * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
   *
   * <p>给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
   *
   * @param digits
   * @return
   */
  public static List<String> letterCombinations(String digits) {
    List<String> res = new ArrayList<>();
    if (digits.isEmpty()) {
      return res;
    }

    Map<Character, String> phoneMap = new HashMap<>();
    phoneMap.put('2', "abc");
    phoneMap.put('3', "def");
    phoneMap.put('4', "ghi");
    phoneMap.put('5', "jkl");
    phoneMap.put('6', "mno");
    phoneMap.put('7', "pqrs");
    phoneMap.put('8', "tuv");
    phoneMap.put('9', "wxyz");

    dfs(res, phoneMap, digits, 0, new StringBuilder());
    return res;
  }

  private static void dfs(
      List<String> res, Map<Character, String> phoneMap, String digits, int idx, StringBuilder sb) {
    if (idx == digits.length()) {
      res.add(sb.toString());
    } else {
      Character s = digits.charAt(idx);
      String letters = phoneMap.get(s);
      for (int i = 0; i < letters.length(); i++) {
        sb.append(letters.charAt(i));
        dfs(res, phoneMap, digits, idx + 1, sb);
        sb.deleteCharAt(idx);
      }
    }
  }

  public static void main(String[] args) {
    String s = "23";
    System.out.println(letterCombinations(s));
  }
}
