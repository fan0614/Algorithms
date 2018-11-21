package sort;

public class Multiway {
    public static void merge(){
        IndexMinPQ<String> pq = new IndexMinPQ<String>(10);
        for(int i = 0;i<10;i++){
            pq.insert(i,"");
        }
        while(!pq.isEmpty()){
            int i = pq.delMin();

        }
    }
}
