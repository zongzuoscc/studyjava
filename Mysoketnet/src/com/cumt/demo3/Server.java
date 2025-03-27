package com.cumt.demo3;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        //创建对象并绑定端口
        ServerSocket ss = new ServerSocket(8888);
        Socket socket = ss.accept();

        //socket中获取输入流读取数据
        InputStream is = socket.getInputStream();
        InputStreamReader isr = new InputStreamReader(is);
        int b;
        while ((b = isr.read()) != -1) {
            System.out.print((char) b);
        }

        //回写数据
        String str="我也很高兴";
        socket.getOutputStream().write(str.getBytes());

        //关闭流和Socket
        isr.close();
        socket.close();
        ss.close();
    }
}
