package com.xinguangnet.sharekit;

import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.IWXAPIEventHandler;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import com.xinguangnet.sharekit.wxapi.WXEntryActivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

/**
 *
 * Created by Boqin on 2017/6/1.
 * Modified by Boqin
 *
 * @Version
 */
public class WXCallbackActivity extends AppCompatActivity implements IWXAPIEventHandler{

    private IWXAPI mWxApi;

    private static IWXAPIEventHandler mEventHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mWxApi = WXAPIFactory.createWXAPI(this, ShareKit.WX_APP_ID, false);
        Log.d("BQ", "onCreate");
        //		mWxApi.handleIntent(getIntent(), mEventHandler);
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        mWxApi.handleIntent(intent, mEventHandler);
        Log.d("BQ", "onNewIntent");
        mEventHandler = null;
        finish();
    }

    @Override
    public void onReq(BaseReq baseReq) {

    }

    @Override
    public void onResp(BaseResp baseResp) {

    }
}
