package org.person.interview.array;

import java.util.*;

public class Poker_xhs {

  /**
   * 有一副扑克牌一共52张牌, 分为H S D C 共四种花色， 每个花色共13张，我们把 A 2 3 4 5 为连续的牌, 10 j q k A 也为连续的牌，请注意 A牌即可以当作1
   * 也可以当作14, 现在请你设计算法实现传入一个数组, 判断是否为相同花色的连续牌; 示例： ["S1","hA", "h2","h3", "h4","h5"] 返回ture;
   * ["S1","hA", "h2","h3", "h4","h6"] 返回false; ["S1","h8","h10", "hj","hq", "hk","hA"] 返回false;
   *
   * @return true
   */
  public static Boolean isLXPoker(String[] pokers) {
    if (pokers == null || pokers.length < 5) {
      return false;
    }

    // <key: 花色  value: 保存相同花色的value>
    Map<String, List<Integer>> pokerMap = new HashMap<>();
    // 遍历数组, 把poker 保存到 pokerMap
    for (String poker : pokers) {
      String hs = poker.substring(0, 1);
      String hv = poker.substring(1);

      List<Integer> hvList = pokerMap.get(hs);
      if (hvList == null) {
        hvList = new ArrayList<>();
      }
      pokerMap.put(hs, cover(hv, hvList));
    }

    // 遍历pokerMap, 如果List<Integer>小于5的不做处理, 大于5的排序，
    // 需要考虑 j q k a判断, 然后替换,  做连续值判断 想到的是差值为1
    for (Map.Entry<String, List<Integer>> entry : pokerMap.entrySet()) {
      List<Integer> list = entry.getValue();
      if (list.size() > 5) {
        Collections.sort(list);
      }

      // 对list进行判断 判断是否连续
      // 用于记录连续牌的数量
      int consecutiveCount = 1;
      for (int i = 1; i < list.size(); i++) {
        int prevValue = list.get(i - 1);
        int currentValue = list.get(i);
        // 判断是否连续，考虑A牌可作为1和14的情况
        if (prevValue + 1 == currentValue) {
          consecutiveCount++;
          if (consecutiveCount >= 5) {
            return true;
          }
        } else {
          consecutiveCount = 1;
        }
      }
    }

    return false;
  }

  private static List<Integer> cover(String hv, List<Integer> hvList) {
    switch (hv) {
      case "j":
        hvList.add(11);
        break;
      case "q":
        hvList.add(12);
        break;
      case "k":
        hvList.add(13);
        break;
      case "a":
        hvList.add(1);
        hvList.add(14);
        break;
      default:
        hvList.add(Integer.parseInt(hv));
    }

    return hvList;
  }

  public static void main(String[] args) {
    String[] pokers1 = {"Sa", "ha", "h2", "h3", "h4", "h5"};
    System.out.println(isLXPoker(pokers1));

    String[] pokers2 = {"Sa", "ha", "h2", "h3", "h4", "h6"};
    System.out.println(isLXPoker(pokers2));

    String[] pokers3 = {"Sa", "h8", "h10", "hj", "hq", "hk", "ha"};
    System.out.println(isLXPoker(pokers3));
  }
}
