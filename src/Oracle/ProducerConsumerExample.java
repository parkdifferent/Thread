package Oracle;

/**
 * Created by tianf on 2016/8/22.
 */
public class ProducerConsumerExample {

    public static void main(String[] args) {
        Drop drop = new Drop();
        (new Thread(new Producer(drop))).start();
        (new Thread(new Consumer(drop))).start();
    }
}
