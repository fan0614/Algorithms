package string.stringsort;

/**
 * 在将字符串数组a[]排序时，根据它们的首字母进行三向切分，
 * 然后（递归地）将得到的三个子数组排序：
 * 一个含有所有首字母小于切分字符的字符串子数组，
 * 一个含有所有首字母等于切分字符的字符串的子数组（排序时忽略它们的首字母），
 * 一个含有所有首字母大于切分字符的字符串的子数组
 */
public class Quick3string {
    private static int charAt(String s, int d){
        if(d < s.length()) return s.charAt(d);
        else return -1;
    }
    public static void sort(String[] a){
        sort(a,0,a.length - 1,0);
    }
    private static void sort(String[] a,int lo,int hi,int d){
        if(hi<=lo) return;
        int lt = lo,gt = hi;
        int v = charAt(a[lo],d);
        int i = lo + 1;
        while(i <= gt){
            int t = charAt(a[i],d);
            if(t < v) exch(a,lt++,i++);
            else if(t > v) exch(a,i,gt--);
            else i++;
        }
        sort(a,lo,lt-1,d);
        if(v >= 0) sort(a,lt,gt,d+1);
        sort(a,gt+1,hi,d);
    }
//    private static boolean less(Comparable v, Comparable w){
//        return v.compareTo(w) < 0;
//    }
    private static void exch(Comparable[] a,int i,int j){
        Comparable t = a[i]; a[i] = a[j]; a[j] = t;
    }
}
