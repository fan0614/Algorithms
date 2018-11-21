package io;

public class test {
    public static void main(String[] args) {
//        String x = "10";
//        String y = "20";
        swap("10","20");
        if (10<5){
            System.out.println("true");
        }
        else {
            System.out.println("false");
        }
//        System.out.println(x);
//        System.out.println(y);
    }
    public static void swap(String a ,String b){
        String temp;
        temp = a;
        a = b;
        b = temp;
    }
}
