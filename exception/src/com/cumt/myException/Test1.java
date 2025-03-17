package com.cumt.myException;

public class Test1 {
    public static void main(String[] args) {
        int[] array={1,2,3,4,5};

        try{
            System.out.println(10/0);
            System.out.println(array[5]);
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("数组越界");
        }
    }
}
