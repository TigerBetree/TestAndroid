package com.tiger.test.okhttp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;

import com.tiger.test.R;
import com.tiger.test.databinding.ActivityOkhttpTestBinding;
import com.tiger.test.utils.LogUtil;
import com.tiger.test.utils.MyExecutor;

import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by tiger on 2018/3/19.
 */

public class TestOkHttpActivity extends Activity implements View.OnClickListener {

    public static void startActivity(@Nullable Context context) {
        Intent intent = new Intent(context, TestOkHttpActivity.class);
        context.startActivity(intent);
    }

    private ActivityOkhttpTestBinding mBinding = null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_okhttp_test);

        initView();
    }

    private void initView() {
        mBinding.btGet.setOnClickListener(this);
        mBinding.btPost.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_get:
                MyExecutor.getExecutor().post(new Runnable() {
                    @Override
                    public void run() {
                        doTestGet();
                    }
                });
                break;
            case R.id.bt_post:
                MyExecutor.getExecutor().post(new Runnable() {
                    @Override
                    public void run() {
                        doTestPost();
                    }
                });
                break;
        }
    }

    private void doTestGet() {
        Request request = new Request.Builder()
                .url("https://publicobject.com/helloworld.txt").build();

        try {
            Response response = MyOkHttpClient.getInstance().exec(request);

            if (response.isSuccessful()) {
                LogUtil.logd("content : " + response.body().string());
            } else {
                LogUtil.logd("failed.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void doTestPost() {

    }
}
