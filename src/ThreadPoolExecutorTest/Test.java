package ThreadPoolExecutorTest;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by tianf on 2016/11/1.
 */
public class Test {

    public static void main(String[] args) throws Exception {
        List<Future<Integer>> list = new ArrayList<Future<Integer>>();
        ExecutorService service = Executors.newFixedThreadPool(10);
        for(int i = 0; i < 10; i++) {
            list.add(service.submit(new MyTask((int) (Math.random() * 10))));
        }

        int sum = 0;
        for(Future<Integer> future : list) {
            // while(!future.isDone()) ;

            System.out.println(future.get());
            //sum += future.get();
        }

        //System.out.println(sum);
    }
}
