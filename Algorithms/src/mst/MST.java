package mst;

import java.util.ArrayList;

//最小生成树API
public class MST {
    //构造函数
    public MST(EdgeWeightedGraph G){

    }
    //最小生成树的所有边
    public Iterable<Edge> edges(){
        return new ArrayList<>();
    }
    //最小生成树的权重
    public double weight(){
        return 0L;
    }

    //测试用例
    public static void main(String[] args) {
        EdgeWeightedGraph G = new EdgeWeightedGraph(0);
        MST mst = new MST(G);
        for(Edge e : mst.edges())
            System.out.println(e);
    }
}
