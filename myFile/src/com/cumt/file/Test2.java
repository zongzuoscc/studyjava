package com.cumt.file;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Test2 {
    public static void main(String[] args) {
        File file=new File("D:\\");
        HashMap<String, Integer> hm = getCount(file);
        System.out.println(hm);
    }

    public static HashMap<String,Integer> getCount(File src){
        HashMap<String,Integer> hm=new HashMap<>();
        File[] files=src.listFiles();
        // 添加空指针检查
        if(files == null) return hm;

        for (File file : files) {
            if(file.isFile()){
                String name=file.getName();
                String[] arr = name.split("\\.");
                // 仅处理有效的文件扩展名
                if(arr.length >= 2){
                    String endName=arr[arr.length-1];
                    hm.put(endName, hm.getOrDefault(endName, 0) + 1);
                }
            }
            // 单独处理目录类型
            else if(file.isDirectory()){
                HashMap<String, Integer> sonMap = getCount(file);
                // 简化合并逻辑
                sonMap.forEach((key, value) ->
                        hm.put(key, hm.getOrDefault(key, 0) + value)
                );
            }
        }
        return hm;
    }


}
