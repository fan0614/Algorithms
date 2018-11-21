package test;

public class Tests {
    public static int add(int x,int y){
        return x+y;
    }
    public static void main(String[] args) {
        System.out.println(new B().str);
//        B b = new B();
//        b.printB();
//        System.out.println(true+"hello");
//        double a = 1000000.112511115898999809990;
//        float f = 3.4f;
//        int d = 3;
//        int s = 1;
//        int s2 = 2;
        int a = 3;
        int b = 5;
        String add = new String("123");
        System.out.println(add(a,b));
        Math.max(a,b);
        String str = "abcdefg";
        System.out.println("***********");
        String strr[] = str.split("");
        for(int i = 0;i<strr.length;i++){
            System.out.println(strr[i]);
        }
//        Thread t = new Thread();
//        System.out.println(2=="2");
//        for (int i = 1, j = i + 1; i < 5 && j < 6; i++, j = i * 2,j++) {
//            System.out.println("i=" + i + " j=" + j);
//        }
//        A ca = new B();
//        ca.printA();
    }
}
