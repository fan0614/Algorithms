package java8;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.*;

public class Test {
    public enum CaloricLevel { DIET, NORMAL, FAT}
    public static void main (String [] args){
        List<Dish> menu = Arrays.asList(
                new Dish("pork",false,800,Dish.Type.MEAT),
                new Dish("beef",false,700,Dish.Type.MEAT),
                new Dish("chicken",false,400,Dish.Type.MEAT),
                new Dish("french fries",true,530,Dish.Type.OTHER),
                new Dish("rice",true,350,Dish.Type.OTHER),
                new Dish("serson fruit",true,120,Dish.Type.OTHER),
                new Dish("pizza",true,550,Dish.Type.OTHER),
                new Dish("prawns",false,300, Dish.Type.FISH),
                new Dish("salmon",false,450,Dish.Type.FISH)
        );
        long howManyDishes = menu.stream().collect(counting());
        System.out.println(howManyDishes);
        Comparator<Dish> dishCaloriesComparator = Comparator.comparingInt(Dish::getCalories);
        Optional<Dish> mostCaloriesDish = menu.stream().collect(maxBy(dishCaloriesComparator));
        System.out.println(mostCaloriesDish);
        double avgCalories = menu.stream().collect(averagingDouble(Dish::getCalories));
        System.out.println(avgCalories);
        IntSummaryStatistics menuStatistics = menu.stream().collect(summarizingInt(Dish::getCalories));
        System.out.println(menuStatistics);
        String shortMenu = menu.stream().map(Dish::getName).collect(joining(","));
        System.out.println(shortMenu);
        //分组
        Map<Dish.Type,List<Dish>> dishByType = menu.stream().collect(groupingBy(Dish::getType));

        System.out.println(dishByType);

        Map<CaloricLevel,List<Dish>> dishesByCaloricLevel = menu.stream().collect(groupingBy(dish->
        {if(dish.getCalories()<= 400) return CaloricLevel.DIET;
        else if (dish.getCalories()<=700) return CaloricLevel.NORMAL;
        else return CaloricLevel.FAT;}
        ));
        System.out.println(dishesByCaloricLevel);
        int total = menu.stream().collect(reducing(0,Dish::getCalories,(i,j)->i+j));
        System.out.println("total:"+total);
        Map<Dish.Type,Dish> mostCaloriesByType = menu.stream().collect(groupingBy(Dish::getType,collectingAndThen(maxBy(Comparator.comparing(Dish::getCalories)),Optional::get)));
        System.out.println(mostCaloriesByType);
        Map<Dish.Type,Integer> totalCaloriesByType = menu.stream().collect(groupingBy(Dish::getType,summingInt(Dish::getCalories)));

        Map<Boolean,List<Dish>> partitionedMenu = menu.stream().collect(partitioningBy(Dish::isVegetarian));
        System.out.println(partitionedMenu);
        //Trader a = new Trader("zz","tt");
        //System.out.println(a.hashCode());
    }
}
