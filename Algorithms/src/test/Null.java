package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Null {
    static class A {}

    static class B extends A {}
    static String s = null;
    public void hello(){
        System.out.println(getClass());
        System.out.println(getClass().getClassLoader());
        System.out.println(getClass().getClassLoader().getClass());
//        getClass().getClassLoader().getClass();
    }
    public static void main(String[] args) {
        new Null().hello();
        A aa = new B();
        System.out.println(aa instanceof B);
        System.out.println(B.class);
        List<A> lista = new ArrayList<A>();
        List<B> listb = new ArrayList<B>();
//        lista = listb;
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                synchronized (s){
//                    System.out.println("nihao");
//                }
//            }
//        }).start();
//       System.out.println(new Null().getClass());
//       B b = new B();
//       b.printA();
//       System.out.println(new String("abc").hashCode());
//        int c;
//        int [] a = {1,2,3,4,5,6,7,8};
//        for(int b : a){
//            System.out.println(b);
//        }
        Integer i = 10;
        int a,b=11;
//        List<String>[] stringLists = new List<String>[10];
//        List<String>[] stringLists = new List[10];
        List<String>[] stringLists = (List<String>[])new List[10];
        Object[] objects = stringLists;
        List<String> intList = Arrays.asList("1");
        objects[0] = intList;
        String str = stringLists[0].get(0);
//        System.out.println(a);
        System.out.println(str);
//        str="1010 0000 1001 0011 0110 0100 0001 0101 1110 1101 1001 1011 1011 1111 1111 0100 0000 1011 1100 1110 0011 1110 0001 101";
//        "110101001011101110001111100110001010100001101011101010000011011011001011101111001100000011011110011"
        System.out.println(Integer.valueOf(str,2)) ;
    }
    public boolean isPowerOfThree(int n) {
        for(;;){
            if(n==1){
                return true;
            }
            else{
                return false;
            }
        }
    }
}
