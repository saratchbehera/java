package com.sarat.multithreading;

public class RunMethodTest extends Thread{

    @Override
    public void run(){
        System.out.println("in run method :: "+Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new RunMethodTest());
        //thread.start();
        thread.run();
    }

}
