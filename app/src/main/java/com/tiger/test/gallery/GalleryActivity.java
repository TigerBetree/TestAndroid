package com.tiger.test.gallery;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.tiger.test.R;

public class GalleryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);
    }

    public void gallery(View v) {
        startActivity(new Intent(this, GalleryAct.class));
    }

    public void viewPager(View v) {
        startActivity(new Intent(this, ViewPagerAct.class));
    }

}
