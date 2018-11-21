package spt;

import java.util.Arrays;

public class test {
    public static void main(String[] args) {
//        String[] str = new String[]{"3","30","34","10","9"};
//        Arrays.sort(str);
//        System.out.println(str);

        System.out.println(reI());
    }
    public static int reI(){
        int i;
        try{
            i = 1;
            return i;
        }finally {
            i = 3;
        }
    }
}
