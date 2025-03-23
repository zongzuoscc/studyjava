package com.cumt.mythread2;

public class MyThread extends Thread {
    static int count=100;
    @Override
    public void run() {
        while(true){
            synchronized (MyThread.class) {
                if(count>11){
                    try {
                        sleep(30);
                    }
                    catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println(Thread.currentThread().getName()+"正在分发第"+ --count+"个礼物");
                }
                else{
                    break;
                }
            }
        }
    }
}
