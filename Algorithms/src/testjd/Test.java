package testjd;

import java.util.Scanner;


public class Test {
    public static void main(String[] args) {
        Scanner sca = new Scanner(System.in);
//        while(sca.hasNext()){
//            System.out.println(sca.next());
//        }
        int q = sca.nextInt();
        for(int i=0;i<q;i++){
            int k = sca.nextInt();
            int l = sca.nextInt();
            int r = sca.nextInt();
            System.out.println(printEnergy(k,l,r));
        }
    }
    public static int printEnergy(int k,int l,int r){
//            k = k-1;
            int s=l;
            int sum = 0;
            int j=0;
            while(s>=l&&s<=r){
                sum = 0;
                for(int p = j;p >= 0;p--) {
                    sum += (int) ((k-1) * (Math.pow(k, p)));
                }
                s = sum;
                j++;
            }
            int ss = (int) (sum-(k-1) * (Math.pow(k,j-1)));
            return ss;
    }
}
