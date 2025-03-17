package com.cumt.myIO;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Test3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new FileReader("D:\\aaa.txt"));
        String line;
        while((line=br.readLine())!=null){
            System.out.println(line);
        }
        br.close();
    }
}
