package org.person.interview.tanxin;

import java.util.ArrayList;
import java.util.List;

public class HfZm_763 {

  /**
   * 给你一个字符串 s 。我们要把这个字符串划分为尽可能多的片段，同一字母最多出现在一个片段中。
   *
   * <p>注意，划分结果需要满足：将所有划分结果按顺序连接，得到的字符串仍然是 s 。
   *
   * <p>返回一个表示每个字符串片段的长度的列表。
   *
   * @param s
   * @return
   */
  public static List<Integer> partitionLabels(String s) {
    int[] last = new int[26];
    int length = s.length();
    for (int i = 0; i < length; i++) {
      last[s.charAt(i) - 'a'] = i;
    }

    List<Integer> partition = new ArrayList<>();
    int start = 0, end = 0;
    for (int i = 0; i < length; i++) {
      end = Math.max(end, last[s.charAt(i) - 'a']);
      if (i == end) {
        partition.add(end - start + 1);
        start = end + 1;
      }
    }

    return partition;
  }

  public static void main(String[] args) {
    String s = "ababcbacadefegdehijhklij";
    List<Integer> res = partitionLabels(s);
    for (int res1 : res) {
      System.out.println(res1);
    }
  }
}
