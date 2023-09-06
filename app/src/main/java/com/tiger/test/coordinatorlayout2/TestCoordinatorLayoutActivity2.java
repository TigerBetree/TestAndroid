package com.tiger.test.coordinatorlayout2;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.google.android.material.tabs.TabLayout;
import com.tiger.test.R;
import com.tiger.test.databinding.ActivityTestCoordinatorLayout2Binding;

public class TestCoordinatorLayoutActivity2 extends FragmentActivity {

    private TestCLAdapter2 clAdapter = null;
    private ActivityTestCoordinatorLayout2Binding mBinding = null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_test_coordinator_layout2);

        initViewPager();
    }

    private void initViewPager() {
        clAdapter = new TestCLAdapter2(getSupportFragmentManager(), FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        mBinding.viewpager.setOffscreenPageLimit(clAdapter.getFragments().size());
        mBinding.tabLayout.setupWithViewPager(mBinding.viewpager);
        mBinding.viewpager.setAdapter(clAdapter);

        String[] titles = new String[]{"Up Next", "Explore"};
        for (int i = 0; i < titles.length; i++) {
            TabLayout.Tab tab = mBinding.tabLayout2.newTab();
            tab.setText(titles[i]);
            tab.setId(i);
            mBinding.tabLayout2.addTab(tab);
        }
        mBinding.tabLayout2.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if (clAdapter != null && clAdapter.getStoryFragment() != null) {
                    clAdapter.getStoryFragment().changeIndex(tab.getId());
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    public void showTabLayout2(boolean isShow) {
        if (isShow) {
            mBinding.tabLayout.setVisibility(View.GONE);
            mBinding.tabLayout2.setVisibility(View.VISIBLE);
            mBinding.viewpager.setCanScroll(false);
        } else {
            mBinding.tabLayout.setVisibility(View.VISIBLE);
            mBinding.tabLayout2.setVisibility(View.GONE);
            mBinding.viewpager.setCanScroll(true);
        }
    }

    public void switchTabLayout2Index(int index) {
        mBinding.tabLayout2.selectTab(mBinding.tabLayout2.getTabAt(index));
    }
}
