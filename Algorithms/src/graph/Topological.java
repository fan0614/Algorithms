package graph;

import spt.EdgeWeightedDigraph;

import java.util.ArrayList;

//拓扑排序的API
public class Topological {
    private Iterable<Integer> order;   //顶点的拓扑顺序

    //拓扑排序的构造函数
    public Topological(Digraph G){
        DirectedCycle cyclefinder = new DirectedCycle(G);
        if(!cyclefinder.hasCycle()){
            DepthFirstOrder dfs = new DepthFirstOrder(G);
            order = dfs.reversePost();
        }

    }
    public Topological(EdgeWeightedDigraph G){
//        DirectedCycle cyclefinder = new DirectedCycle(G);
//        if(!cyclefinder.hasCycle()){
            DepthFirstOrder dfs = new DepthFirstOrder(G);
            order = dfs.reversePost();
//        }

    }
    //G是有向无环图吗
    public boolean isDAG(){
        return order != null;
    }
    //拓扑排序的所有顶点
    public Iterable<Integer> order(){
        return order;
    }

    public static void main(String[] args) {
        String filename = args[0];
        String separator = args[1];
        SymbolGraph sg = new SymbolGraph(filename, separator);

        Topological top = new Topological(sg.DG());
        for(int v : top.order())
            System.out.println(sg.name(v));
    }
}
