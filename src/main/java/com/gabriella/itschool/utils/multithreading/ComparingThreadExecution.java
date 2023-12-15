package com.gabriella.itschool.utils.multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

public class ComparingThreadExecution {

    public static void main(String[] args) throws InterruptedException {
        int number = 100_000_000;
        int[] arr = new int[number];
        for (int index = 0; index < number; index++) {
            arr[index] = index;
        }

        // single thread
        AtomicLong singleThreadResult = new AtomicLong();
        long start = System.currentTimeMillis();
        new ThreadPractice(arr, 0, number, singleThreadResult).run();
        long end = System.currentTimeMillis();

        System.out.println("Single thread sum: " + singleThreadResult);
        System.out.println("Single thread time: " + (end - start));

        // multi thread
        int threadCount = Runtime.getRuntime().availableProcessors();
        System.out.println("Thread count: " + threadCount);
        int partSize = number / threadCount;

        ExecutorService executorService = Executors.newFixedThreadPool(threadCount);
        AtomicLong multiThreadResult = new AtomicLong();

        long startMulti = System.currentTimeMillis();
        for (int i = 0; i < threadCount; i++) {
            int threadLeft = i * partSize;
            int threadRight = (i == threadCount - 1) ? number : threadLeft + partSize;

            executorService.execute(new ThreadPractice(arr, threadLeft, threadRight, multiThreadResult));
        }

        executorService.shutdown();
        executorService.awaitTermination(10, TimeUnit.SECONDS);

        long endMulti = System.currentTimeMillis();
        System.out.println(startMulti + " " + endMulti);

        System.out.println("Multi thread sum: " + multiThreadResult);
        System.out.println("Multi thread time: " + (endMulti - startMulti));
    }
}

class ThreadPractice implements Runnable {

    private final int[] arr;
    private final int start;
    private final int end;
    private final AtomicLong result;

    public ThreadPractice(int[] arr, int start, int end, AtomicLong result) {
        this.arr = arr;
        this.start = start;
        this.end = end;
        this.result = result;
    }

    @Override
    public void run() {
        long sum = 0;
        for (int index = start; index < end; index++) {
            sum += (long) arr[index] * arr[index];
        }
        result.addAndGet(sum);
    }
}









