package com.tiger.test.coordinatorlayout2;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.tabs.TabLayout;
import com.tiger.test.R;
import com.tiger.test.databinding.ActivityTestCoordinatorLayout2Binding;

public class TestCoordinatorLayoutActivity2 extends FragmentActivity {

    private TestCLAdapter2 clAdapter = null;
    private ActivityTestCoordinatorLayout2Binding mBinding = null;

    private BottomSheetBehavior<ConstraintLayout> behavior;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_test_coordinator_layout2);

        initViewPager();
        setRootViewBehavior();
    }

    private void setRootViewBehavior() {
        behavior = BottomSheetBehavior.from(mBinding.rootView);
        behavior.setState(BottomSheetBehavior.STATE_EXPANDED);
        behavior.addBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View view, int newState) {
                //这里是bottomSheet 状态的改变，根据slideOffset可以做一些动画
                if (newState == BottomSheetBehavior.STATE_HIDDEN) {
                    TestCoordinatorLayoutActivity2.this.finish();
                } else if (newState == BottomSheetBehavior.STATE_COLLAPSED
                        || newState == BottomSheetBehavior.STATE_HALF_EXPANDED) {
                    if (behavior != null) {
                        behavior.setState(BottomSheetBehavior.STATE_HIDDEN);
                    }
                }
            }

            @Override
            public void onSlide(@NonNull View view, float v) {
                //这里是拖拽中的回调，根据slideOffset可以做一些动画
            }
        });
//        if (currentIndex == 1 && behavior != null && behavior instanceof LockableBottomSheetBehavior) {
//            ((LockableBottomSheetBehavior) behavior).setAllowUserDragging(false);
//        }
        setAllowUsrDragging(false);
        setRootViewBehaviorDraggable(false);
    }

    private void setRootViewBehaviorDraggable(boolean isDraggable) {
        if (behavior != null) {
            behavior.setDraggable(isDraggable);
        }
    }

    public void setAllowUsrDragging(boolean allowUserDragging) {
        if (behavior != null && behavior instanceof LockableBottomSheetBehavior) {
            ((LockableBottomSheetBehavior<?>) behavior).setAllowUserDragging(allowUserDragging);
        }

        setRootViewBehaviorDraggable(allowUserDragging);
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
