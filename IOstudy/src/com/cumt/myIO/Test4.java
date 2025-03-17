package com.cumt.myIO;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
//一个用以解压缩zip文件的类
public class Test4 {
    public static void main(String[] args) throws IOException {
        File src=new File("D:\\source_code.zip");
        File dest=new File("D:\\");

        unZip(src,dest);
    }

    private static void unZip(File src, File dest) throws IOException {
        ZipInputStream zip=new ZipInputStream(new FileInputStream(src));
        ZipEntry entry;
        while((entry=zip.getNextEntry())!=null)
        {
            System.out.println(entry);
            if(entry.isDirectory())
            {
                //如果是文件夹，在dest处创建一个同样的文件夹
                File file=new File(dest,entry.toString());
                file.mkdirs();

            }else {
                FileOutputStream fos=new FileOutputStream(new File(dest,entry.toString()));
                int b;
                while((b=zip.read())!=-1)
                {
                    fos.write(b);

                }
                fos.close();
                //表示在压缩包中的一个文件处理完毕了
                zip.closeEntry();
            }
        }
        zip.close();
    }
}
