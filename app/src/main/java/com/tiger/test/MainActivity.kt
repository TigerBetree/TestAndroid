package com.tiger.test

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.fragment.app.FragmentActivity
import com.tiger.test.coordinatorlayout.TestCoordinatorLayoutActivity
import com.tiger.test.coordinatorlayout2.TestCoordinatorLayoutActivity2
import com.tiger.test.coordinatorlayout2.TestCoordinatorLayoutActivity3
import com.tiger.test.dragview.DragViewActivity
import com.tiger.test.frag.TestFragmentActivity
import com.tiger.test.gallery.GalleryActivity
import com.tiger.test.gallery2.RecyclerGalleryActivity
import com.tiger.test.okhttp.TestOkHttpActivity
import com.tiger.test.other.TestTouchEventActivity
import com.tiger.test.recyclersample.FlowersListActivity
import com.tiger.test.roomwordssample.WordMainActivity
import com.tiger.test.stickyheader.TestStickyHeaderLayoutActivity
import com.tiger.test.todolist.TodoListActivity
import com.tiger.test.utils.DeviceUtil

class MainActivity : FragmentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        findViewById<View>(R.id.start).setOnClickListener {
//            startActivity(
//                    FlutterActivity.createDefaultIntent(this@MainActivity)
//            )
//        }

        findViewById<View>(R.id.todolist).setOnClickListener {
            startActivity(Intent(this@MainActivity, TodoListActivity::class.java));
        }

        findViewById<View>(R.id.flowers_list).setOnClickListener {
            startActivity(Intent(this@MainActivity, FlowersListActivity::class.java));
        }

        findViewById<View>(R.id.word_list).setOnClickListener {
            startActivity(Intent(this@MainActivity, WordMainActivity::class.java));
        }

        findViewById<View>(R.id.touch_event).setOnClickListener {
            startActivity(Intent(this@MainActivity, TestTouchEventActivity::class.java));
        }

        findViewById<View>(R.id.fragment_eventbus).setOnClickListener {
            startActivity(Intent(this@MainActivity, TestFragmentActivity::class.java));
        }

        findViewById<View>(R.id.okhttp).setOnClickListener {
            startActivity(Intent(this@MainActivity, TestOkHttpActivity::class.java));
        }

        findViewById<View>(R.id.coordinator_layout).setOnClickListener {
            startActivity(Intent(this@MainActivity, TestCoordinatorLayoutActivity::class.java));
        }

        findViewById<View>(R.id.coordinator_layout2).setOnClickListener {
            startActivity(Intent(this@MainActivity, TestCoordinatorLayoutActivity2::class.java));
        }

        findViewById<View>(R.id.sticky_header).setOnClickListener {
            startActivity(Intent(this@MainActivity, TestStickyHeaderLayoutActivity::class.java));
        }
        findViewById<View>(R.id.gallery).setOnClickListener {
            startActivity(Intent(this@MainActivity, RecyclerGalleryActivity::class.java));
        }
        findViewById<View>(R.id.dragview).setOnClickListener {
            startActivity(Intent(this@MainActivity, DragViewActivity::class.java));
        }

        DeviceUtil.getDeviceIds(this);
    }
}