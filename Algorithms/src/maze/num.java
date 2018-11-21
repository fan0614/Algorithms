package maze;

import java.util.Random;

public class num {
//    static int[] a =new int[4];
//    public static void main(String[] args) {
//            numDFS(1);
//    }
//    public static void numDFS(int k){
//        if(k > 3){
//            System.out.println(a[1]+"  "+a[2]+"  "+a[3]);
//        }
//        for(int i = 1;i<=4;i++){
//            if(i>a[k-1]){
//                a[k]=i;
//                numDFS(k+1);
//            }
//        }
//    }
    public static void main(String[] args) {
        Random rand = new Random();
        Random rand2 = new Random();

        int a= rand.nextInt();
        int b = rand2.nextInt();
        System.out.println(a);
        System.out.println(b);
//        int[] nums = {1,2,3};
//        int[] n = new int[3];
//        n = nums;
//        nums[1] = 10;
//        for(int i = 0;i<3;i++){
//            System.out.println(n[i]);
//        }
    }
}
