package com.cumt.date;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class DateDemo1 {
    public static void main(String[] args) {
        SimpleDateFormat sdf=new SimpleDateFormat();
        Date d=new Date(0L);
        String str=sdf.format(d);
        System.out.println(str);

        SimpleDateFormat sdf2=new SimpleDateFormat("yyyy年MM月dd日 aa HH:mm:ss EE");
        //Date d2=new Date(0L);
        String str2=sdf2.format(d);
        System.out.println(str2);
    }
}
