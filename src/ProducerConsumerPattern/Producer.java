package ProducerConsumerPattern;

import java.util.concurrent.BlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by tianf on 2016/11/29.
 */
public class Producer implements Runnable {

    private final BlockingQueue sharedQueue;

    public Producer(BlockingQueue sharedQueue) {
        this.sharedQueue = sharedQueue;
    }


    //Read more: http://javarevisited.blogspot.com/2012/02/producer-consumer-design-pattern-with.html#ixzz4RO8jNoqp

    @Override
    public void run() {

        for(int i=0; i<10; i++){
            try {
                System.out.println("Produced: " + i);
                sharedQueue.put(i);
            } catch (InterruptedException ex) {
                Logger.getLogger(Producer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }


       // Read more: http://javarevisited.blogspot.com/2012/02/producer-consumer-design-pattern-with.html#ixzz4RO8vho00

    }
}
