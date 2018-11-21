package asyn;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import static java.util.stream.Collectors.toList;

public class AsynTest {
    private static List<Shop> shops = Arrays.asList(new Shop("BestPrice"),
            new Shop("LetsSaveBig"),
            new Shop("MyFavoriteShop"),
            new Shop("BuyItAll"),
            new Shop("Zhang"));
    public static List<String> findPrices(String product){
        return shops.parallelStream()
                .map(shop -> String.format("%s price is %.2f",shop.getName(),shop.getPrice(product)))
                .collect(toList());
    }
    public static List<String> findPricesAsyn(String product){
        List<CompletableFuture<String>> priceFuture = shops.stream()
                .map(shop -> CompletableFuture.supplyAsync(
                        () -> String.format("%s price is %.2f",shop.getName(),shop.getPrice(product))))
                .collect(toList());
        return priceFuture.stream().map(CompletableFuture::join).collect(toList());
    }
    public List<String> findPrice(String product){
        return shops.stream().map(shop -> shop.getPriceFormat(product))
                .map(Quote::parse)
                .map(Discount::applyDiscount)
                .collect(toList());
    }
    public static void main(String[] args){
        System.setProperty("java.util.concurrent.ForkJoinPool.common.parallelism", "8");
        long start = System.nanoTime();
        System.out.println(findPrices("myPhones27S"));
        //System.out.println(findPricesAsyn("myPhones27S"));
        long duration = (System.nanoTime()-start)/1_000_000;
        System.out.println(duration);
    }
}
