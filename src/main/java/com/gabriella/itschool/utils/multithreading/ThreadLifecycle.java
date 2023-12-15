package com.gabriella.itschool.utils.multithreading;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ThreadLifecycle extends Thread {

    @Override
    public void run() {
        try {
            log.info("The thread is running and going to sleep for 2 seconds.");
            Thread.sleep(2000);
            log.info("Thread is not sleeping anymore.");
        } catch (InterruptedException e) {
            log.error(e.getMessage());
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadLifecycle threadLifecycle = new ThreadLifecycle();
        log.info("Thread state after creation: " + threadLifecycle.getState());

        threadLifecycle.start();
        log.info("Thread state after was started: " + threadLifecycle.getState());

        Thread.sleep(2000);
        log.info("Thread state while is on sleep: " + threadLifecycle.getState());
    }
}
