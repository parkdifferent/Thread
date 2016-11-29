package test;

/**
 * Created by tianf on 2016/8/18.
 */

/*
public class Test {

    public static void main(String[] args)  {
        MyThread thread = new MyThread();
        thread.start();
    }

}

class MyThread extends Thread{
    private static int num = 0;
    public MyThread(){
        num++;
    }
    @Override
    public void run() {
        System.out.println("主动创建的第"+num+"个线程");
    }
}*/
public class Test {

    public static void main(String[] args)  {
        System.out.println("主线程ID:"+Thread.currentThread().getId());
        MyThread thread1 = new MyThread("thread1");
        thread1.start();
        MyThread thread2 = new MyThread("thread2");
        thread2.run();
    }
    /*
    1）thread1和thread2的线程ID不同，thread2和主线程ID相同，说明通过run方法
    调用并不会创建新的线程，而是在主线程中直接运行run方法，跟普通的方法调用没有任何区别；

2）虽然thread1的start方法调用在thread2的run方法前面调用，但是先输出的是thread2的run
方法调用的相关信息，说明新线程创建的过程不会阻塞主线程的后续执行。
     */

}

class MyThread extends Thread {
    private String name;

    public MyThread(String name){
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println("name:"+name+" 子线程ID:"+Thread.currentThread().getId());
    }
}

