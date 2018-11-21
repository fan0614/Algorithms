package graph;

import java.util.ArrayList;
import java.util.Stack;

//有向环的API
public class DirectedCycle {
    private boolean[] marked;
    private int[] edgeTo;
    private Stack<Integer> cycle; //有向环中的所有顶点
    private boolean[] onStack;  //递归调用的栈上的所有顶点

    //寻找有向环的构造函数
    public DirectedCycle(Digraph G){
        onStack = new boolean[G.V()];
        edgeTo = new int[G.V()];
        marked = new boolean[G.V()];
        for(int v = 0;v < G.V();v++){
            if(!marked[v]) dfs(G,v);
        }
    }
    private void dfs(Digraph G,int v){
        onStack[v] = true;
        marked[v] = true;
        for(int w : G.adj(v)){
            if(this.hasCycle()){
                return;
            }
            else if(!marked[w]){
                edgeTo[w] = v;
                dfs(G,w);
            }
            else if(onStack[w]){
                cycle = new Stack<Integer>();
                for(int x = v;x!=w;x = edgeTo[x]){
                    cycle.push(x);
                }
                cycle.push(w);
                cycle.push(v);
            }
        }
        onStack[v] = false;

    }
    //G是否含有有向环
    public boolean hasCycle(){
        return cycle != null;
    }
    //有向环中的所有顶点(如果存在的话)
    public Iterable<Integer> cycle(){
        return cycle;
    }
}
