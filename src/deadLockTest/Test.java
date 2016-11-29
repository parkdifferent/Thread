package deadLockTest;

/**
 * Created by tianf on 2016/11/29.
 */
public class Test {

    //jps  jstack pid

    public static void main(String[] args) {
        DeadLock deadLock = new DeadLock();
        Thread0 thread0 = new Thread0(deadLock);
        Thread1 thread1 = new Thread1(deadLock);
        thread0.start();
        thread1.start();
    }
}
