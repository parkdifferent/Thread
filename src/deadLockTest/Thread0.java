package deadLockTest;

/**
 * Created by tianf on 2016/11/29.
 */
public class Thread0 extends Thread {

    private DeadLock dl;

    public Thread0(DeadLock dl)
    {
        this.dl = dl;
    }

    @Override
    public void run() {
        try
        {
            dl.leftRight();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
