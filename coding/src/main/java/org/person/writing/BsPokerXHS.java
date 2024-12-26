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
    // 1. 判断长度和null
    if (pokes == null && pokes.length < 5) {
      return false;
    }

    // 2. 采用hashMap的方式存储 key: 花色 value: [1, 2, 4 , ...]
    Map<String, List<Integer>> pokerMap = new HashMap<>();
    for (String poke : pokes) {
      String hs = poke.substring(0, 1);
      String hv = poke.substring(1);
      List<Integer> pokeValue = pokerMap.get(hs);
      if (pokeValue == null) {
        pokeValue = new ArrayList<>();
      }
      // 特殊处理 j q k a
      pokerMap.put(hs, cover(hv, pokeValue));
    }

    // 3. 处理判断是否连续
    for (Map.Entry<String, List<Integer>> pokeEntry : pokerMap.entrySet()) {
      List<Integer> hvList = pokeEntry.getValue();
      Collections.sort(hvList);
      int cn = 1;
      for (int j = 1; j < hvList.size(); j++) {
        int a = hvList.get(j);
        int b = hvList.get(j - 1);
        if (b + 1 == a) {
          cn++;
          if (cn >= 5) {
            return true;
          }
        } else {
          cn = 1;
        }
      }
    }
    return false;
  }

  private static List<Integer> cover(String hv, List<Integer> pokeValue) {
    switch (hv) {
      case "j":
        pokeValue.add(11);
        break;
      case "q":
        pokeValue.add(12);
        break;
      case "k":
        pokeValue.add(13);
        break;
      case "a":
        pokeValue.add(1);
        pokeValue.add(14);
        break;
      default:
        pokeValue.add(Integer.parseInt(hv));
    }
    return pokeValue;
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
