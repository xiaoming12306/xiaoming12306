package org.person.writing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BsThreeSum_15 {

  public static List<List<Integer>> threeSum(int[] numbers) {
    List<List<Integer>> ans = new ArrayList<>();
    Arrays.sort(numbers);
    for (int i = 1; i < numbers.length - 2; i++) {
      if (numbers[i] > 0) break;
      if (numbers[i] == numbers[i - 1]) continue;
      int k = i + 1;
      int right = numbers.length - 1;
      while (k < right) {
        int sum = numbers[i] + numbers[k] + numbers[right];
        if (sum < 0) {
          k++;
          while (k < right && numbers[k] == numbers[k - 1]) {
            k++;
          }
        } else if (sum > 0) {
          right--;
          while (k < right && numbers[right] == numbers[right + 1]) {
            right--;
          }
        } else {
          List<Integer> ans1 = new ArrayList<>();
          ans1.add(numbers[i]);
          ans1.add(numbers[k]);
          ans1.add(numbers[right]);
          ans.add(ans1);
          k++;
          while (k < right && numbers[k] == numbers[k - 1]) {
            k++;
          }
          right--;
          while (k < right && numbers[right] == numbers[right + 1]) {
            right--;
          }
        }
      }
    }
    return ans;
  }

  public static void main(String[] args) {
    int[] numbers = {-1, 0, 1, 2, -1, -4};
    System.out.println(threeSum(numbers));
  }
}
