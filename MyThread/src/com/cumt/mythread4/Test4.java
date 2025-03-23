package com.cumt.mythread4;

public class Test4 {
    public static void main(String[] args) {
        MyThread t1=new MyThread();
        MyThread t2=new MyThread();
        MyThread t3=new MyThread();
        MyThread t4=new MyThread();
        MyThread t5=new MyThread();
        t1.setName("甲");
        t2.setName("乙");
        t3.setName("丙");
        t4.setName("丁");
        t5.setName("戊");
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
    }
}
