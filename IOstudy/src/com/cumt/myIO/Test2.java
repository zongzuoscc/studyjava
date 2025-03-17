package com.cumt.myIO;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Test2 {
    public static void main(String[] args) throws IOException {
        FileReader fr=new FileReader("D:\\test.txt");
        StringBuilder sb=new StringBuilder();
        int ch;
        while((ch=fr.read())!=-1){
            sb.append((char)ch);
        }
        fr.close();
        System.out.println(sb);

        int[] array = Arrays.stream(sb.toString().split("-"))
                .mapToInt(Integer::parseInt)
                .sorted()
                .toArray();

        System.out.println(Arrays.toString(array));

        String s = Arrays.toString(array)
                .replace("[", "")
                .replace("]", "")
                .replace(", ", "-");
        String result = s.substring(0, s.length() - 1);
        FileWriter fw=new FileWriter("D:\\test.txt");
        fw.write(result);
        fw.close();

//        String str =sb.toString();
//        String[] split = str.split("-");
//        ArrayList<Integer> list=new ArrayList<>();
//        list.forEach(s->list.add(Integer.parseInt(str)));
//        Collections.sort(list);
//        System.out.println(list);
//        FileWriter fw=new FileWriter("D:\\test.txt");


    }
}
