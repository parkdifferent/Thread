package com.ibm4;

/**
 * Created by tianf on 2016/8/8.
 */
public class BSync {

    int totalThreads;
    int currentThreads;
    public BSync(int x) {
        totalThreads = x;
        currentThreads = 0;
    }
    public synchronized void waitForAll() {
        currentThreads++;
        if(currentThreads < totalThreads) {
            try {
                wait();
            } catch (Exception e) {}
        }
        else {
            currentThreads = 0;
            notifyAll();
        }
    }
}
