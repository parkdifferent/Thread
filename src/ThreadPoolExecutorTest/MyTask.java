package ThreadPoolExecutorTest;

import java.util.concurrent.Callable;

/**
 * Created by tianf on 2016/11/1.
 */
public class MyTask implements Callable<Integer> {

    private int upperBounds;

    public MyTask(int upperBounds) {
        this.upperBounds = upperBounds;
    }

    @Override
    public Integer call() throws Exception {
        int sum = 0;
        for(int i = 1; i <= upperBounds; i++) {
            sum += i;
        }
        return sum;
    }
}
