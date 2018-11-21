package sort;

public class IndexMaxPQ<T extends Comparable<T>> {
    private int N = 0; //队列大小
    private int index= 0; //队列中元素个数
    private T[] a; //存放元素
    private int[] pq; //存放索引
    private int[] qp;//存放索引在pq中的下标，索引不存在的话为-1；

    public IndexMaxPQ(int size){
        N = size;
        for(int i = 0; i < N;i++){
            pq[i] = -1;
        }//pq全部初始化为-1
        a = (T[])new Comparable[N+1];
        pq = new int[N+1];
        qp = new int[N+1];
    }

    public void insert(int k,T item){
        if(contains(k)) throw new IllegalArgumentException("索引已经在优先队列中了");
        a[k] = item;
    }
    public boolean contains(int k){
        return qp[k] != -1;
    }
}
