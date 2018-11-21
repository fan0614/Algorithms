package graph;
//顶点可达性的API   传递闭包
public class TransitiveClosure {
    private DirectedDFS[] all;
    //预处理的构造函数
    public TransitiveClosure(Digraph G){
        all = new DirectedDFS[G.V()];
        for(int v = 0;v<G.V();v++){
            all[v] = new DirectedDFS(G,v);
        }
    }
    //w是从v可达的吗
    public boolean reachable(int v,int w){
        return all[v].marked(w);
    }
}
