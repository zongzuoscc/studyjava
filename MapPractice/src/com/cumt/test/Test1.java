package com.cumt.test;

import java.util.*;

public class Test1 {
    public static void main(String[] args) {
        HashMap<String, ArrayList<String>> hm=new HashMap<>();
        ArrayList<String> province1=new ArrayList<>();
        Collections.addAll(province1,"南京","无锡","苏州","常州","扬州");
        ArrayList<String> province2=new ArrayList<>();
        Collections.addAll(province2,"武汉","孝感","十堰","宜昌","鄂州");
        ArrayList<String> province3=new ArrayList<>();
        Collections.addAll(province3,"石家庄","唐山","邢台","保定","张家口");
        hm.put("江苏省",province1);
        hm.put("湖北省",province2);
        hm.put("河北省",province3);
        Set<Map.Entry<String, ArrayList<String>>> entries = hm.entrySet();
        for (Map.Entry<String, ArrayList<String>> entry : entries) {
            String key = entry.getKey();
            ArrayList<String> value = entry.getValue();
            StringBuilder sb=new StringBuilder();
            value.forEach(s->sb.append(s).append(","));
            System.out.println(key+"="+sb.substring(0,sb.length()-1));
        }
    }
}
