package com.cumt.demoMap;

import java.util.StringJoiner;
import java.util.TreeMap;
import java.util.function.BiConsumer;

public class MapDemo {
    public static void main(String[] args) {
        TreeMap<Character,Integer> tm = new TreeMap<>();
        String str= "woxianzaizhendeyoudianmimang";
        //遍历字符串得到里面的每一个字符
        for (int i = 0; i < str.length(); i++) {
            char c= str.charAt(i);
//            System.out.println('c');
            if(tm.containsKey(c))
            {
                Integer count=tm.get(c);
                count++;
                tm.put(c,count);
            }
            else {
                tm.put(c,1);
            }
        }
        StringBuilder sb=new StringBuilder();
        tm.forEach((key,  value) -> sb.append(key).append("(").append(value).append(")"));

        StringJoiner sj=new StringJoiner("","","");
        tm.forEach((key,  value) -> sj.add(key+"").add("(").add(value+"").add(")"));

        System.out.println(sb);
        System.out.println(sj);

    }
}
