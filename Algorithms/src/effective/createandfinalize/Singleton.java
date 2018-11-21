package effective.createandfinalize;

public class Singleton {
    //方式1  私有化构造器,导出共有静态成员
//    public static final Singleton INSTANCE = new Singleton();
    private Singleton(){
//        System.out.println(b);
    }
    //方式2  共有成员是个静态工厂方法
    private static final Singleton INSTANCE = new Singleton();
    public static Singleton getInstance(){return INSTANCE;}
    //方式3   jdk1.5之后
    //编写一个包含一个元素的枚举类型
    public enum Singletons{
        INSTANCS;

    }
}
