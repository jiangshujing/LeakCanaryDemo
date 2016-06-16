package com.leakcanary.jsj.leakcanarydemo;

import android.app.Fragment;

import com.squareup.leakcanary.RefWatcher;

/**
 * Created by jsj on 16/6/15.
 */
public abstract class BaseFragment extends Fragment {

    @Override public void onDestroy() {
        super.onDestroy();
        RefWatcher refWatcher = MyApplication.getRefWatcher(getActivity());
        refWatcher.watch(this);
    }
}
