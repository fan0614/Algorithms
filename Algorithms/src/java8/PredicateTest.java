package java8;

import java.util.ArrayList;
import java.util.List;

public class PredicateTest {
    @FunctionalInterface
    public interface Predicate<T>{
        boolean test(T t);
    }
    public static <T> List<T> filter(List<T> list, Predicate p){
        List<T> results = new ArrayList<>();
        for (T s : list){
            if(p.test(s)){
                results.add(s);
            }
        }
        return results;
    }
    Predicate<String> nonEmptyStringPredicate = (String s) -> !s.isEmpty();
 //   List<String> nonEmpty = filter(listofStrings, nonEmptyStringPredicate);
}
