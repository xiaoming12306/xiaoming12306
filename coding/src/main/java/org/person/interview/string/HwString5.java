package org.person.interview.string;

/** 给你一个字符串 s，找到 s 中最长的 回文 子串 。 */
public class HwString5 {
  // 动态规划
  // aba 必须 s[l] == s[r]
  // r - l > 1 && s[l+1] == s[r-1]
  public static String longestPalindrome(String s) {
    if (s == null || s.length() < 2) {
      return s;
    }

    int n = s.length();
    int maxStart = 0;
    int maxEnd = 0;
    int maxLen = 1;
    boolean[][] dp = new boolean[n][n];
    for (int r = 0; r < n; r++) {
      for (int l = 0; l < r; l++) {
        if (s.charAt(l) == s.charAt(r) || (r - l < 2 && dp[l + 1][r - 1])) {
          dp[l][r] = true;
          if (r - l + 1 > maxLen) {
            maxLen = r - l + 1;
            maxStart = l;
            maxEnd = r;
          }
        }
      }
    }

    return s.substring(maxStart, maxEnd + 1);
  }

  public static void main(String[] args) {
    String s = "babad";
    System.out.println(longestPalindrome(s));
  }
}
