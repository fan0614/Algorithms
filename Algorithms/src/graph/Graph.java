package graph;

import java.util.ArrayList;
import java.util.List;


public class Graph {
    private int V;   //顶点数目
    private int E;          //边的数目
    private List<Integer>[] adj; //邻接表
    public Graph(int v){
        this.V = v;
        this.E = 0;
        adj = (List<Integer>[]) new List[v]; // 创建邻接表
        for(int i = 0; i<v;i++){
            adj[i] = new ArrayList<Integer>();
        }
    }
    public int V(){
        return V;
    }
    public int E(){
        return E;
    }
    public void addEdge(int v,int w){
        adj[v].add(w);
        adj[w].add(v);
        E++;
    }
    public Iterable<Integer> adj(int v){
        return adj[v];
    }
    //图的邻接表的字符串表示
    public String toString(){
        String s = V + " verteices, " + E + " edges\n";
        for(int v = 0; v < V;v++){
            s += v + ":";
            for (int w : this.adj(v)){
                s += w + " ";
            }
            s += "\n";
        }
        return s;
    }
}
