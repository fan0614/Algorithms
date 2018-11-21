package spt;

import java.util.ArrayList;
import java.util.List;

//加权有向图的API
public class EdgeWeightedDigraph {
    private final int V; //顶点总数
    private int E;  //边的总数
    private List<DirectedEdge>[] adj;  //邻接表

    //含有V个顶点的空有向图
    public EdgeWeightedDigraph(int V){
        this.V = V;
        this.E = 0;
        adj = (List<DirectedEdge>[]) new List[V];
        for(int v=0;v < V;v++){
            adj[v] = new ArrayList<DirectedEdge>();
        }
    }
    //顶点总数
    public int V(){
        return V;
    }
    //边的总数
    public int E(){
        return E;
    }
    //将e添加到该有向图中
    public void addEdge(DirectedEdge e){
        adj[e.from()].add(e);
        E++;
    }
    //从v指出的边
    public Iterable<DirectedEdge> adj(int v){
        return adj[v];
    }
    //该有向图中所有的边
    public Iterable<DirectedEdge> edges(){
        List<DirectedEdge> lst = new ArrayList<>();
        for(int v = 0; v < V; v++)
            for(DirectedEdge e : adj[v])
                lst.add(e);
        return lst;
    }

    @Override
    public String toString() {
        return "";
    }
}
