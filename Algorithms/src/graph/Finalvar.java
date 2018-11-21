package graph;

public class Finalvar {
    final int V;
    int T;
    public Finalvar(){
        V  = 10;
    }
    public void printV(int T){
        this.T = 20;
        System.out.println(T);
    }
    public static void main(String[] args){
        new Finalvar().printV(10);
    }
}
