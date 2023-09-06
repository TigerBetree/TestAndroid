package com.tiger.test.coordinatorlayout2;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.tiger.test.coordinatorlayout.TestCLReadFragment;
import com.tiger.test.frag.BaseFragment;
import com.tiger.test.utils.ListUtils;

import java.util.ArrayList;
import java.util.List;

public class TestCLAdapter2 extends FragmentStatePagerAdapter {
    private List<BaseFragment> mFragmentList = new ArrayList<>();
    private FragmentManager fragmentManager;

    public TestCLAdapter2(@NonNull FragmentManager fm, int behavior) {
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
        TestCLStoryFragment2 chapterListFragment = null;
        TestCLReadFragment detailChildFragment = null;
        if (!ListUtils.isEmpty(fragments)) {
            for (int i = 0; i < fragments.size(); i++) {
                Fragment fragment = fragments.get(i);
                if (fragment instanceof TestCLStoryFragment2) {
                    chapterListFragment = (TestCLStoryFragment2) fragment;
                } else if (fragment instanceof TestCLReadFragment) {
                    detailChildFragment = (TestCLReadFragment) fragment;
                }
            }
        }
        if (chapterListFragment == null) {
            chapterListFragment = new TestCLStoryFragment2();
        }
        if (detailChildFragment == null) {
            detailChildFragment = new TestCLReadFragment();
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
            return "Story";
        } else if (position == 1) {
            return "Read";
        } else {
            return super.getPageTitle(position);
        }
    }

    public TestCLStoryFragment2 getStoryFragment() {
        if (!ListUtils.isEmpty(mFragmentList)) {
            BaseFragment baseFragment = mFragmentList.get(0);
            if (baseFragment instanceof TestCLStoryFragment2) {
                return (TestCLStoryFragment2) baseFragment;
            }
        }
        return null;
    }

    public TestCLReadFragment getReadFragment() {
        if (!ListUtils.isEmpty(mFragmentList) && mFragmentList.size() > 1) {
            BaseFragment baseFragment = mFragmentList.get(1);
            if (baseFragment instanceof TestCLReadFragment) {
                return (TestCLReadFragment) baseFragment;
            }
        }
        return null;
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

