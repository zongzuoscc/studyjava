package com.cumt.demo6;

import java.io.*;
import java.net.Socket;
import java.util.UUID;

public class MyRunner implements Runnable{

    Socket socket;
    public MyRunner(Socket socket) {
        this.socket = socket;
    }
    @Override
    public void run() {
        try {
            BufferedInputStream bis = new BufferedInputStream(socket.getInputStream());
            String name= UUID.randomUUID().toString().replace("-","");
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("C:\\Users\\26515\\Desktop\\learnjava\\studyjava\\Mysoketnet\\Serverdir\\"+name+"派蒙.png"));
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

            //ss.close();因为要不停接受文件，所以要把服务器关闭的代码注释掉
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }

    }
}
