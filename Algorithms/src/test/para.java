package test;

public class para {
    static int count;
    public static void main(String[] args) {
            dfs(0,1);
    }
    public static void dfs(int i,int n){
        if(i == n){
            count++;
            System.out.println(count);
        }
        for(int j = i;j<=n;j++){
            System.out.println("I");
            dfs(i+1,n);
            System.out.println("R");
        }
    }
}
