package com.cumt.test;
import java.util.Random;
public class Test {
    public static void main(String[] args) {
        //需求，把一位数组中的数据打乱顺序，然后再按照四个一组的顺序添加到二维数组中去
        int[] arr = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,0};
        //打乱顺序
        for (int i = 0; i < arr.length; i++) {
            int randomIndex = (int) (Math.random() * arr.length);
            int temp = arr[i];
            arr[i] = arr[randomIndex];
            arr[randomIndex] = temp;
        }
        //按照四个一组的顺序添加到二维数组中去
        int[][] data = new int[4][4];
        for (int i = 0; i < data.length; i++) {
            System.arraycopy(arr, i * 4, data[i], 0, data[i].length);
        }
        //遍历二维数组
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                System.out.print(data[i][j] + " ");
            }
            System.out.println();
        }
        //方法2
//        Random r=new Random();
//        for (int i = 0; i <arr.length; i++) {
//            int index=r.nextInt(arr.length);
//            int temp=arr[i];
//            arr[i]=arr[index];
//            arr[index]=temp;
//        }

    }
}
