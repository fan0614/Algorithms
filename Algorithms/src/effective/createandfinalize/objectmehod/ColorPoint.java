package effective.createandfinalize.objectmehod;

import java.awt.*;

public class ColorPoint extends Point {
    private final Color color;
    public ColorPoint(int x,int y,Color color){
        super(x,y);
        this.color = color;
    }

//    @Override
//    //violates Symmetry
//    public boolean equals(Object obj) {
//        if(!(obj instanceof ColorPoint))
//            return false;
//        return super.equals(obj) && ((ColorPoint) obj).color == color;
//    }
    //Broken-violate transitivity
    //面向对象语言中的关于等价关系的基本问题。 我们无法在扩展可以实例化的类的同时，既增加新的值组件，同时又保留equals约定
//    @Override
//    public boolean equals(Object obj) {
//        if(!(obj instanceof Point))
//            return false;
//        if(!(obj instanceof ColorPoint))
//            return obj.equals(this);
//        return super.equals(obj) && ((ColorPoint) obj).color == color;
//    }

    //使用getClass 代替 instanceOf测试
    //broken - violate Liskow substitution principle
    @Override
    public boolean equals(Object obj) {
        if(obj == null || obj.getClass() != this.getClass())
            return false;
        Point p = (Point) obj;
        return p.x ==x && p.y==y;
    }

    public static void main(String[] args) {
        ColorPoint p1 = new ColorPoint(1,2,Color.RED);
        Point p2 = new Point(1,2);
        ColorPoint p3 = new ColorPoint(1,2,Color.black);
        System.out.println(p1.equals(p2));
        System.out.println(p2.equals(p3));
        System.out.println(p1.equals(p3));
    }
}
