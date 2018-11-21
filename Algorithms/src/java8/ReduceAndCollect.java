package java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class ReduceAndCollect {
    public static void main(String[] args){
        Stream<Integer> stream = Arrays.asList(1,2,3,4,5).stream();
        List<Integer> numbers = stream.reduce(new ArrayList<>(),(List<Integer> l,Integer e)->{l.add(e);return l;}
        ,(List<Integer> l1, List<Integer>l2)->{l1.addAll(l2);return l1;});
               numbers .stream().forEach(System.out::println);
    }
}
