package com.cumt.mythread1;

public class MyThread extends Thread {
    static int count=0;
    @Override
    public void run() {
        while(true){
            synchronized (MyThread.class) {
                if(count<1000){
                    try {
                        sleep(30);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println(Thread.currentThread().getName()+"正在售卖第"+ ++count+"张票");
                }else{
                    break;
                }
            }
        }
    }
}
