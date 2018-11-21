package java8;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class ReduceTest {
    public static void main(String [] args){
        List<Integer> numbers = Arrays.asList(4,5,3,9);
//        int sum = numbers.stream().reduce(0,(a,b)->a+b);
        int sum = numbers.stream().reduce(0,Integer::max);
        Optional<Integer> sum2 = numbers.stream().reduce((a, b)->a+b);
        System.out.println(sum);
        System.out.println(sum2);
    }
}
