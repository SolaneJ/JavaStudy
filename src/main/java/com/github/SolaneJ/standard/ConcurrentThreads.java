package com.github.SolaneJ.standard;

import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 并发线程
 * 并发线程是指多个线程在同一时间段内同时执行。在单核CPU上，多个线程通过时间片轮转的方式交替执行，给人一种同时执行的错觉。在多核CPU上，多个线程可以真正地同时执行。
 * <p>
 * Java提供了多种机制来实现并发，包括：
 * 1. synchronized关键字：用于实现线程同步，确保同一时间只有一个线程可以访问共享资源。
 * 2. Lock接口：提供了比synchronized更灵活的锁机制。
 * 3. Atomic类：提供了原子操作，保证操作的原子性。
 * 4. Executor框架：用于管理和执行线程池中的任务。
 */
public class ConcurrentThreads extends Thread {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " is Running");
    }

    public static void main(String[] args) {
        // 创建并启动线程
        for (int i = 0; i < 10; i++) {
            ConcurrentThreads thread = new ConcurrentThreads();
            thread.start();
        }
    }

    @Test
    public void threadPoolTest() {
        // 创建一个固定大小的线程池
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        // FixedThreadPool适用于需要限制并发线程数量的场景，CachedThreadPool适用于需要快速响应的场景，SingleThreadExecutor适用于需要按顺序执行任务的场景

        // 提交任务到线程池
        for (int i = 0; i < 10; i++) {
            executorService.submit(() -> {
                System.out.println(Thread.currentThread().getName() + " is Running");
            });
        }

        executorService.shutdown(); // 关闭线程池
    }
}
