package com.cumt.myIO;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Test5 {
    public static void main(String[] args) throws FileNotFoundException {
        File src=new File("D:\\");
        File destParent=src.getParentFile();
        //创建file对象表示压缩包的路径
        File dest=new File(destParent,src.getName()+".zip");
        ZipOutputStream zos=new ZipOutputStream(new FileOutputStream(dest));
        //获取src的每一个文件变成zipentry对象放入到压缩包当中
        toZip(src,zos,src.getName());

        zos.close();
    }
    public static void toZip(File src,ZipOutputStream zos,String name) throws IOException {
        File[] files = src.listFiles();//进入src文件夹

        for (File file:files){
            if(file.isFile()){
                ZipEntry entry=new ZipEntry(name+"\\"+file.getName());
                zos.putNextEntry(entry);
                FileInputStream fis=new FileInputStream(file);
                byte[] bytes=new byte[1024];
                int len;
                while((len=fis.read(bytes))!=-1){
                    zos.write(bytes,0,len);
                }
                fis.close();
                zos.closeEntry();
            }else{
                toZip(file,zos,name+"\\"+file.getName());
            }
        }
    }
}
