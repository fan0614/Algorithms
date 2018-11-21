package graph;

import java.util.Random;

/*
G是无环图吗？  假设不存在自环或平行边
思路： 不能出现一个点的两个不同连接点均被访问过
 */
public class Cycle {
    private boolean[] marked;
    private boolean hasCycle;

    public Cycle(Graph G){
        marked = new boolean[G.V()];
        for(int s = 0;s<G.V();s++){
            if(!marked[s])
                dfs(G,s,s);
        }
    }
    public void dfs(Graph G,int v,int u){
        marked[v] = true;
        for(int w :G.adj(v))
            if (!marked[w])
                dfs(G,w,v);
            else if(w!=u) hasCycle = true;
        System.out.println(getClass());    
    }
    public boolean hasCycle(){return hasCycle;}

    public static void main(String[] args) {
//        System.out.println(getClass());
        int b = 4;
        String s = "";
        char ss = 'a';
        System.out.println(s);
        for(;;){
            double a = new Random().nextDouble()*b;
            System.out.println((int)a);
//            Math.log()
        }
    }
}
