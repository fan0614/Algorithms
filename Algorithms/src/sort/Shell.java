package sort;

public class Shell {
    public static void sort(Comparable[] a){
        //将a升序排列
        int N = a.length;
        int h = 1;
        while(h < N/3) h = 3*h + 1;
        while(h >= 1){
            //将数组变为h有序
            for(int i = h; i < N;i++){
                for(int j = i;j>=h && less(a[j],a[j-h]);j-=h)
                    exch(a,j,j-h);
            }
            h = h/3;
        }
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
