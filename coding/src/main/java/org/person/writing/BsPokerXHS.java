package org.person.writing;

import java.util.*;

public class BsPokerXHS {

  /**
   * 有一副扑克牌一共52张牌, 分为H S D C 共四种花色， 每个花色共13张，我们把 A 2 3 4 5 为连续的牌, 10 j q k A 也为连续的牌，请注意 A牌即可以当作1
   * 也可以当作14, 现在请你设计算法实现传入一个数组, 判断是否为相同花色的连续牌; 示例： ["S1","hA", "h2","h3", "h4","h5"] 返回ture;
   * ["S1","hA", "h2","h3", "h4","h6"] 返回false; ["S1","h8","h10", "hj","hq", "hk","hA"] 返回false;
   *
   * @return true
   */
  public static Boolean isPokerLx(String[] pokes) {
    if (pokes == null || pokes.length < 4) {
      return false;
    }
    Map<String, List<Integer>> pokerMap = new HashMap<>();
    for (String poke : pokes) {
      String hs = poke.substring(0, 1);
      String hv = poke.substring(1);
      List<Integer> list = pokerMap.get(hs);
      if (list == null) {
        list = new ArrayList<>();
      }
      pokerMap.put(hs, cover(list, hv));
    }

    for (Map.Entry<String, List<Integer>> map : pokerMap.entrySet()) {
      List<Integer> value = map.getValue();
      Collections.sort(value);
      int n = 1;
      if (value.size() >= 4) {
        for (int i = 1; i < value.size(); i++) {
          if (value.get(i) - value.get(i - 1) == 1) {
            n++;
            if (n >= 5) {
              return true;
            }
          } else {
            n = 1;
          }
        }
      }
    }
    return false;
  }

  private static List<Integer> cover(List<Integer> list, String hv) {
    switch (hv) {
      case "j":
        list.add(11);
        break;
      case "q":
        list.add(12);
        break;
      case "k":
        list.add(13);
        break;
      case "a":
        list.add(14);
        list.add(1);
        break;
      default:
        list.add(Integer.parseInt(hv));
    }

    return list;
  }

  public static void main(String[] args) {
    String[] pokers1 = {"Sa", "ha", "h2", "h3", "h4", "h5"};
    System.out.println(isPokerLx(pokers1));

    String[] pokers2 = {"Sa", "ha", "h2", "h3", "h4", "h6"};
    System.out.println(isPokerLx(pokers2));

    String[] pokers3 = {"Sa", "h8", "h10", "hj", "hq", "hk", "ha"};
    System.out.println(isPokerLx(pokers3));
  }
}
