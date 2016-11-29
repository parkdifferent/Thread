package com.ibm1;

import java.util.Date;

/**
 * Created by tianf on 2016/8/8.
 */
public class TimePrinter implements Runnable {

    int pauseTime;
    String name;
    public TimePrinter(int x, String n) {
        pauseTime = x;
        name = n;
    }

    @Override
    public void run() {

        while(true) {
            try {
                System.out.println(name + ":" + new
                        Date(System.currentTimeMillis()));
                Thread.sleep(pauseTime);
            } catch(Exception e) {
                System.out.println(e);
            }
        }

    }

    static public void main(String args[]) {
        Thread t1 = new Thread (new TimePrinter(1000, "Fast Guy"));
        t1.start();
        Thread t2 = new Thread (new TimePrinter(3000, "Slow Guy"));
        t2.start();

    }
}
