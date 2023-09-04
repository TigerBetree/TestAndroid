package com.tiger.test.frag;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.tiger.test.utils.LogUtil;

/**
 * Created by tiger on 2018/3/5.
 */

public abstract class BaseFragment extends Fragment {

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        LogUtil.logd(this.getClass().getSimpleName() + " -> onAttach.");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LogUtil.logd(this.getClass().getSimpleName() + " -> onCreate.");
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        LogUtil.logd(this.getClass().getSimpleName() + " -> onActivityCreated.");
    }

    @Override
    public void onStart() {
        super.onStart();
        LogUtil.logd(this.getClass().getSimpleName() + " -> onStart.");
    }

    @Override
    public void onResume() {
        super.onResume();
        LogUtil.logd(this.getClass().getSimpleName() + " -> onResume.");
    }

    @Override
    public void onPause() {
        super.onPause();
        LogUtil.logd(this.getClass().getSimpleName() + " -> onPause.");
    }

    @Override
    public void onStop() {
        super.onStop();
        LogUtil.logd(this.getClass().getSimpleName() + " -> onStop.");
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        LogUtil.logd(this.getClass().getSimpleName() + " -> onSaveInstanceState.");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        LogUtil.logd(this.getClass().getSimpleName() + " -> onDestroyView.");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        LogUtil.logd(this.getClass().getSimpleName() + " -> onDestroy.");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        LogUtil.logd(this.getClass().getSimpleName() + " -> onDetach.");
    }
}
