package com.matigou.core;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockTests {

    protected volatile static Long num = 0l;

    private static final AtomicInteger at=new AtomicInteger();

    private static final Lock lock = new ReentrantLock();

    public void testReentrantLock() throws Exception{
        for(int i = 0; i < 1000; i++){
            Thread thread = new Thread(() -> {
                lock.lock();

                /*try {
                    Thread.sleep(600000);
                } catch (InterruptedException e) {
                }*/
                num = num + 1;
                lock.unlock();
            });
            thread.setName("wx-" + i);
            thread.start();
        }
        System.out.println(num);
    }
}
