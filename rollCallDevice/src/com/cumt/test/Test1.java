package com.cumt.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Test1 {
    public static void main(String[] args) {
        //1.定义集合
        ArrayList<String> list=new ArrayList<>();
        //2.添加数据
        Collections.addAll(list,"张三","李四","王五","赵六","田七");
        Random r=new Random();
        int index=r.nextInt(list.size());
        String name=list.get(index);
        System.out.println(name);

        Collections.shuffle(list);
        String name1=list.get(0);
        System.out.println(name1);
    }
}
