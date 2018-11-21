package spt;

import sort.IndexMinPQ;

import java.util.PriorityQueue;
import java.util.Stack;

//最短路径的Dijkstra算法
public class DijkstraSP {
    private DirectedEdge[] edgeTo;
    private double[] distTo;
    private IndexMinPQ<Double> pq;
//    private int[] qp;

    public DijkstraSP(EdgeWeightedDigraph G,int s){
//        qp = new int[G.V()];
        edgeTo = new DirectedEdge[G.V()];
        distTo = new double[G.V()];
//        pq = new PriorityQueue<>((a,b)->(int)(a.weight()-b.weight()));
        pq = new IndexMinPQ<Double>(G.V());
        for(int v = 0; v < G.V();v++){
//            qp[v] = -1;
            distTo[v] = Double.POSITIVE_INFINITY;
        }
        distTo[s] = 0.0;
        while(!pq.isEmpty())
            relax(G,pq.delMin());
    }
    private void relax(EdgeWeightedDigraph G,int v){
        for(DirectedEdge e : G.adj(v)){
            int w = e.to();
            if(distTo[w]>distTo[v] + e.weight()){
                distTo[w] = distTo[v] + e.weight();
                edgeTo[w] = e;
                if(pq.contains(w)) pq.change(w,distTo[w]);
                else pq.insert(w,distTo[w]);
//                if(qp[w] != -1){
//                    for(DirectedEdge de: pq){
//                        if(de.to() == w){
//                            pq.remove(de);
//                        }
//                    }
//                    pq.add(e);
//                    qp[w] = v;
//                }
//                else {
//                    pq.add(e);
//                    qp[w] = v;
//                }
            }
        }
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
