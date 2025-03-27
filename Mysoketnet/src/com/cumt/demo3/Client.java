package com.cumt.demo3;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {
        //创建一个Socket对象并连接服务器
        Socket socket = new Socket("127.0.0.1", 8888);

        String str="见到你很高兴";
        OutputStream os = socket.getOutputStream();
        os.write(str.getBytes());

        //接受服务器回写的数据
        InputStream is = socket.getInputStream();
        int b;
        while ((b = is.read()) != -1) {
            System.out.print((char) b);
        }



        //关闭流和Socket
        os.close();
        socket.close();

    }
}
