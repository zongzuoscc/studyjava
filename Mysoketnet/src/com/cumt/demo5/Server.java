package com.cumt.demo5;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.UUID;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Server {
    public static void main(String[] args) throws IOException {
        ThreadPoolExecutor pool = new ThreadPoolExecutor(
                3,//核心线程数
                16,//最大线程数
                60,//空闲线程存活时间
                TimeUnit.SECONDS,//时间单位
                new ArrayBlockingQueue<>(2),//阻塞队列
                Executors.defaultThreadFactory(),//线程工厂
                new ThreadPoolExecutor.AbortPolicy()//任务拒绝策略
        );

        ServerSocket ss = new ServerSocket(8888);

        while (true) {
            Socket socket = ss.accept();

            //开启一条线程
            //一个用户对应一条线程
            //new Thread(new MyRunner(socket)).start();
            pool.submit(new MyRunner(socket));
        }
    }
}
