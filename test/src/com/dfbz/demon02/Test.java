package com.dfbz.demon02;

public class Test {
    public static void main(String[] args) {
        int num=5;
        int sum=sum(num);
        System.out.println(sum);
    }
    public static int sum(int num){
        if (num==1){
            return 1;
        }
        return num*sum(num-1);
    }
}

