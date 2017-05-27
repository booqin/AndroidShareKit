package com.xinguangnet.sharekit;

import com.sina.weibo.sdk.WbSdk;
import com.sina.weibo.sdk.auth.AuthInfo;

import android.content.Context;

/**
 * TODO
 * Created by Boqin on 2017/5/27.
 * Modified by Boqin
 *
 * @Version
 */
public class ShareKit {

    private static String WB_APP_KEY;

    private static String WX_APP_ID;

    public static void initialize(Context context, String wbAppKey, String wxAppId){
        WbSdk.install(context,new AuthInfo(context, wbAppKey, Constants.REDIRECT_URL, Constants.SCOPE));
    }
}
