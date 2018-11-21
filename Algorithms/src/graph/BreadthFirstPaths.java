package graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BreadthFirstPaths {
    private boolean[] marked; //到达该顶点的最短路径已知吗？
    private int[] edgeTo;  //到达该顶点的已知路径上的最后一个顶点
    private int s;   //起点

    public BreadthFirstPaths(Graph G, int s) {
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        this.s = s;
        bfs(G,s);
    }
    public void bfs(Graph G, int s){
        Queue<Integer> queue = new LinkedList<>();
        marked[s] = true;   //标记起点
        queue.add(s);   // 将它加入队列
        while(!queue.isEmpty()){
            int v = queue.poll();  //从队列中删去一个顶点
            for(int w : G.adj(v))    //对于每个未被标记的相邻顶点
                if(!marked[w]){
                    edgeTo[w] = v;    //保存最短路径的最后一条边
                    marked[w] = true;  //标记它，因为最短路径已知
                    queue.add(w);    //加入队列
                }
        }
    }
    public boolean hasPathTo(int v){
        return marked[v];
    }
    public Iterable<Integer> pathTo(int v){
        if(!hasPathTo(v)) return null;
        Stack<Integer> path = new Stack<Integer>();
        for(int x = v; x != s; x = edgeTo[x])
            path.push(x);
        path.push(s);
        return path;
    }
}
