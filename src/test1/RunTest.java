package test1;

/**
 * Created by tianf on 2016/8/18.
 */
public class RunTest {

    public static void main(String[] args) throws InterruptedException {
        MyThread1 myThread=new MyThread1();
        System.out.println("begin =="+myThread.isAlive());
        myThread.start();
        //Thread.sleep(1000);
        System.out.println("end =="+myThread.isAlive());
    }
}

 class MyThread1  extends Thread{
    @Override
    public void run() {
        System.out.println("run="+this.isAlive());
    }
}