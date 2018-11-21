package spt;

import java.util.ArrayList;
import java.util.Stack;

//最短路径API
public class SP {
    private DirectedEdge[] edgeTo;
    private double[] distTo;
    //构造函数
    public SP(EdgeWeightedDigraph G,int s){

    }
    //从顶点s到达v的距离，如果不存在，则路径为无穷大
    public double distTo(int v) {
        return distTo[v];
    }
    //是否存在从顶点s到v的路径
    public boolean hasPathTo(int v){
        return distTo[v] < Double.POSITIVE_INFINITY;
    }
    //从顶点s到v的路径，如果不存在则为null
    public Iterable<DirectedEdge> pathTo(int v){
        if(!hasPathTo(v)) return null;
        Stack<DirectedEdge> path = new Stack<>();
        for(DirectedEdge e = edgeTo[v]; e !=null ; e = edgeTo[e.from()])
            path.push(e);
        return path;
    }
}
