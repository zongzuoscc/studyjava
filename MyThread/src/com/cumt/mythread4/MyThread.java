package com.cumt.mythread4;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Random;

public class MyThread extends Thread {
//    static double money = 100;
//    static int count = 3;
//    static final double MIN = 0.01;
//    @Override
//    public void run() {
//
//        synchronized (MyThread.class) {
//            if (count == 0) {
//                System.out.println(Thread.currentThread().getName() + "没有抢到红包！");
//            }
//            else {
//                double prize=0;
//                if(count==1) {
//                    prize=money;
//                }
//                else {
//                    Random r=new Random();
//                    double bounds = money - (count - 1) * MIN;
//                    prize = r.nextDouble(bounds);
//                    if(prize<MIN) {
//                        prize=MIN;
//                    }
//                }
//                money-=prize;
//                count--;
//                System.out.println(Thread.currentThread().getName() + "抢到了红包，金额为：" + prize + "元");
//            }
//        }
//    }
    static BigDecimal money = BigDecimal.valueOf(100.0);
    static int count = 3;
    static final BigDecimal MIN = BigDecimal.valueOf(0.01);
    @Override
    public void run() {
        synchronized (MyThread.class) {
            if (count == 0) {
                System.out.println(Thread.currentThread().getName() + "没有抢到红包！");
            }
            else {
                BigDecimal prize;
                if(count==1) {
                    prize=money;
                }else {
                    Random r=new Random();
                    double bounds = money.subtract(BigDecimal.valueOf(count - 1).multiply(MIN)).doubleValue();
                    prize = BigDecimal.valueOf(r.nextDouble(bounds));
                }
                prize=prize.setScale(2, RoundingMode.HALF_UP);
                money=money.subtract(prize);
                count--;
                System.out.println(Thread.currentThread().getName() + "抢到了红包，金额为：" + prize + "元");
            }
        }
    }
}
