package com.tiger.test.coordinatorlayout;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.tiger.test.R;
import com.tiger.test.frag.BaseFragment;
import com.tiger.test.utils.LogUtil;


/**
 * Created by tiger on 2018/3/5.
 */

public class TestCLStoryFragment extends BaseFragment implements View.OnClickListener {

    private View layoutView;
    private ViewPager viewpager;
    private TabLayout tabLayout;
    private TestCLAStorydapter clAdapter;

    private StickyScrollView stickyScrollView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        LogUtil.logd(this.getClass().getSimpleName() + " -> onCreateView.");
        layoutView = inflater.inflate(R.layout.fragment_story, container, false);
        return layoutView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        initViewPager();
    }

    private void initViewPager() {
        clAdapter = new TestCLAStorydapter(getChildFragmentManager(), FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        viewpager = layoutView.findViewById(R.id.viewpager);
        viewpager.setOffscreenPageLimit(clAdapter.getFragments().size());

        tabLayout = layoutView.findViewById(R.id.tabLayout);
        tabLayout.setupWithViewPager(viewpager);
        viewpager.setAdapter(clAdapter);

        viewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (getMActivity() != null) {
                    getMActivity().switchTabLayout2Index(position);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        stickyScrollView = layoutView.findViewById(R.id.sticky_scrollview);
        stickyScrollView.setOnStickingViewStateListener(new StickyScrollView.OnStickingViewStateListener() {
            @Override
            public void onStartStickingView() {
                if (getMActivity() != null) {
                    getMActivity().showTabLayout2(true);
                }
            }

            @Override
            public void onStopStickingView() {
                if (getMActivity() != null) {
                    getMActivity().showTabLayout2(false);
                }
            }
        });
    }

    private TestCoordinatorLayoutActivity getMActivity() {
        if (getActivity() == null) {
            return null;
        }
        if (getActivity() instanceof TestCoordinatorLayoutActivity) {
            return (TestCoordinatorLayoutActivity) getActivity();
        }
        return null;
    }

    public void changeIndex(int index) {
        viewpager.setCurrentItem(index);
    }

    @Override
    public void onClick(View v) {
    }
}
