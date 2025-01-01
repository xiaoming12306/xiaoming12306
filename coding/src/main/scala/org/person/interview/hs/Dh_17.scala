package org.person.interview.hs

import scala.collection.mutable.ListBuffer

object Dh_17 {

  /**
   * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
   *
   * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
   *
   * @param digts
   * @return
   */
  def letterCombinations(digts: String): List[String] = {
    val combinations = ListBuffer[String]()
    // 1. 判断为空, 直接返回空列表
    if (digts.isEmpty) {
      return combinations.toList
    }
    // 2. 定义 Map 保存 2-9 对应字母
    var phoneMap: Map[Char, String] = Map(
      '2' -> "abc",
      '3' -> "def",
      '4' -> "ghi",
      '5' -> "jkl",
      '6' -> "mno",
      '7' -> "pqrs",
      '8' -> "tuv",
      '9' -> "wxyz",
    )
    // 3. 回溯寻找
    dfs(combinations, phoneMap, digts, 0, new StringBuilder())
    // 4. 返回结果
    combinations.toList
  }

  def dfs(combinations: ListBuffer[String], phoneMap: Map[Char, String], digts: String
         , idx: Int, combination: StringBuilder): Unit = {
    // 1. 定义终止条件
    if (idx == digts.length) {
      combinations += combination.toString()
    } else {
      // 2. 取数字和对应的字母
      val dig = digts.charAt(idx)
      val letters = phoneMap(dig)
      for (i <- 0 until( letters.length)) {
        combination.append(letters(i))
        dfs(combinations, phoneMap, digts, idx + 1, combination)
        combination.deleteCharAt(idx)
      }
    }
  }


  def main(args: Array[String]): Unit = {
    val  res = letterCombinations("23")
    println(res)
  }
}
