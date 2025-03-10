package com.cumt.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Test2 {
    public static void main(String[] args) {
        ArrayList<Integer> list=new ArrayList<>();
        Collections.addAll(list,1,1,1,1,1,1,1,0,0,0);
        Collections.shuffle(list);
        Random r=new Random();
        int index=r.nextInt(list.size());
        int num=list.get(index);
        System.out.println(num);

        ArrayList<String> boyList=new ArrayList<>();
        ArrayList<String> girlList=new ArrayList<>();
        Collections.addAll(boyList,"张三","李四","王五","赵六","田七");
        Collections.addAll(girlList,"张一","李二","王三","赵四","田五");
        if(num==1)
        {
            int boyIndex=r.nextInt(boyList.size());
            String name = boyList.get(boyIndex);
            System.out.println(name);
        }
        else{
            int girlIndex=r.nextInt(girlList.size());
            String name = girlList.get(girlIndex);
            System.out.println(name);
        }
    }
}
