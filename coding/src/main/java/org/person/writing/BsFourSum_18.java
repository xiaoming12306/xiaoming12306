package org.person.writing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BsFourSum_18 {

  public static List<List<Integer>> fourSum(int[] numbers, int target) {
    List<List<Integer>> res = new ArrayList<>();
    if (numbers.length < 4) {
      return res;
    }
    // 1. 数组排序
    Arrays.sort(numbers);

    // 2. 定义四数指针 k n i j
    for (int k = 0; k < numbers.length - 3; k++) {
      if (k > 0 && numbers[k] == numbers[k - 1]) {
        continue;
      }

      for (int n = k + 1; n < numbers.length - 2; n++) {
        if (n > k + 1 && numbers[n] == numbers[n - 1]) {
          continue;
        }

        int i = n + 1;
        int j = numbers.length - 1;
        while (i < j) {
          int sum = numbers[k] + numbers[n] + numbers[i] + numbers[j];
          if (sum < target) {
            i++;
            while (i < j && numbers[i] == numbers[i - 1]) {
              i++;
            }
          } else if (sum > target) {
            j--;
            while (i < j && numbers[j] == numbers[j + 1]) {
              j--;
            }
          } else {
            List<Integer> res1 = new ArrayList<>();
            res1.add(numbers[k]);
            res1.add(numbers[n]);
            res1.add(numbers[i]);
            res1.add(numbers[j]);
            i++;
            while (i < j && numbers[i] == numbers[i - 1]) {
              i++;
            }

            j--;
            while (i < j && numbers[j] == numbers[j + 1]) {
              j--;
            }
          }
        }
      }
    }
    return res;
  }

  public static void main(String[] args) {
    int[] numbers = {2, 3, 3, 2, 2, 2};
    System.out.println(fourSum(numbers, 8));
  }
}
