package com.tiger.test.frag;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.IntDef;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.tiger.test.R;
import com.tiger.test.databinding.ActivityTestFragmentBinding;
import com.tiger.test.frag.event.SwitchTabEvent;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class TestFragmentActivity extends FragmentActivity {

    public static final int TAB_FRAG_1 = 1;
    public static final int TAB_FRAG_2 = 2;
    public static final int TAB_FRAG_3 = 3;

    @IntDef({TAB_FRAG_1, TAB_FRAG_2, TAB_FRAG_3})
    @Retention(RetentionPolicy.SOURCE)
    public @interface ReqType {
    }

    private int cutTab = -1;

    private Fragment1 fragment1 = null;
    private Fragment2 fragment2 = null;
    private Fragment3 fragment3 = null;

    private ActivityTestFragmentBinding activityMainBinding = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_test_fragment);

        initTabs();

        tabSwitch(TAB_FRAG_1);
    }

    @Override
    public View onCreateView(String name, Context context, AttributeSet attrs) {
        return super.onCreateView(name, context, attrs);
    }

    @Override
    protected void onStart() {
        super.onStart();

        EventBus.getDefault().register(this);
    }

    @Override
    protected void onStop() {
        super.onStop();

        EventBus.getDefault().unregister(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEvent(SwitchTabEvent switchTabEvent) {
        if (switchTabEvent != null) {
            tabSwitch(switchTabEvent.tabIndex);
        }
    }

    private void initTabs() {
        activityMainBinding.tv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tabSwitch(TAB_FRAG_1);
            }
        });

        activityMainBinding.tv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tabSwitch(TAB_FRAG_2);
            }
        });

        activityMainBinding.tv3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tabSwitch(TAB_FRAG_3);
            }
        });
    }

    private void tabSwitch(@ReqType int tabId) {
        if (cutTab == tabId) {
            return;
        }

        cutTab = tabId;

        try {
            FragmentManager fragmentManager = getSupportFragmentManager();

            FragmentTransaction ft = fragmentManager.beginTransaction();

            switch (tabId) {
                case TAB_FRAG_1:
                    fragment1 = (Fragment1) fragmentManager.findFragmentByTag(Fragment1.class.getName());
                    if (fragment1 == null) {
                        fragment1 = new Fragment1();
                    }

                    if (!fragment1.isAdded()) {
                        ft.add(R.id.fragment_container, fragment1, Fragment1.class.getName());
                    }
                    hideFragments(ft, fragment2, fragment3);
                    ft.show(fragment1);
                    break;
                case TAB_FRAG_2:
                    fragment2 = (Fragment2) fragmentManager.findFragmentByTag(Fragment2.class.getName());
                    if (fragment2 == null) {
                        fragment2 = new Fragment2();
                    }

                    if (!fragment2.isAdded()) {
                        ft.add(R.id.fragment_container, fragment2, Fragment2.class.getName());
                    }
                    hideFragments(ft, fragment1, fragment3);
                    ft.show(fragment2);
                    break;
                case TAB_FRAG_3:
                    fragment3 = (Fragment3) fragmentManager.findFragmentByTag(Fragment3.class.getName());
                    if (fragment3 == null) {
                        fragment3 = new Fragment3();
                    }

                    if (!fragment3.isAdded()) {
                        ft.add(R.id.fragment_container, fragment3, Fragment3.class.getName());
                    }
                    hideFragments(ft, fragment1, fragment2);
                    ft.show(fragment3);
                    break;
            }

            ft.commitAllowingStateLoss();
            fragmentManager.executePendingTransactions();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void hideFragments(FragmentTransaction ft, Fragment... fragments) {
        if (fragments != null && fragments.length > 0) {
            for (Fragment fragment : fragments) {
                if (fragment != null) {
                    ft.hide(fragment);
                }
            }
        }
    }
}
