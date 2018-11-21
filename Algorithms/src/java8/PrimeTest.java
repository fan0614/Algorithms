package java8;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PrimeTest {
    public static boolean isPrime(int candidate){
        int candidateRoot = (int) Math.sqrt((double) candidate);
        return IntStream.rangeClosed(2,candidateRoot)
                .noneMatch(i -> candidate % i == 0);
    }
    public static Map<Boolean,List<Integer>> partitionPrimes(int n){
        return IntStream.rangeClosed(2,n).boxed()
                .collect(
                        Collectors.partitioningBy(candidate -> isPrime(candidate)));
    }
    public static <A> List<A> takeWhile(List<A> list,Predicate<A> p){
        int i = 0;
        for(A item : list){
            if(!p.test(item)){
                return list.subList(0,i);
            }
            i++;
        }
        return list;
    }
    public static boolean isPrime(List<Integer> primes, int candidate){
        int candidateRoot = (int) Math.sqrt((double) candidate);
        return takeWhile(primes,i -> i <= candidateRoot)
                .stream()
                .noneMatch(p -> candidate % p == 0);
    }

    public static Map<Boolean,List<Integer>> partitionPrimeWithCustomCollector(int n){
        return IntStream.rangeClosed(2,n).boxed()
                .collect(new PrimeCollector());
    }
    public static void main(String[] args){
//        System.out.println(new PrimeTest().partitionPrimes(100));
//        System.out.println(IntStream.rangeClosed(2,100).boxed()
//                .collect(new PrimeCollector()));
        long fastest = Long.MAX_VALUE;
        for(int i = 0; i <= 10; i++){
            long start = System.nanoTime();
           partitionPrimeWithCustomCollector(1_000_000);
           //partitionPrimes(1___000___000);
            long duration = (System.nanoTime()-start)/1_000_000;
            if(duration<fastest) fastest = duration;
            System.out.println(duration);

        }
        System.out.println(fastest);
//        System.out.println(Runtime.getRuntime().availableProcessors());
//        System.out.println(System.getProperty("java.version"));
    }
}
