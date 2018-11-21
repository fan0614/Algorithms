package classical;

import java.util.List;

public class EightQueen {
    static int[][] vis = new int[3][16];
    static int tot=0;
    static int[] c = new int[8];
    public static void main(String[] args) {
        search(0);
        for(int i = 0;i<8;i++){
            System.out.println(c[i]);
        }
    }
    public static void search(int cur){
//        int i;
        List list;
//        list.forEach();
        if(cur == 8)
            tot++;
        else
            for(int i = 0;i<8;i++){
                if(vis[0][i]!=0 && vis[1][cur+i]!=0 && vis[2][cur-i+8]!=0){
                    c[cur]=i;
                    vis[0][i]=vis[1][cur+i]=vis[2][cur-i+8]=1;
                    search(cur+1);
                    vis[0][i]=vis[1][cur+i]=vis[2][cur-i+8]=0;
                }
            }
    }
}
