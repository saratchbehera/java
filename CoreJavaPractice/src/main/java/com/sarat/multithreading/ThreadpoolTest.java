package com.sarat.multithreading;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadpoolTest{

    public static void main(String[] args) {
        int coreCount = Runtime.getRuntime().availableProcessors();
        System.out.println("Processor Count :: "+coreCount);

        ExecutorService executorService = Executors.newFixedThreadPool(coreCount);

        for(int i=0; i<=10; i++){
        executorService.execute(new CPUIntensiveTask());
        }
        System.out.println("ThreadpoolTest :: Thread Name :: "+Thread.currentThread().getName());

    }
}

class CPUIntensiveTask implements Runnable{

    @Override
    public void run() {
        System.out.println("CPUIntensive :: Thread Name :: "+Thread.currentThread().getName());
    }
}
