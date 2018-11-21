public class CinitAndInit {
    static class Parent {
        static int a = 1;
        int b = 1;
        static {
            System.out.println("parent static block(a):" + (++a));
        }
        {
            System.out.println("parent  block(b):" + (++b));
        }
        public Parent() {
            System.out.println("parent construction");
        }
    }
    static class Child extends Parent {
        static int a = 1;
        int b = 1;
        static {
            System.out.println("child static block(a):" + (++a));
        }
        {
            System.out.println("child  block(b):" + (++b));
        }
        public Child() {
            System.out.println("child construction");
        }

    }
    public static void main(String[] args) {
        new Child();
    }

}
