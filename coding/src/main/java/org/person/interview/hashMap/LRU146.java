package org.person.interview.hashMap;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 请你设计并实现一个满足 LRU (最近最少使用) 缓存 约束的数据结构。 实现 LRUCache 类： LRUCache(int capacity) 以 正整数 作为容量 capacity
 * 初始化 LRU 缓存 int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。 void put(int key, int value)
 * 如果关键字 key 已经存在，则变更其数据值 value ；如果不存在，则向缓存中插入该组 key-value 。如果插入操作导致关键字数量超过 capacity ，则应该 逐出
 * 最久未使用的关键字。 函数 get 和 put 必须以 O(1) 的平均时间复杂度运行。
 */
public class LRU146 {
  public static class LRUCache {
    // 缓存容量
    private final int capacity;
    // 使用LinkedHashMap 实现缓存，保证元素顺序插入
    private Map<Integer, Integer> cache = new LinkedHashMap<Integer, Integer>();

    public LRUCache(int capacity) {
      this.capacity = capacity;
    }

    public int get(int key) {
      // 取得时候如果存在，先移除在放入
      Integer value = cache.remove(key);
      if (value != null) {
        cache.put(key, value);
        return value;
      }
      // 没有直接返回 -1
      return -1;
    }

    public void put(int key, int value) {
      // 如果说换成中已经该key 先移除 在插入
      if (cache.remove(key) != null) {
        cache.put(key, value);
        return;
      }
      // 如果容量已经满，删除首位元素
      if (cache.size() == capacity) {
        Integer oldKey = cache.keySet().iterator().next();
        cache.remove(oldKey);
      }

      cache.put(key, value);
    }
  }

  public static void main(String[] args) {
    // 创建一个容量为2的LRU缓存实例
    LRUCache lruCache = new LRUCache(2);

    // 插入键值对 (1, 100)
    lruCache.put(1, 100);
    // 插入键值对 (2, 200)
    lruCache.put(2, 200);

    // 获取键为1的元素，此时1变为最近使用的，2变为较久未使用的
    System.out.println("获取键为1的元素：" + lruCache.get(1));

    // 插入键值对 (3, 300)，由于容量已满且2是最久未使用的，所以2会被移除
    lruCache.put(3, 300);

    // 获取键为2的元素，由于2已经被移除，应该返回 -1
    System.out.println("获取键为2的元素：" + lruCache.get(2));

    // 获取键为1的元素，此时1仍在缓存中
    System.out.println("获取键为1的元素：" + lruCache.get(1));

    // 获取键为3的元素，此时3在缓存中
    System.out.println("获取键为3的元素：" + lruCache.get(3));

    // 插入键值对 (4, 400)，由于容量已满且1是最久未使用的，所以1会被移除
    lruCache.put(4, 400);

    // 获取键为1的元素，由于1已经被移除，应该返回 -1
    System.out.println("获取键为1的元素：" + lruCache.get(1));

    // 获取键为3的元素，此时3仍在缓存中
    System.out.println("获取键为3的元素：" + lruCache.get(3));

    // 获取键为4的元素，此时4在缓存中
    System.out.println("获取键为4的元素：" + lruCache.get(4));
  }
}
