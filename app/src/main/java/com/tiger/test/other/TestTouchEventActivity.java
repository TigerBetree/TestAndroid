package com.tiger.test.other;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;

import com.jakewharton.processphoenix.ProcessPhoenix;
import com.tiger.test.R;

public class TestTouchEventActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_touch_event);

        findViewById(R.id.btn_phoenix).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ProcessPhoenix.triggerRebirth(TestTouchEventActivity.this);
            }
        });

        RelativeLayout group = findViewById(R.id.rl_group);
        group.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Log.d("Tiger", "group on touch. " + event.getAction());
                return true;
            }
        });


        TextView view = findViewById(R.id.tv);
//        view.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Log.d("Tiger", "view is clicked.");
//            }
//        });


        reqLoc(this);

        boolean judgePermission = judgePermission(this, Manifest.permission.ACCESS_FINE_LOCATION);
        Log.d("Tiger", "judgePermission : " + judgePermission);
    }


    public static void reqLoc(Activity context) {
        ActivityCompat.requestPermissions(context,
                new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                1000);
    }

    public static boolean judgePermission(Context context, String permission) {
        if (ActivityCompat.shouldShowRequestPermissionRationale((Activity) context, permission))
            return true;
        else
            return false;
    }
}
