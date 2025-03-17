package com.cumt.file;

import java.io.File;

public class Test1 {
    public static void main(String[] args) {
        File file=new File("C:\\");
        findAVI(file);
    }
    public static void findAVI(File file){
        File[] files = file.listFiles();
        if(files!=null){
            for (File f:files){
                if(f.isFile()){
                    String name = f.getName();
                    if(name.endsWith(".avi")){
                        System.out.println(f);
                    }
                }
                else{
                    findAVI(f);
                }
            }
        }

    }
}
