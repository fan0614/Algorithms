package graph;
/*
G是二分图吗？（双色问题）
思路：深度优先搜索，不能出现一条边两端点颜色相同
 */
public class TwoColor {
    private boolean[] marked;
    private boolean[] color;
    private boolean isTwoColorable = true;
    public TwoColor(Graph G){
        marked = new boolean[G.V()];
        color = new boolean[G.V()];
        for(int s = 0; s < G.V();s++){
            if(!marked[s]){
                dfs(G,s);
            }
        }
    }
    public void dfs(Graph G,int v){
        marked[v] = true;
        for(int w : G.adj(v)){
            if(!marked[w]){
                color[w] = !color[v];
                dfs(G,w);
            }
            else if(color[w] == color[v]) isTwoColorable = false;
        }
    }
    public boolean isBipartite(){return isTwoColorable;}
}
