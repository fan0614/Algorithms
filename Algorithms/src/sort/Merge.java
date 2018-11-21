package sort;

public class Merge {
    //自定向下的归并排序
    public static Comparable[] aux;
    public static void sort(Comparable[] a){
        aux = new Comparable[a.length];  //一次性分配空间
        sort(a,0,a.length-1);
    }
    //自顶向下的归并排序
    private static void sort(Comparable[] a,int lo,int hi){
        if(hi<=lo) return;
        int mid = lo + (hi-lo)/2;
        sort(a,lo,mid);   //将左半边排序
        sort(a,mid+1,hi);  //将右半边排序
        merge(a,lo,mid,hi);  //归并结果
    }
    //自底向上的归并排序
    public static void sort2(Comparable[] a){
        int N = a.length;
        aux = new Comparable[N];
        for(int sz = 1; sz < N; sz = sz +sz)   //sz子数组大小
            for(int lo = 0;lo < N - sz;lo += sz+sz)  //lo：子数组索引
                merge(a,lo,lo+sz-1,Math.min(lo+sz+sz-1,N-1));
    }

    //原地归并的抽象算法
    public static void merge(Comparable[] a,int lo,int mid,int hi){
        //将a[lo...mid]和a[mid + 1...hi]归并
        int i = lo, j = mid + 1;
        for(int k = lo;k <= hi;k++)  //将a[lo..hi]赋值到aux[lo..hi]
            aux[k] = a[k];
        for(int k = lo;k <= hi;k++) //归并回到a[lo..hi]
            if( i > mid) a[k] = aux[j++];
            else if(j > hi) a[k] = aux[i++];
            else if(less(a[i],a[j])) a[k] = aux[i++];
            else a[k] = aux[j++];
    }
    private static boolean less(Comparable v, Comparable w){
        return v.compareTo(w) < 0;
    }
    private static void exch(Comparable[] a,int i,int j){
        Comparable t = a[i]; a[i] = a[j]; a[j] = t;
    }
    private static void show(Comparable[] a){
        //在单行中打印数组
        for(int i = 0;i < a.length;i++){
            System.out.println(a[i]);
        }
        System.out.println();
    }
    public static boolean isSorted(Comparable[] a){
        //测试数组中的元素是否有序
        for(int i = 1;i < a.length; i++)
            if(less(a[i],a[i-1])) return false;
        return true;
    }
}
