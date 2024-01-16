package com.tiger.test.gallery;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.tiger.test.R;

public class GalleryAct extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery_act);

        GalleryView gallery = (GalleryView) findViewById(R.id.gallery);

//        assert gallery != null;
        gallery.setAdapter(new GalleryAdapter());
    }
}
