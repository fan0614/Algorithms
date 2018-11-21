package graph;

import mst.Edge;
import spt.DirectedEdge;
import spt.EdgeWeightedDigraph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

//有向图中基于深度优先搜索的顶点排序
public class DepthFirstOrder {
    private boolean[] marked;
    private Queue<Integer> pre;  //所有顶点的前序排列
    private Queue<Integer> post;  //所有顶点的后序排列
    private Stack<Integer> reversePost; //所有顶点的逆后序排列

    public DepthFirstOrder(Digraph G){
        pre = new LinkedList<Integer>();
        post = new LinkedList<Integer>();
        reversePost = new Stack<Integer>();
        marked = new boolean[G.V()];

        for(int v = 0;v < G.V();v++){
            if(!marked[v]) dfs(G,v);
        }
    }
    public DepthFirstOrder(EdgeWeightedDigraph G){
        pre = new LinkedList<Integer>();
        post = new LinkedList<Integer>();
        reversePost = new Stack<Integer>();
        marked = new boolean[G.V()];

        for(int v = 0;v < G.V();v++){
            if(!marked[v]) dfs(G,v);
        }
    }

    private void dfs(Digraph G,int v){
        marked[v] = true;
        pre.add(v);
        for(int w : G.adj(v)){
            if(!marked[w]) dfs(G,w);
        }
        post.add(v);
        reversePost.push(v);
    }
    private void dfs(EdgeWeightedDigraph G,int v){
        marked[v] = true;
        pre.add(v);
        for(DirectedEdge w : G.adj(v)){
            if(!marked[w.to()]) dfs(G,w.to());
        }
        post.add(v);
        reversePost.push(v);
    }
    public Iterable<Integer> pre(){
        return pre;
    }
    public Iterable<Integer> post(){
        return post;
    }
    public Iterable<Integer> reversePost(){
        return reversePost;
    }
}
