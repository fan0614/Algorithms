package mst;

import graph.Graph;

import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;

//最小生成树的Prim算法的延时实现     会在优先队列中保留失效的边。
public class LazyPrimMST {
    private boolean[] marked;//最小生成树的顶点
    private Queue<Edge> mst;  //最小生成树的边
    private PriorityQueue<Edge> pq;  //横切边（包括失效的边）

    public LazyPrimMST(EdgeWeightedGraph G){
        pq = new PriorityQueue<Edge>((a,b)->(int)(a.weight()-b.weight()));
        marked = new boolean[G.V()];
        mst = new ArrayDeque<>();

        visit(G,0);//假设G是连通的
        while(!pq.isEmpty()){
            Edge e = pq.poll();  //从pq中得到权重最小的边
            int v = e.either(),w = e.other(v);//跳过失效的边
            if(marked[v] && marked[w]) continue;
            mst.add(e);
            if(!marked[v]) visit(G,v);
            if(!marked[w]) visit(G,w);
        }
    }
    private void visit(EdgeWeightedGraph G,int v){
        //标记顶点v并将所有连接v和未被标记顶点的边加入pq
        marked[v] = true;
        for(Edge e : G.adj(v))
            if(!marked[e.other(v)]) pq.add(e);
    }
    public Iterable<Edge> edges(){
        return mst;
    }
    public double weight(){
        double sum = 0L;
        for(Edge e : mst){
            sum+=e.weight();
        }
        return sum;
    }
}
