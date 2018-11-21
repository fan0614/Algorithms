package sort;

public class Insertion {
    public static void sort(Comparable[] a){
        //将a[]按升序排列
        int N = a.length;
        for(int i = 1; i < N; i++){
            //将a[i]插入到a[i-1]、a[i-2]、a[i-3]...之中
            for(int j = i; j > 0 && less(a[j],a[j-1]);j--)
                exch(a,j,j-1);
        }
    }
    //MSD的插入排序
    public static void sort(Comparable[] a,int lo,int hi,int d){
        //将a[]按升序排列
        int N = hi - lo;
        for(int i = lo; i < N; i++){
            //将a[i]插入到a[i-1]、a[i-2]、a[i-3]...之中
            for(int j = i; j > lo && less((String) a[j],(String)a[j-1],d);j--)
                exch(a,j,j-1);
        }
    }
    private static boolean less(Comparable v, Comparable w){
        return v.compareTo(w) < 0;
    }
    //MSD算法的插入排序   对前d个字符均相同的字符串执行插入排序
    private static boolean less(String v, String w, int d){
        return v.substring(d).compareTo(w.substring(d))<0;
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
