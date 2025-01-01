package org.person.interview.string;

/**
 * 给你一个字符串 s ，请你反转字符串中 单词 的顺序。 单词 是由非空格字符组成的字符串。s 中使用至少一个空格将字符串中的 单词 分隔开。 返回 单词 顺序颠倒且 单词
 * 之间用单个空格连接的结果字符串。 注意：输入字符串 s中可能会存在前导空格、尾随空格或者单词间的多个空格。 返回的结果字符串中，单词间应当仅用单个空格分隔，且不包含任何额外的空格。
 */
public class Fz151 {
  public static String reverseWords(String s) {
    s = s.trim();
    int n = s.length();
    StringBuilder sub = new StringBuilder();
    StringBuilder ans = new StringBuilder();
    for (int i = 0; i < n; i++) {
      if (s.charAt(i) != ' ') {
        sub.append(s.charAt(i));
      } else if (!sub.toString().isEmpty()) {
        ans.insert(0, sub.toString());
        ans.insert(0, ' ');
        sub.setLength(0);
      }
    }
    ans.insert(0, sub.toString());
    return ans.toString();
  }

  public static void main(String[] args) {
    String s = "the sky is blue";
    String sNew = reverseWords(s);
    System.out.println(sNew);
  }
}
