package com.xinguangnet.sharekit;

import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import com.xinguangnet.sharekit.performer.WXSessionSharePerformerImpl;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 *
 * Created by Boqin on 2017/6/1.
 * Modified by Boqin
 *
 * @Version
 */
public class WXCallbackActivity extends AppCompatActivity{

    private IWXAPI mWxApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mWxApi = WXAPIFactory.createWXAPI(this, ShareKit.WX_APP_ID, false);
        mWxApi.handleIntent(getIntent(), WXSessionSharePerformerImpl.getInstance());
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        mWxApi.handleIntent(getIntent(), WXSessionSharePerformerImpl.getInstance());
    }
}
