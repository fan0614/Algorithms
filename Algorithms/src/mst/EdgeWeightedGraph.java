package mst;

import java.util.*;

//加权无向图的API
public class EdgeWeightedGraph {
    private final int V; //顶点总数
    private int E; //边的总数
    private List<Edge>[] adj; //邻接表

    //创建一幅含有V个顶点的空图
    public EdgeWeightedGraph(int V){
        this.V = V;
        this.E = 0;
        adj = (List<Edge>[]) new List[V];
        for(int v = 0; v < V; v++)
            adj[v] = new ArrayList<>();
    }
    //图的顶点数
    public int V(){return V;}
    //图的边数
    public int E(){return E;}
    //像图中添加一条边e
    public void addEdge(Edge e){
        int v = e.either(),w = e.other(v);
        adj[v].add(e);
        adj[w].add(e);
        E++;
    }
    //和v相关联的所有边
    public Iterable<Edge> adj(int v){
        return adj[v];
    }
    //图的所有边
    public Iterable<Edge> edges(){
        List<Edge> l = new ArrayList<>();
        for(int v = 0;v < V;v++){
            for(Edge e : adj[v])
                if(e.other(v)>v) l.add(e);
        }
        return l;
    }
    //对象的字符串表示
    public String toString(){
        return "";
    }

    public static void main(String[] args) {
        Map<String,Integer> map = new HashMap<>();
        map.put("sss",1);
    }
}
