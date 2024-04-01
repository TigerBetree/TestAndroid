package com.tiger.test.dragview;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.tiger.test.R;

public class DragViewActivity extends Activity {

    private DraggableViewGroup draggableViewGroup = null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_dragview);

        draggableViewGroup = findViewById(R.id.draggable_view_group);

//        Button bt = new Button(this);
//        bt.setText("Drag me!");
//        bt.setTextColor(R.color.color_brand);
//        bt.setBackgroundResource(R.color.cardview_dark_background);
//        bt.setLayoutParams(new LinearLayout.LayoutParams(
//                LinearLayout.LayoutParams.WRAP_CONTENT,
//                LinearLayout.LayoutParams.WRAP_CONTENT
//        ));

        TextView textView = findViewById(R.id.draggable_view);
        draggableViewGroup.setDraggableView(textView);
    }
}
