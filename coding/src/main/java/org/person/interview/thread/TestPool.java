package org.person.interview.thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/** 自定义线程池 */
public class TestPool {
  public static void main(String[] args) {
    // 创建一个具有 2 个核心线程，最大线程数为 5，超时时间为 10 秒，队列容量为 10 的线程池
    ThreadPool threadPool =
        new ThreadPool(
            2,
            5,
            10,
            TimeUnit.SECONDS,
            10,
            ((queue, task) -> {
              try {
                queue.put(task);
              } catch (InterruptedException e) {
                // 更好的异常处理，例如记录日志或抛出异常
                throw new RuntimeException(e);
              }
            }));

    for (int i = 0; i < 12; i++) {
      int j = i;
      threadPool.execute(
          () -> {
            System.out.println(
                "当前线程 " + Thread.currentThread().getName() + " task " + j + " is running");
            try {
              Thread.sleep(1000);
            } catch (InterruptedException e) {
              // 更好的异常处理，例如记录日志或抛出异常
              throw new RuntimeException(e);
            }
          });
    }
  }
}

/** 拒绝策略 */
@FunctionalInterface
interface RejectPolicy<T> {
  /**
   * 当任务被拒绝时调用此方法
   *
   * @param queue 阻塞队列
   * @param task 被拒绝的任务
   * @throws InterruptedException 可能会抛出中断异常
   */
  void reject(ArrayBlockingQueue<T> queue, T task) throws InterruptedException;
}

/** 阻塞队列 */
class BlockedQueue<T> {
  // 1. 阻塞队列，使用 ArrayBlockingQueue
  private ArrayBlockingQueue<T> queue;
  // 2. 实现阻塞的锁
  private ReentrantLock lock = new ReentrantLock();
  // 阻塞队列的大小
  private int CAPACITY;

  /**
   * 构造函数，初始化阻塞队列的容量
   *
   * @param queueCapacity 阻塞队列的容量
   */
  public BlockedQueue(int queueCapacity) {
    this.queue = new ArrayBlockingQueue<>(queueCapacity);
    this.CAPACITY = queueCapacity;
  }

  /**
   * 生产者放入数据
   *
   * @param t 要放入的数据
   * @throws InterruptedException 可能会被中断
   */
  public void put(T t) throws InterruptedException {
    lock.lockInterruptibly();
    try {
      queue.put(t);
    } finally {
      lock.unlock();
    }
  }

  /**
   * 带超时添加
   *
   * @param t 要添加的数据
   * @param timeout 超时时间
   * @param timeUnit 超时时间的单位
   * @return 如果添加成功返回 true，否则返回 false
   * @throws InterruptedException 可能会被中断
   */
  public boolean offer(T t, int timeout, TimeUnit timeUnit) throws InterruptedException {
    lock.lockInterruptibly();
    try {
      return queue.offer(t, timeout, timeUnit);
    } finally {
      lock.unlock();
    }
  }

  /**
   * 带超时获取
   *
   * @param timeout 超时时间
   * @param timeUnit 超时时间的单位
   * @return 获取的数据，如果超时返回 null
   * @throws InterruptedException 可能会被中断
   */
  public T poll(int timeout, TimeUnit timeUnit) throws InterruptedException {
    lock.lockInterruptibly();
    try {
      return queue.poll(timeout, timeUnit);
    } finally {
      lock.unlock();
    }
  }

  /**
   * 消费者从线程池当中获取任务
   *
   * @return 获取的数据，如果队列为空会阻塞等待
   * @throws InterruptedException 可能会被中断
   */
  public T take() throws InterruptedException {
    lock.lockInterruptibly();
    try {
      return queue.take();
    } finally {
      lock.unlock();
    }
  }

  /**
   * 尝试将任务添加到队列，如果队列已满，调用拒绝策略
   *
   * @param rejectPolicy 拒绝策略
   * @param task 要添加的任务
   * @throws InterruptedException 可能会被中断
   */
  public void tryPut(RejectPolicy<T> rejectPolicy, T task) throws InterruptedException {
    lock.lockInterruptibly();
    try {
      if (!queue.offer(task)) {
        rejectPolicy.reject(queue, task);
      }
    } finally {
      lock.unlock();
    }
  }
}

/** 线程池 */
class ThreadPool {
  // 任务队列
  private BlockedQueue<Runnable> taskQueue;
  // 线程集合，使用 ConcurrentHashMap 以提高并发性能
  private ConcurrentHashMap<Worker, Boolean> workers = new ConcurrentHashMap<>();
  // 核心线程数
  private int coreSize;
  // 最大线程数
  private int maximumPoolSize;
  // 超时时间
  private int timeout;
  // 超时单位
  private TimeUnit timeUnit;
  // 拒绝策略
  private RejectPolicy<Runnable> rejectPolicy;

  /**
   * 执行任务
   *
   * @param task 要执行的任务
   */
  public void execute(Runnable task) {
    // 先尝试使用核心线程
    if (workers.size() < coreSize) {
      // 创建核心线程
      Worker worker = new Worker(task, true);
      workers.put(worker, true);
      Thread thread = new Thread(worker);
      thread.start();
    } else if (workers.size() < maximumPoolSize) {
      // 创建非核心线程
      Worker worker = new Worker(task, false);
      workers.put(worker, false);
      Thread thread = new Thread(worker);
      thread.start();
    } else {
      try {
        // 任务队列
        taskQueue.tryPut(rejectPolicy, task);
      } catch (InterruptedException e) {
        // 更好的异常处理，例如记录日志或抛出异常
        throw new RuntimeException(e);
      }
    }
  }

  /**
   * 构造函数，初始化线程池的参数
   *
   * @param coreSize 核心线程数
   * @param maximumPoolSize 最大线程数
   * @param timeout 超时时间
   * @param timeUnit 超时时间的单位
   * @param queueCapacity 任务队列的容量
   * @param rejectPolicy 拒绝策略
   */
  public ThreadPool(
      int coreSize,
      int maximumPoolSize,
      int timeout,
      TimeUnit timeUnit,
      int queueCapacity,
      RejectPolicy<Runnable> rejectPolicy) {
    this.coreSize = coreSize;
    this.maximumPoolSize = maximumPoolSize;
    this.timeout = timeout;
    this.timeUnit = timeUnit;
    this.taskQueue = new BlockedQueue<>(queueCapacity);
    this.rejectPolicy = rejectPolicy;
  }

  /** 工作线程类 */
  class Worker implements Runnable {
    private Runnable task;

    // 标记是否为核心线程
    private boolean isCore;

    /**
     * 构造函数，接收初始任务和是否为核心线程的标记
     *
     * @param task 初始任务
     * @param isCore 是否为核心线程
     */
    public Worker(Runnable task, boolean isCore) {
      this.task = task;
      this.isCore = isCore;
    }

    @Override
    public void run() {
      // 先执行初始任务
      try {
        if (task != null) {
          task.run();
          task = null;
        }

        // 从队列中获取任务并执行
        while ((task = taskQueue.poll(timeout, timeUnit)) != null) {
          try {
            task.run();
          } catch (Exception e) {
            // 更好的异常处理，例如记录日志或抛出异常
            throw new RuntimeException(e);
          }
        }

        // 非核心线程在超时后终止
        if (!isCore) {
          workers.remove(this);
        }

      } catch (InterruptedException e) {
        // 更好的异常处理，例如记录日志或抛出异常
        throw new RuntimeException(e);
      }
    }
  }
}
