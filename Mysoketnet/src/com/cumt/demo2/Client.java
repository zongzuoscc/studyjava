package com.cumt.demo2;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket s = new Socket("127.0.0.1",65535);
        Scanner sc = new Scanner(System.in);
        OutputStream os = s.getOutputStream();
        while (true) {
            System.out.println("请输入要发送的内容");
            String str = sc.nextLine();
            if ("886".equals(str)) {
                break;
            }
            os.write(str.getBytes());
        }
        s.close();

    }
}
