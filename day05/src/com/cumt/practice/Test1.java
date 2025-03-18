package com.cumt.practice;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test1 {
    public static void main(String[] args) throws IOException {
        String  lastNameWeb="";
        String boyFirstNameWeb="";
        String girlFirstNameWeb="";

        String lastName = webCrawler(lastNameWeb);
        String boysName = webCrawler(boyFirstNameWeb);
        String girlsName = webCrawler(girlFirstNameWeb);

        //利用正则表达式，把符合要求的数据提取出来
        ArrayList<String> familyNameTempData = getData(lastName,"(.{4})(，|。)",1);
        ArrayList<String> boysNameTempData = getData(boysName,"([\\u4E00-\\u9FA5]{2})(、|。)",1);
        ArrayList<String> girlsNameTempData = getData(girlsName,"(.. ){4}..",0);

        ArrayList<String> familyNameList = new ArrayList<>();

        for(String s:familyNameTempData){
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                familyNameList.add(c+"");
            }
        }

        //男生名字去除其中的重复元素
        HashSet<String> boysNameSet = new HashSet<>();
        ArrayList<String> boysNameList = new ArrayList<>();
        for (String str : boysNameTempData) {
            if(!boysNameList.contains(str)){
                boysNameSet.add(str);
            }
        }
        ArrayList<String> girlsNameList = new ArrayList<>();
        for (String str : girlsNameTempData) {
            String[] s = str.split(" ");
            for (int i = 0; i < s.length; i++) {
                girlsNameList.add(s[i]);
            }
        }
        //1.生成不重复的名字
        ArrayList<String> infos = getInfos(familyNameList, boysNameList, girlsNameList, 70,50);
        Collections.shuffle(infos);

        BufferedWriter bw = new BufferedWriter(new FileWriter("day05\\name.txt"));
        for (String info : infos) {
            bw.write(info);
            bw.newLine();
        }
        bw.close();
    }

    public static ArrayList<String> getInfos(ArrayList<String> familyNameList,ArrayList<String> boysNameList,ArrayList<String> girlsNameList,int boyCount,int girlCount){
        //1.生成不重复的名字
        HashSet<String> boyhs = new HashSet<>();
        while(true)
        {
            if(boyhs.size()==boyCount){
                break;
            }
            Collections.shuffle(familyNameList);
            Collections.shuffle(boysNameList);
            boyhs.add(familyNameList.get(0)+boysNameList.get(0));
        }
        HashSet<String> girlhs = new HashSet<>();
        while(true)
        {
            if(girlhs.size()==girlCount){
                break;
            }
            Collections.shuffle(familyNameList);
            Collections.shuffle(girlsNameList);
            girlhs.add(familyNameList.get(0)+girlsNameList.get(0));
        }
        ArrayList<String> list = new ArrayList<>();
        Random r=new Random();
        for (String boyName : boyhs) {
            int age = r.nextInt(10) + 18;
            list.add(boyName+"-男-"+age);
        }
        for (String girlName : girlhs) {
            int age = r.nextInt(8) + 18;
            list.add(girlName+"-女-"+age);
        }
        return list;
    }


    private static ArrayList<String> getData(String name,String regex,int index) {
        //1.创建集合存放数据
        ArrayList<String> list = new ArrayList<>();
        //2.按照正则表达式的规则获取数据
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(name);
        while(matcher.find()){
            list.add(matcher.group(index));
        }
        return list;
    }

    public static String webCrawler(String net) throws IOException {
        //1.定义一个StringBuilder拼接爬取到的数据
        StringBuilder sb = new StringBuilder();
        //2.创建一个URL对象
        URL url = new URL(net);
        //3.打开一个连接,要保证网络畅通，且网址可以连接
        URLConnection conn = url.openConnection();
        //4.获取连接的输入流
        InputStreamReader isr = new InputStreamReader(conn.getInputStream());

        int ch;
        while ((ch = isr.read()) != -1) {
            sb.append((char) ch);
        }
        isr.close();
        return sb.toString();
    }
}
