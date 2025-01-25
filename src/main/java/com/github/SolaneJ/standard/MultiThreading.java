package com.github.SolaneJ.standard;

import lombok.extern.java.Log;

// 继承Thread类
@Log
class MyThread extends Thread {
    public void run() {
        log.info("Thread is running");
    }
}

// 实现Runnable接口
@Log
class MyRunnable implements Runnable {
    public void run() {
        log.info("Runnable is running");
    }
}

/**
 * 多线程
 * 多线程是指在一个程序中同时运行多个线程，每个线程执行不同的任务。线程是程序执行的最小单元，一个进程可以包含多个线程。多线程可以提高程序的执行效率，特别是在处理多个任务时。
 * Java中创建线程有两种方式：
 * 继承Thread类：创建一个类继承Thread类，并重写run()方法。
 * 实现Runnable接口：创建一个类实现Runnable接口，并重写run()方法
 */
public class MultiThreading {

    public static void main(String[] args) {
        // 创建并启动线程
        MyThread thread = new MyThread();
        thread.start();

        Thread runnableThread = new Thread(new MyRunnable());
        runnableThread.start();
    }
}
