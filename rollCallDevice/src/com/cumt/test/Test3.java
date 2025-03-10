package com.cumt.test;
import java.util.Collections;
import java.util.ArrayList;
import java.util.Random;

public class Test3 {
    public static void main(String[] args) {
        ArrayList<String> list=new ArrayList<>();
        Collections.addAll(list,"张三","李四","王五","赵六","田七");
        //Collections.shuffle(list);
        Random r=new Random();
        //创建一个临时的集合，用来存储已经被念到名字的学生
        ArrayList<String> temp=new ArrayList<>();
        for (int j = 0; j < 10; j++) {
            int length=list.size();
            for (int i = 0; i < length; i++) {
                int index=r.nextInt(list.size());
                String name = list.remove(index);
                temp.add(name);
                System.out.println(name);
            }
            list.addAll(temp);
            temp.clear();
            System.out.println("=======================");
        }

    }
}
