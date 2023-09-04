package com.tiger.test

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.fragment.app.FragmentActivity
import com.tiger.test.recyclersample.FlowersListActivity
import com.tiger.test.roomwordssample.WordMainActivity
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

        DeviceUtil.getDeviceIds(this);
    }
}