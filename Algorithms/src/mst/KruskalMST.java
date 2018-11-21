package mst;

import graph.Union_Find;

import java.util.Collection;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

//最小生成树的Kruskal算法
public class KruskalMST {
    private Queue<Edge> mst;

    public KruskalMST(EdgeWeightedGraph G){
        mst = new LinkedList<Edge>();
        PriorityQueue<Edge> pq  =  new PriorityQueue<Edge>((Collection) G.edges());

        Union_Find uf = new Union_Find(G.V());

        while(!pq.isEmpty() && mst.size() < G.V() -1){
            Edge e = pq.poll();   //从pq得到权重最小的边和它的顶点
            int v = e.either(),w = e.other(v);
            if(uf.connected(v,w)) continue;  //忽略失效的边
            uf.union(v,w);  //合并分量
            mst.add(e);  //将边添加进入最小生成树中
        }
    }
    public Iterable<Edge> edges(){return mst;}
    public double weight(){
        double sum = 0;
        for(Edge e : mst){
            sum+= e.weight();
        }
        return sum;
    }
}
