package concurrent;

public class NoVisibility {
    private static boolean ready;
    private static int number;
    private static class ReaderThread extends Thread{
        @Override
        public void run() {
            while(!ready) {
                   Thread.yield();
            /*    try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }*/
            }
            System.out.println(number);
        }
    }
    public static void main(String[] args){
            new ReaderThread().start();
            for(int i = 0 ; i< Integer.MAX_VALUE;i++){
                for(int j = 0 ; j< Integer.MAX_VALUE;j++){

                }
            }
            number = 42;
            ready = true;
    }
}
