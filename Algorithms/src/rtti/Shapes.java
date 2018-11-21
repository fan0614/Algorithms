package rtti;

import java.util.Arrays;
import java.util.List;

public class Shapes {
    public static void main(String[] args) {
        List<Shape> l = Arrays.asList(new Circle(),new Square(),new Triangle());
        for(Shape s : l){
            s.draw();
        }
    }
}
