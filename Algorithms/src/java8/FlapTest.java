package java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class FlapTest {
//    static String[] arrayOfWords = {"Goodbye","World"};
//    static Stream<String> words = Arrays.stream(arrayOfWords);
//    public static void main(String [] args){
//       List<String> list = words.stream()
//                .map(word->word.split(""))
//                .map(Arrays::stream)
//                .distint()
//                .collect(toList());
//    }
    public static void main(String[] args){
        List<Integer> numbers1 = Arrays.asList(1,2,3);
        List<Integer> numbers2 = Arrays.asList(3,4);
        List<int[]> pairs = numbers1.stream()
                .flatMap(i->numbers2.stream()
                .map(j->new int[]{i,j}))
                .collect(toList());
        System.out.println(pairs.get(0)[1]);
    }
}
