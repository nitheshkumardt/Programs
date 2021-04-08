package com.Assignment2.ThreadPool;

import java.util.concurrent.*;

public class RejectionEg {
    public static void rejectionHandle(){
        System.out.println("\nHandle the Rejection:::");
        int csize=1;
        int msize=3;
        int kalive=10;
        int qsize=2;
        ArrayBlockingQueue<Runnable> queue = new ArrayBlockingQueue<Runnable>(qsize);
        RejectionHandler rejectionHandler=new RejectionHandler();
        ThreadFactory threadFactory= Executors.defaultThreadFactory();
        ThreadPoolExecutor executorService=new ThreadPoolExecutor(csize,msize,kalive,
                TimeUnit.SECONDS,queue,threadFactory,rejectionHandler);
        for(int i=0;i<10;i++){
            Runnable r=new ThreadPool(i);
            executorService.execute(r);
        }
        executorService.shutdown();
        while (!executorService.isTerminated()){}
    }
    public static void main(String[] args) {
        rejectionHandle();
    }
}
