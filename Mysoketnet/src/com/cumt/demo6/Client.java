package com.cumt.demo6;

import java.io.*;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {
        // 创建对象
        Socket socket=new Socket("127.0.0.1",8888);
        //读取本地文件中的数据并写到服务器当中
        BufferedInputStream bis=new BufferedInputStream(new FileInputStream("C:\\Users\\26515\\Desktop\\learnjava\\studyjava\\Mysoketnet\\Clientdir\\派蒙.png"));
        BufferedOutputStream bos=new BufferedOutputStream(socket.getOutputStream());
        byte[] bytes=new byte[1024];
        int len;
        while ((len=bis.read(bytes))!=-1){
            bos.write(bytes,0,len);
            bos.flush();
        }
        //告诉服务器，文件已经发送完毕
        socket.shutdownOutput();
        //接收服务器的反馈
        BufferedReader br=new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String line=br.readLine();
        System.out.println(line);
        //释放资源
        br.close();
        bos.close();
        bis.close();
        socket.close();
    }
}
