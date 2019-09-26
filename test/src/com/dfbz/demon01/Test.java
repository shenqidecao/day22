package com.dfbz.demon01;

public class Test {
    public static void main(String[] args) {
        Ticked ticked = new Ticked();
        Thread t1 = new Thread(ticked, "广州南站");
        Thread t2 = new Thread(ticked, "广州东站");
        Thread t3 = new Thread(ticked, "广州西站");
        t1.start();
        t2.start();
        t3.start();

    }
}

class Ticked implements Runnable {
    int num = 1000;
    @Override
    public void run() {
        synchronized (this) {
            while (true) {
                if (num < 1) {
                    break;
                }
                num--;
                System.out.println(Thread.currentThread().getName() + "窗口正在卖第" + (100 - num) + "张票，剩余" + num + "张");
            }
        }
    }
}
