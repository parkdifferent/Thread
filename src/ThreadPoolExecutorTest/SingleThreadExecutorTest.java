package ThreadPoolExecutorTest;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by tianf on 2016/10/12.
 */


/*

4、newSingleThreadExecutor：创建一个单线程化的线程池，它只会用唯一的工作线程来执行任务，
保证所有任务按照指定顺序(FIFO, LIFO, 优先级)执行。示例代码如下：

结果依次输出，相当于顺序执行各个任务。
 */
public class SingleThreadExecutorTest {

    public static void main(String[] args) {
        ExecutorService singleThreadExecutor= Executors.newSingleThreadExecutor();

        for(int i = 0; i < 10; i++) {
            final int index = i;

            singleThreadExecutor.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        System.out.println(index);
                        Thread.sleep(2000);

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }
}

/*
Thread thread1 = new Thread(new MyThread());
thread1.setName("thread001");
thread1.start();
设置线程名称，
MyThread 的 run 方法中可以取到线程名称
Thread.currentThread().getName()

作者：2323
链接：http://zhuanlan.zhihu.com/p/22882522
来源：知乎
著作权归作者所有，转载请联系作者获得授权。
 */
