package graph;

import java.util.Arrays;

//有向图的深度优先搜索
public class DirectedDFS {
    private boolean[] marked;

    //在G中找到从s可达的所有顶点
    public DirectedDFS(Digraph G,int s){
        marked = new boolean[G.V()];
        dfs(G,s);
    }
    //在G中找到从sources中所有顶点可达的所有顶点
    public DirectedDFS(Digraph G,Iterable<Integer> sources){
        marked = new boolean[G.V()];
        for(int s : sources){
            if(!marked[s]) dfs(G,s);
        }
    }
    private void dfs(Digraph G, int v){
        marked[v] = true;
        for(int w : G.adj(v))
            if(!marked[w]) dfs(G,w);
    }
    //boolean 类型是可达的吗
    public boolean marked(int v){
        return marked[v];
    }
}
