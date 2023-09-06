package com.tiger.test.coordinatorlayout;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.tiger.test.frag.BaseFragment;
import com.tiger.test.utils.ListUtils;

import java.util.ArrayList;
import java.util.List;

public class TestCLAStorydapter extends FragmentStatePagerAdapter {
    private List<BaseFragment> mFragmentList = new ArrayList<>();
    private FragmentManager fragmentManager;

    public TestCLAStorydapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
        fragmentManager = fm;
        createFragmentList();
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return mFragmentList.get(position);
    }

    @Override
    public int getCount() {
        return mFragmentList.size();
    }

    private void createFragmentList() {
        mFragmentList.clear();
        List<Fragment> fragments = fragmentManager.getFragments();
        TestCLUpNextFragment chapterListFragment = null;
        TestCLExploreFragment detailChildFragment = null;
        if (!ListUtils.isEmpty(fragments)) {
            for (int i = 0; i < fragments.size(); i++) {
                Fragment fragment = fragments.get(i);
                if (fragment instanceof TestCLUpNextFragment) {
                    chapterListFragment = (TestCLUpNextFragment) fragment;
                } else if (fragment instanceof TestCLExploreFragment) {
                    detailChildFragment = (TestCLExploreFragment) fragment;
                }
            }
        }
        if (chapterListFragment == null) {
            chapterListFragment = new TestCLUpNextFragment();
        }
        if (detailChildFragment == null) {
            detailChildFragment = new TestCLExploreFragment();
        }
        mFragmentList.add(chapterListFragment);
        mFragmentList.add(detailChildFragment);
    }

    public List<BaseFragment> getFragments() {
        return mFragmentList;
    }

    public void removeAllTab() {
        mFragmentList.clear();
        notifyDataSetChanged();
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        super.destroyItem(container, position, object);
        if (position >= getCount()) {
            fragmentManager.beginTransaction().remove((Fragment) object).commitAllowingStateLoss();
        }
    }

    @Override
    public int getItemPosition(@NonNull Object object) {
        if (object instanceof BaseFragment && mFragmentList.contains(object)) {
            return mFragmentList.indexOf(object);
        } else {
            return POSITION_NONE;
        }
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0) {
            return "Up Next";
        } else if (position == 1) {
            return "Explore";
        } else {
            return super.getPageTitle(position);
        }
    }

    @Override
    public void finishUpdate(@NonNull ViewGroup container) {
        try {
            super.finishUpdate(container);
        } catch (IllegalStateException ilse) {
            ilse.printStackTrace();
        }
    }
}

