package deadLockTest;

/**
 * Created by tianf on 2016/11/29.
 */
public class Thread1 extends Thread {

    private DeadLock dl;

    public Thread1(DeadLock dl)
    {
        this.dl = dl;
    }

    @Override
    public void run() {
        try
        {
            dl.rightLeft();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
