package com.Assignment2.ThreadPool;

import java.util.concurrent.ThreadPoolExecutor;

import static java.lang.Thread.sleep;
import java.util.concurrent.ThreadPoolExecutor;
public class ThreadPool implements Runnable{
    public  int n;
    public static ThreadPoolExecutor te;
    public ThreadPool(int n) {
        this.n = n;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+" Value-->"+n);
        try {
            sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //System.out.println(te.getActiveCount());
        System.out.println(Thread.currentThread().getName()+"\n<----Stopped--->");
    }

    @Override
    public String toString() {
        return  n+" ";
    }
}
