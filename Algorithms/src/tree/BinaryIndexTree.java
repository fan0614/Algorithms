package tree;

public class BinaryIndexTree {
    private int[] c;
    int n;
    public BinaryIndexTree(int n){
        this.n = n;
        c = new int[n+1];
    }
    public static int lowbit(int x){
        return x&(x^(x-1));  //等价于 x & (-x) 等价于 x &（~x+1）
    }
    /**
     * 更新一个元素，初始数组c都是0，所以可以用这个方法初始化c，这时增加与更新是等价的
     * @param p  更新第p个元素，索引从1开始
     * @param d  增加的值，不是更新后的值
     */
    public void update(int p,int d){
        while(p<=n){
            c[p] += d;
            p += lowbit(p);
        }
    }

    /**
     * 计算第一个元素到第p个元素的和
     * @param p
     * @return
     */
    public int sum(int p){
        int ret = 0;
        while(p > 0){
            ret += c[p];
            p -= lowbit(p);
        }
        return ret;
    }

    /**
     * 计算从第i个元素到第e个元素的和
     * @param s
     * @param e
     * @return
     */
    public int sum(int s,int e){
        if(s > n || e < 1 || s > e || s < 1 || e > n){
            return -1;
        }
        return sum(e) - sum(s-1);
    }

}
