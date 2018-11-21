package graph;

import java.util.ArrayList;
import java.util.List;

public class DigraphDFS_Test {
    public static void main(String[] args) {
        Digraph G = new Digraph(10);
        List<Integer> sources = new ArrayList<>();
        for(int i = 1;i<10;i++){
            sources.add(i);
        }
        DirectedDFS reachable = new DirectedDFS(G,sources);

        for(int v = 0;v<G.V();v++){
            if(reachable.marked(v)) System.out.println("可达");
        }
    }
}
