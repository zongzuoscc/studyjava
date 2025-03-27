package com.cumt.demo4;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(8888);
        Socket socket = ss.accept();
        BufferedInputStream bis = new BufferedInputStream(socket.getInputStream());
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("C:\\Users\\26515\\Desktop\\learnjava\\studyjava\\Mysoketnet\\Serverdir\\派蒙.png"));
        int len;
        byte[] bytes = new byte[1024];
        while ((len = bis.read(bytes)) != -1) {
            bos.write(bytes, 0, len);
            bos.flush();
        }
        //服务器给客户端反馈
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        bw.write("文件上传成功");
        bw.newLine();//插入一个换行符，表示写入内容结束
        bw.flush();
        //释放资源
        bw.close();
        bos.close();
        bis.close();
        socket.close();
        ss.close();


    }
}
