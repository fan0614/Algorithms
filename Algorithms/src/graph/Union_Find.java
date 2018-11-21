package graph;

public class Union_Find {
//    public static void main(String[] args) {
//        int  n = 0x80000000<<1;
//        int  x = -2&3;
//        System.out.println(n);
//        System.out.println(x);
//        Math.pow(3,4);
//    }
    private int[] id;    //分量id(以触电作为索引)
    private int count;       //分量数量
    //以整数标识（0到N-1） 初始化N个触点
    public Union_Find(int N){
        count = N;
        id = new int[N];
        for(int i = 0;i < N;i++){
            id[i] = i;
        }
    }
    //连通分量的数量
    public int count(){
        return count;
    }
    //******************************************************************************************************************
    //p所在的分量标识符  quick-find算法
    public int find(int p){
        return id[p];
    }
    //在p，q之间添加一条连接
    public void union(int p, int q){
        //将p和q归并到相同的分量中
        int pID = find(p);
        int qID = find(q);
        //如果p和q 已经在相同的分量之中，则不需要采取任何行动
        if(pID == qID) return;
        //将p分量重命名为q的名称
        for(int i = 0;i < id.length;i++){
            if(id[i] == pID) id[i] = qID;
        }
        count--;
    }
    //******************************************************************************************************************
    //quick-union算法
    public int find2(int p){
        while(p != id[p]) p = id[p];
        return p;
    }
    public void union2(int p, int q){
        int pRoot = find2(p);
        int qRoot = find2(q);
        if(pRoot == qRoot) return;

        id[pRoot] = qRoot;

        count--;
    }

    //如果p和q在同一个连通分量里则返回true
    public boolean connected(int p, int q){
        return find(p) == find(q);
    }

}


