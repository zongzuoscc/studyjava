package com.cumt.practice;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Test2 {

	public static void main(String[] args) throws IOException {
        ArrayList<Student> list=new ArrayList<>();
        BufferedReader br=new BufferedReader(new FileReader("names.txt"));
        String line;
        while((line=br.readLine())!=null){
            String[] split = line.split("-");
            Student stu =new Student(split[0],split[1],Integer.parseInt(split[2]),Double.parseDouble(split[3]));
            list.add(stu);
        }
        br.close();

        double weight=0;
        for (Student stu : list) {
            weight =weight + stu.getWeight();
        }
        //计算每一个人的实际比重
        double[] arr=new double[list.size()];
        int index=0;
        for (Student stu : list) {
            arr[index] = stu.getWeight() / weight;
            index++;
        }
        //计算每一个人的权重占比范围
        for (int i = 1; i < arr.length; i++) {
            arr[i]=arr[i-1]+arr[i];
        }
        //获取一个0到1之间的随机数
        double random = Math.random();
        //获取随机数在数组中的位置
        int index2 = -Arrays.binarySearch(arr, random)-1;//方法返回的是-插入点-1
        Student stu=list.get(index2);
        System.out.println(stu);

        double w=stu.getWeight()/2;
        stu.setWeight(w);

        BufferedWriter bw=new BufferedWriter(new FileWriter("names.txt"));
        for (Student s : list) {
            bw.write(s.toString());
            bw.newLine();
        }
        bw.close();
    }
}
