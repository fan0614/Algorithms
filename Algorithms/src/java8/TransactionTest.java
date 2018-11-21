package java8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class TransactionTest {
    public static void main(String[] args){
        Trader raoul = new Trader("Raoul","Cambridge");
        Trader mario = new Trader("Mario","Milan");
        Trader alan = new Trader("Alan","Cambridge");
        Trader brian = new Trader("Brian","Cambridge");

        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian,2011,300),
                new Transaction(raoul,2012,1000),
                new Transaction(raoul,2011,400),
                new Transaction(mario,2012,710),
                new Transaction(mario,2012,700),
                new Transaction(alan,2012,950)
        );

        List<Transaction> tr2011 =
                transactions.stream()
                .filter(t->t.getYear()==2011)
                .sorted(Comparator.comparing(Transaction::getValue))
                .collect(Collectors.toList());
        System.out.println("1:"+tr2011);

        Stream<int[]> pythagoreanTriples =
                IntStream.rangeClosed(1,100).boxed()
                    .flatMap(a->
                        IntStream.rangeClosed(a,100)
                                .filter(b->Math.sqrt(a*a+b*b)%1==0)
                                .mapToObj(b->new int[]{a,b,(int)Math.sqrt(a*a+b*b)}));
        pythagoreanTriples.limit(5)
                .forEach(t->System.out.println(t[0]+","+t[1]+","+t[2]));

    }
}
