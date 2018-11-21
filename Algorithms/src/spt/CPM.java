package spt;

import java.util.Scanner;

//优先级限制下的并行任务调度问题的关键路径方法。
public class CPM {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        EdgeWeightedDigraph G;
        G = new EdgeWeightedDigraph(2*N+2);
        int s = 2 * N,t = 2*N + 1;
        for(int i = 0;i < N;i++){
            String[] a = scanner.nextLine().split("\\s+");
            double duration = Double.parseDouble(a[0]);
            G.addEdge(new DirectedEdge(i,i+N,duration));
            G.addEdge(new DirectedEdge(s,i,0.0));

            G.addEdge(new DirectedEdge(i+N,t,0.0));

            for(int j = 1;j<a.length;j++){
                int successor = Integer.parseInt(a[j]);
                G.addEdge(new DirectedEdge(i+N,successor,0.0));
            }
        }
        AcyclicLP lp = new AcyclicLP(G,s);
        for(int i = 0; i < N;i++){
            System.out.println(lp.distTo(i));
        }
        System.out.println(lp.distTo(t));
//        for()
    }
}
