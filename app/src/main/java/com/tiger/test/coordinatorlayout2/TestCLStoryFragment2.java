package com.tiger.test.coordinatorlayout2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.tabs.TabLayout;
import com.tiger.test.R;
import com.tiger.test.frag.BaseFragment;
import com.tiger.test.utils.LogUtil;


/**
 * Created by tiger on 2018/3/5.
 */

public class TestCLStoryFragment2 extends BaseFragment implements View.OnClickListener {

    private View layoutView;
    private ViewPager viewpager;
    private TabLayout tabLayout;
    private TestCLAStorydapter2 clAdapter;
    private AppBarLayout appBarLayout;
    private NestedScrollCoordinatorLayout rootView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        LogUtil.logd(this.getClass().getSimpleName() + " -> onCreateView.");
        layoutView = inflater.inflate(R.layout.fragment_complex_details_page, container, false);
        return layoutView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        initViewPager();
    }

    private void initViewPager() {
        clAdapter = new TestCLAStorydapter2(getChildFragmentManager());
        viewpager = layoutView.findViewById(R.id.viewpager);
        viewpager.setOffscreenPageLimit(clAdapter.getFragments().size());

        tabLayout = layoutView.findViewById(R.id.tabLayout);
        tabLayout.setupWithViewPager(viewpager);
        viewpager.setAdapter(clAdapter);

        appBarLayout = layoutView.findViewById(R.id.appbar_layout);
        appBarLayout.addOnOffsetChangedListener((appBarLayout, verticalOffset) -> {
            if (Math.abs(verticalOffset) >= appBarLayout.getTotalScrollRange()) {
                if (getMActivity() != null) {
                    getMActivity().showTabLayout2(true);
                }
            } else {
                if (getMActivity() != null) {
                    getMActivity().showTabLayout2(false);
                }
            }
        });

        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                LogUtil.logd("onOffsetChanged : " + verticalOffset);
                if (verticalOffset == 0) {
                    if (getMActivity() != null) {
                        getMActivity().setAllowUsrDragging(true);
                    }
                } else if (Math.abs(verticalOffset) >= appBarLayout.getTotalScrollRange()) {
                    if (getMActivity() != null) {
                        getMActivity().setAllowUsrDragging(false);
                    }
                }
            }
        });
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
    }

    private TestCoordinatorLayoutActivity2 getMActivity() {
        if (getActivity() == null) {
            return null;
        }
        if (getActivity() instanceof TestCoordinatorLayoutActivity2) {
            return (TestCoordinatorLayoutActivity2) getActivity();
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
