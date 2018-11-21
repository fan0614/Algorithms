package concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ThreadDeadlock {
//    ExecutorService exec = Executors.newSingleThreadExecutor();
//
//    public class RenderPageTask implements Callable<String> {
//        @Override
//        public String call() throws Exception {
//            Future<String> header,footer;
//            header = exec.submit(new LoadFileTask(""));
//            return null;
//        }
//    }
    public static void main(String [] args){
        System.out.println(Runtime.getRuntime().availableProcessors());
    }
}
