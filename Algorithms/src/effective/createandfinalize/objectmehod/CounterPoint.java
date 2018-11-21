package effective.createandfinalize.objectmehod;

import effective.createandfinalize.objectmehod.Point;

import java.util.concurrent.atomic.AtomicInteger;

//不添加值组件的方式扩展了Point
public class CounterPoint extends Point {
    private static final AtomicInteger counter = new AtomicInteger();

    public CounterPoint(int x,int y){
        super(x,y);
        counter.incrementAndGet();
    }
    public int numberCreated(){return counter.get();}
}
