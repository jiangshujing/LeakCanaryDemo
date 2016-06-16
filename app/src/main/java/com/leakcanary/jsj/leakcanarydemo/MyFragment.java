package com.leakcanary.jsj.leakcanarydemo;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by jsj on 16/6/15.
 */
public class MyFragment extends BaseFragment{

    @TargetApi(Build.VERSION_CODES.M)
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_my, container, false);

        TextView textview = (TextView)view.findViewById(R.id.textview);
        TestDataModel.getInstance().setRetainedTextView(textview);//调用能引起内存泄漏的代码
        return view;
    }
}
