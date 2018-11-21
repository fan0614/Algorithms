import java.util.*;
import java.util.function.*;
import java.lang.String;
public class LambdaTest {
    public static void main(String[] args) {
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("Before Java8, too much code for too little to do");
//            }
//        }).start();
//        new Thread(()->System.out.println("In Java8, Lambda expression rocks !!")).start();

//        List features = Arrays.asList("Lambdas", "Default Method", "Stream API", "Date and Time API");
//        for (Object f:features) {
//            System.out.println(f);
//        }
//        List features = Arrays.asList("Lambdas", "Default Method", "Stream API", "Date and Time API");
//       features.forEach(n -> System.out.println(n));
//        features.forEach(System.out::println);
        List languages = Arrays.asList("Java", "Scala", "C++", "Haskell", "Lisp");
        Predicate<String> startsWithJ = (n) -> n.startsWith("J");
        Predicate<String> fourLetterLong = (n) -> n.length() == 4;
        languages.stream()
                .filter(startsWithJ.and(fourLetterLong))
                .forEach((n) -> System.out.print("nName, which starts with 'J' and four letter long is : " + n));
//        System.out.println("Languages which starts with J :");
//       // filter(languages, (str)->str.startsWith("J"));
//
//        System.out.println("Languages which ends with a ");
//        //filter(languages, (str)->str.endsWith("a"));
//
//        System.out.println("Print all languages :");
//        filter(languages, (str)->true);
//
//        System.out.println("Print no language : ");
//        filter(languages, (str)->false);
//
//        System.out.println("Print language whose length greater than 4:");
//        //filter(languages, (str)->str.length() > 4);
//
//
//    }
//    public static void filter(List names, Predicate condition) {
//        for (Object name : names) {
//            if (condition.Test(name)) {
//                System.out.println(name + " ");
//            }
//        }
//    }
    }
}
