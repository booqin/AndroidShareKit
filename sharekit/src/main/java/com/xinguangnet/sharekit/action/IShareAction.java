package com.xinguangnet.sharekit.action;

import android.app.Activity;
import android.content.Intent;

/**
 * 分享接口
 * Created by Boqin on 2017/5/25.
 * Modified by Boqin
 *
 * @Version
 */
public interface IShareAction {

    /**
     * 微信
     */
    void showToWX(Activity activity);

    /**
     * 微信朋友圈
     */
    void showToWXCircle(Activity activity);

    /**
     * 微博
     */
    void showToWB(Activity activity);

    void doResultIntent(Intent intent);
}
