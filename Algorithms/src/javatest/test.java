package javatest;

import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int [] a = new int[n];
        int [] t = new int[n];
        int sum=0;
        for(int i = 0;i<n;i++){
            a[i] = in.nextInt();
        }
        for(int i = 0;i<n;i++){
            t[i] = in.nextInt();
        }
        for(int i = 0;i<n+1-k;i++){
            if(t[i]==0){
                int su = 0;
                int[] temp = t;
                for(int j = i;j<i+k;j++)
                    temp[j] =1;
                for(int o = 0;o<n;o++){
                    if(temp[o]==1)
                        su+=a[o];
                }
                if(su>sum){
                    sum = su;
                }

                System.out.println(i);
            }else{
                //continue;
            }
        }
        System.out.println(sum);
    }
}
