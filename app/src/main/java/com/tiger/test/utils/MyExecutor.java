package com.tiger.test.utils;

import androidx.annotation.NonNull;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 线程池工具类
 * Created by tiger on 2018/3/19.
 */

public class MyExecutor {

    private static volatile MyExecutor myExecutor = null;

    private ExecutorService mExecutorService = null;

    private MyExecutor() {
        mExecutorService = Executors.newCachedThreadPool(new ThreadFactory() {

            private AtomicInteger mCounter = new AtomicInteger(1);

            @Override
            public Thread newThread(@NonNull Runnable r) {
                Thread t = new Thread(r);
                t.setName("MyExecutor Thread #" + mCounter.getAndIncrement());
                return t;
            }
        });
    }

    public static MyExecutor getExecutor() {
        if (myExecutor == null) {
            synchronized (MyExecutor.class) {
                if (myExecutor == null) {
                    myExecutor = new MyExecutor();
                }
            }
        }

        return myExecutor;
    }

    public void post(Runnable runnable) {
        mExecutorService.execute(runnable);
    }
}
