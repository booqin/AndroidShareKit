package com.xinguangnet.sharekit.sample.wxapi;

import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.IWXAPIEventHandler;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import com.xinguangnet.sharekit.ShareKit;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

public class WXEntryActivity extends Activity {

	private IWXAPI mWxApi;

	private static IWXAPIEventHandler mEventHandler;

	public static void setEventHandler(IWXAPIEventHandler mEventHandler) {
		WXEntryActivity.mEventHandler = mEventHandler;
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		mWxApi = WXAPIFactory.createWXAPI(this, ShareKit.WX_APP_ID, false);
		Log.d("BQ", "onCreate");
		finish();
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

}