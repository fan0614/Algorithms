package sort;

//关联索引的泛型优先队列的API
public class IndexMinPQ<Item extends Comparable<Item>> {
    private int N;  //PQ中元素的数量
    private int[] pq;  //索引二叉堆，由1开始
    private int[] qp;  //逆序：pq[qp[i]] == qp[pq[i]] == i;
    private Item[] items;  //有优先级之分的元素

    //创建一个最大容量为maxN的优先队列，索引的取值范围为0-maxN-1；
    public IndexMinPQ(int maxN){
        items =(Item[]) new Comparable[maxN +1];
        pq = new int[maxN + 1];
        qp = new int[maxN + 1];
        for(int i = 0;i <= maxN;i++){
            qp[i] = -1;
        }
    }
    //插入一个元素，将它和索引k相关联
    public void insert(int k, Item item){
        N++;
        qp[k] = N;
        pq[N] = k;
        items[k] = item;
        swim(N);
    }
    //将索引为k的元素设为item
    public void change(int k, Item item){
        items[k] = item;
        swim(qp[k]);
        sink(qp[k]);
    }
    //是否存在索引为k的元素
    public boolean contains(int k){
        return qp[k] != -1;
    }
    //删去索引k以及其相关联的元素
    public void delete(int k){
        exch(k,N--);
        swim(qp[k]);
        sink(qp[k]);
        items[pq[N+1]] = null;
        qp[pq[N+1]] = -1;
    }
    //返回最小的元素
    public Item min(Item i){
        return items[pq[1]];
    }
    //返回最小元素的索引
    public int minIndex(){
        return pq[1];
    }
    //删除最小元素并返回它的索引
    public int delMin(){
        int indexOfMin = pq[1];
        exch(1,N--);
        sink(1);
        items[pq[N+1]] = null;
        qp[pq[N+1]] = -1;
        return indexOfMin;
    }
    //优先队列是否为空
    public boolean isEmpty(){
        return N == 0;
    }
    //优先队列中的元素数量
    public int size(){
        return N;
    }
    private boolean less(int i,int j){
        return items[pq[i]].compareTo(items[pq[j]])<0;
    }
    private void exch(int i,int j){
        int t = pq[i];
        pq[i] = pq[j];
        pq[j] = t;
    }
    private void swim(int k){
        while(k>1 && less(k/2,k)){
            exch(k/2,k);
            k = k/2;
        }
    }
    private void sink(int k){
        while(2*k <= N){
            int j = 2*k;
            if(j<N && less(j,j+1))j++;
            if(!less(k,j)) break;
            exch(k,j);
            k = j;
        }
    }
}
