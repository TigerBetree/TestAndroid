package com.tiger.test.okhttp;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by tiger on 2018/3/19.
 */

public class MyOkHttpClient {
    private static volatile MyOkHttpClient sInstance = null;

    private OkHttpClient mOkHttpClient = null;

    private MyOkHttpClient() {
        mOkHttpClient = new OkHttpClient();
    }

    public static MyOkHttpClient getInstance() {
        if (sInstance == null) {
            synchronized (MyOkHttpClient.class) {
                if (sInstance == null) {
                    sInstance = new MyOkHttpClient();
                }
            }
        }

        return sInstance;
    }

    public OkHttpClient getClient() {
        return mOkHttpClient;
    }

    public Response exec(Request request) throws IOException {
        return mOkHttpClient.newCall(request).execute();
    }
}
