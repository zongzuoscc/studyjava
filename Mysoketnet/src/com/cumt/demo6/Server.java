package com.cumt.demo6;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(8888);
        while (true) {
            Socket socket = ss.accept();

            //开启一条线程
            //一个用户对应一条线程
            new Thread(new MyRunner(socket)).start();
        }
    }
}
