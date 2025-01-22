package com.github.SolaneJ.standard;

/**
 * StringBuffer线程安全的示例，值sb.length()=2000
 *
 * @author SolaneJ
 * @since 2025/1/22 13:34
 */
public class StringBufferThreadSafetyDemo {
    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer();

        // 创建两个线程，两个线程同时修改同一个 StringBuffer 对象
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

        System.out.println("Final StringBuffer content length: " + sb.length());
    }
}
