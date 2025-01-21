package org.person.interview.dui;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class QkMax_347 {

  public static int[] topKFrequent(int[] nums, int k) {
    Map<Integer, Integer> counter = new HashMap<>();
    for (int num : nums) {
      counter.put(num, counter.getOrDefault(num, 0) + 1);
    }

    PriorityQueue<int[]> heap =
        new PriorityQueue<int[]>(
            new Comparator<int[]>() {
              @Override
              public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
              }
            });

    for (Map.Entry<Integer, Integer> map : counter.entrySet()) {
      //            heap.offer(new int[] {map.getValue(), map.getKey()});
      if (heap.size() == k) {
        if (heap.peek()[1] < map.getValue()) {
          heap.poll();
          heap.offer(new int[] {map.getKey(), map.getValue()});
        }
      } else {
        heap.offer(new int[] {map.getKey(), map.getValue()});
      }
    }

    int[] res = new int[k];
    for (int i = 0; i < k; i++) {
      res[i] = heap.poll()[0];
    }

    return res;
  }

  public static void main(String[] args) {
    int[] nums = {1, 1, 1, 2, 2, 3};
    int[] res = topKFrequent(nums, 2);
    for (int res1 : res) {
      System.out.println(res1);
    }
  }
}
