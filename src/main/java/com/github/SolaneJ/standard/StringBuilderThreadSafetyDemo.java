package com.github.SolaneJ.standard;

/**
 * StringBuilder线程不安全的示例，期望值sb.length()=2000
 *
 * @author SolaneJ
 * @since 2025/1/22 13:32
 */
public class StringBuilderThreadSafetyDemo {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();

        // 创建两个线程，两个线程同时修改同一个 StringBuilder 对象
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                sb.append("A");
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                sb.append("B");
            }
        });

        thread1.start(); // 启动第一个线程
        thread2.start(); // 启动第二个线程

        try {
            thread1.join(); // 等待第一个线程执行完毕
            thread2.join(); // 等待第二个线程执行完毕
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Final StringBuilder content length: " + sb.length());
    }
}
