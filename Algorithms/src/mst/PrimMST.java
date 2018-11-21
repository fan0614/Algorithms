package mst;

import java.util.ArrayList;
import java.util.PriorityQueue;

//最小生成树的Prim算法(即时版本)
public class PrimMST {
    private Edge[] edgeTo; //距离树最近的边
    private double[] distTo; //dist[w] = edgeTo[w].weight()
    private boolean[] marked; //如果v在树中则为true
    private int[] qp; //索引
    private PriorityQueue<Edge> pq; //有效的横切边

    public PrimMST(EdgeWeightedGraph G){
        edgeTo = new Edge[G.V()];
        distTo = new double[G.V()];
        marked = new boolean[G.V()];
        qp = new int[G.V()];
        for(int v=0;v<G.V();v++) {
            qp[v] = -1;
            distTo[v] = Double.POSITIVE_INFINITY;
        }
        pq = new PriorityQueue<Edge>((a,b)->(int)(a.weight()-b.weight()));

        distTo[0] = 0.0;
        qp[0] = 0;
        pq.add(new Edge(0,0,0.0)); //用顶点0和权重0初始化pq
        while(!pq.isEmpty()){
            Edge e = pq.poll();
            e.either();
            visit(G,0);  //将最近的顶点添加到树中
        }
    }
    private void visit(EdgeWeightedGraph G, int v){
        //将顶点v添加到树中，更新数据
        marked[v] = true;
        for(Edge e : G.adj(v)){
            int w = e.other(v);

            if(marked[w]) continue; //v-w失效
            if(e.weight() < distTo[w]){
                //连接w和树的最佳边Edge变为e
                edgeTo[w] = e;
                distTo[w] = e.weight();
//               if(pq.contains(w))  ;
//               else pq.add(new Edge(v,w,e.weight()));
                if(qp[w] != -1){
                    pq.remove(e);
                    pq.add(e);
                }else{
                    pq.add(e);
                }
            }
        }
    }
    public Iterable<Edge> edges(){return new ArrayList<>();}
    public double weight(){return 0L;}
    public static void main(String[] args) {
//        System.out.println(1.0/0.0);

    }
}
