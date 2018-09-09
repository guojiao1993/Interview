package jd;

import java.util.ArrayList;

public class T8 {
    public static ArrayList<String> list = new ArrayList<>();

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new T8().new MyThread();
        Thread t2 = new Thread(new T8().new MyRunnable());
        t1.setPriority(3);
        t2.setPriority(8);
        t1.start();
        for (String s : list) {
            System.out.print(s + " ");
        }
        System.out.println("#1");
        t2.start();
        for (String s : list) {
            System.out.print(s + " ");
        }
        System.out.println("#2");
        t2.join();
        for (String s : list) {
            System.out.print(s + " ");
        }
        System.out.println("#3");
        for (int i = 0; i < 1000000; i++) {
            i++;
        }
        list.add("main");
        for (String s : list) {
            System.out.print(s + " ");
        }
        System.out.println("#4");
        t1.join();
        for (String s : list) {
            System.out.print(s + " ");
        }
        System.out.println("#5");
        // 运行结果
        // #1
        // #2
        // Thread 1 Thread 2 #3
        // Thread 1 Thread 2 main #4
        // Thread 1 Thread 2 main #5
    }

    class MyThread extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 1000000; i++) {
                i++;
            }
            list.add("Thread 1");
        }
    }

    class MyRunnable implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 1000000; i++) {
                Thread.yield();
                i++;
            }
            list.add("Thread 2");
        }
    }
}