package parallel;

import java.util.function.Function;
import java.util.stream.LongStream;

public class SumTest {
    public static long iterativeSum(long n){
        long result = 0;
        for(long i = 1L; i <= n; i++){
            result += i;
        }
        return  result;
    }
    public static long sequentialSum(long n){
        return LongStream.rangeClosed(1,n)
                .reduce(0L,Long::sum);
    }
    public static long parallelSum(long n){
        return LongStream.rangeClosed(1,n)
                .parallel()
                .reduce(0L,Long::sum);
    }

    public static long measureSumPerf(Function<Long,Long> addr,long n){
        long fastest = Long.MAX_VALUE;
        for(int i = 0; i < 10 ; i++){
            long start = System.nanoTime();
            long sum = addr.apply(n);
            long duration = (System.nanoTime()-start)/1_000_000;
            //System.out.println("Result:"+sum);
            System.out.print(duration+"  ");
            if(duration<fastest) fastest = duration;
        }
        return fastest;
    }
    public static void main(String[] args){
       // System.out.print("1:"+measureSumPerf(SumTest::iterativeSum,10_000_000));
       // System.out.println();
        //System.out.println("2:"+measureSumPerf(SumTest::sequentialSum,10_000_000));
        System.out.println("3:"+measureSumPerf(SumTest::parallelSum,10_000_000));
        System.out.println();
       // System.out.println(measureSumPerf(ForkJoinSumCalculatorTest::forkJoinSum,10_000_000));
    }
}
