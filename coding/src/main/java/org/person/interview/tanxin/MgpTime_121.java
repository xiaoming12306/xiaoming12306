package org.person.interview.tanxin;

public class MgpTime_121 {
  /**
   * 给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
   *
   * <p>你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
   *
   * <p>返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
   *
   * @param prices
   * @return
   */
  public static int maxProfit(int[] prices) {
    int maxPrices = 0;
    int minPrices = Integer.MAX_VALUE;

    for (int i = 0; i < prices.length; i++) {
      if (prices[i] < minPrices) {
        minPrices = prices[i];
      } else if (prices[i] - minPrices > maxPrices) {
        maxPrices = prices[i] - minPrices;
      }
    }

    return maxPrices;
  }

  public static void main(String[] args) {
    int[] prices = {7, 1, 5, 3, 6, 4};
    int res = maxProfit(prices);
    System.out.println(res);
  }
}
