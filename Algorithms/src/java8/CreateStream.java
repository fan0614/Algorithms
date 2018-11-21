package java8;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class CreateStream {
    public static void main(String[] args){
        Stream<String> stream = Stream.of("Java8","Lambda","In","Action");
        stream.map(String::toUpperCase).forEach(System.out::println);

        int[] numbers = {2,3,5,7,11,13};
        int sum = Arrays.stream(numbers).sum();
        System.out.println(sum);

        long uniqueWords = 0;
        try(Stream<String> lines = Files.lines(Paths.get("C:\\Users\\11251\\IDEA\\Algorithms\\src\\java8\\data.txt"), Charset.defaultCharset())){
            uniqueWords = lines.flatMap(line -> Arrays.stream(line.split("")))
                    .distinct()
                    .count();
        }
        catch (IOException e){
            System.out.println("异常");
        }
        System.out.println(uniqueWords);

        List<String> words = Arrays.asList("Hello","World");
//        List<String[]> ws = words.stream()
//                     .map(word->word.split(""))
//                    .distinct()
//                     .forEach(t->System.out.println(t[0]+","+t[1]));
//        System.out.println(ws[]);

    }
}
