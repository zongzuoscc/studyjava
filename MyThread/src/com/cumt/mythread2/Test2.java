package com.cumt.mythread2;

public class Test2 {
    public static void main(String[] args) {
        MyThread t1 = new MyThread();
        MyThread t2 = new MyThread();
        t1.setName("同学1");
        t2.setName("同学2");
        t1.start();
        t2.start();
    }
}
