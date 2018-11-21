public class InheritTest {
    public static void main(String [] args){
        long s1 = System.currentTimeMillis();
        long s2 = System.nanoTime();
        for(int i=0; i<10000 ; i++){
            for(int j=0; j<10000;j++){
                int a = 3;
            }
        }
        System.out.println(System.currentTimeMillis()-s1);
        System.out.println(System.nanoTime()-s2);
    }
}
