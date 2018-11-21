package test;

public class A {
    String str = "123";
    int a =10;
    static {
        int b = 11;
    }

    public A() {
        System.out.println("A");
//        this.b = 11;
    }

    public void printA(){
        System.out.println(a);
//        System.out.println(b);
    }
}
class B extends A{
    int a = 20;
//    void printB(){
//        super.printA();
//    }
    public B(){
        System.out.println("B");
    }
}
