package com.cumt.myIO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Test1 {
    public static void main(String[] args) throws IOException {
        //1.创建对象表示数据源
        File src=new File("D:\\aaa");
        //2.创建对象表示目的地
        File dest=new File("D:\\1");

         copydir(src,dest);
    }

    private static void copydir(File src, File dest) throws IOException {
        dest.mkdir();
        //递归
        //1.进入数据源
        File[] files = src.listFiles();
        //2.遍历数组
        for (File file :files){
            if(file.isFile()){
                //3.判断，如果是文件，就复制
                FileInputStream fis=new FileInputStream(file);
                FileOutputStream fos=new FileOutputStream(new File(dest,file.getName()));
                byte[] bytes=new byte[1024];
                int len;
                while((len=fis.read(bytes))!=-1){
                    fos.write(bytes,0,len);
                }
                fos.close();
                fis.close();
            }else {
                //4.如果是文件夹，就创建文件夹，进入文件夹，递归
                copydir(file,new File(dest,file.getName()));
            }
        }


    }
}
