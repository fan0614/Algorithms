package graph;

public class DegreesOfSeparation {
    public static void main(String[] args) {
        SymbolGraph sg = new SymbolGraph(args[0],args[1]);
        Graph G = sg.G();

        String source = args[2];

        if(!sg.contains(source)){
            return ;
        }
        int s = sg.index(source);
        BreadthFirstPaths bfs = new BreadthFirstPaths(G,s);

        String sink = "";
        if(sg.contains(sink)){

        }
    }
}
