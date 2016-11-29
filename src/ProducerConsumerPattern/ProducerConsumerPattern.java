package ProducerConsumerPattern;


import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by tianf on 2016/11/29.
 */
public class ProducerConsumerPattern {

    public static void main(String args[]){

        //Creating shared object
        BlockingQueue sharedQueue = new LinkedBlockingQueue();

        //Creating Producer and Consumer Thread
        Thread prodThread = new Thread(new Producer(sharedQueue));
        Thread consThread = new Thread(new Consumer(sharedQueue));

        //Starting producer and Consumer thread
        prodThread.start();
        consThread.start();
    }


    //Read more: http://javarevisited.blogspot.com/2012/02/producer-consumer-design-pattern-with.html#ixzz4RO8IuSH3
}
