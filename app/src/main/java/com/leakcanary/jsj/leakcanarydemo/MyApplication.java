package com.leakcanary.jsj.leakcanarydemo;

import android.app.Application;
import android.content.Context;

import com.squareup.leakcanary.AndroidExcludedRefs;
import com.squareup.leakcanary.DisplayLeakService;
import com.squareup.leakcanary.ExcludedRefs;
import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;

/**
 * Created by jsj on 16/6/15.
 */
public class MyApplication extends Application {

    private RefWatcher refWatcher;

    public static RefWatcher getRefWatcher(Context context) {
        MyApplication application = (MyApplication) context.getApplicationContext();
        return application.refWatcher;
    }


    @Override
    public void onCreate() {
        super.onCreate();
        refWatcher = LeakCanary.install(this);
//        refWatcher = installLeakCanary();
    }

    /**
     * 忽略内存泄漏的地方
     *
     * @return
     */
    private RefWatcher installLeakCanary() {
        ExcludedRefs excludedRefs = AndroidExcludedRefs.createAndroidDefaults()
                .instanceField("android.app.FragmentManagerImpl", "mAdded")
                .instanceField("com.leakcanary.jsj.leakcanarydemo.FragmentActivity", "mFragments")
                .build();

        return LeakCanary.install(this, DisplayLeakService.class, excludedRefs);
    }
}
