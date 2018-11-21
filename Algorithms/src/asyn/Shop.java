package asyn;

import java.util.Random;

public class Shop {
    private String name;

    public String getName() {
        return name;
    }

    public Shop(String name) {

        this.name = name;
    }

    public double getPrice(String product){
        return calculatePrice(product);
    }
    public String getPriceFormat(String product){
        Random random = new Random();
        double price = calculatePrice(product);
        Discount.Code code = Discount.Code.values()[random.nextInt(Discount.Code.values().length)];
        return String.format("%s:%.2f:%s  ",name,price,code);
    }
    private double calculatePrice(String product){
        delay();
        return Math.random() * product.charAt(0) + product.charAt(1);
    }
    public static void delay(){
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
