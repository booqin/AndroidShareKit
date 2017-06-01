package com.xinguangnet.sharekit.sample;

import com.xinguangnet.sharekit.ShareKit;

import android.app.Application;

/**
 * TODO
 * Created by Boqin on 2017/5/27.
 * Modified by Boqin
 *
 * @Version
 */
public class DemoApplication extends Application{

    @Override
    public void onCreate() {
        super.onCreate();
        ShareKit.initialize(this, "985334501", "wx9334c56d5055ec87");
    }
}
