package com.xinguangnet.sharekit;

import com.sina.weibo.sdk.WbSdk;
import com.sina.weibo.sdk.auth.AuthInfo;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;

import android.content.Context;

/**
 * TODO
 * Created by Boqin on 2017/5/27.
 * Modified by Boqin
 *
 * @Version
 */
public class ShareKit {

    public static String WB_APP_KEY;

    public static String WX_APP_ID;

    public static IWXAPI api;

    public static void initialize(Context context, String wbAppKey, String wxAppId){
        WB_APP_KEY = wbAppKey;
        WX_APP_ID = wxAppId;
        WbSdk.install(context,new AuthInfo(context, WB_APP_KEY, Constants.REDIRECT_URL, Constants.SCOPE));
        api = WXAPIFactory.createWXAPI(context, ShareKit.WX_APP_ID);
        api.registerApp(ShareKit.WX_APP_ID);
    }
}
