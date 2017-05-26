package com.xinguangnet.sharekit.wxapi;

import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.IWXAPIEventHandler;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import com.xinguangnet.sharekit.Constants;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class WXEntryActivity extends Activity {

	private IWXAPI mWxApi;

	private static IWXAPIEventHandler mEventHandler;

	public static void setEventHandler(IWXAPIEventHandler mEventHandler) {
		WXEntryActivity.mEventHandler = mEventHandler;
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		mWxApi = WXAPIFactory.createWXAPI(this, Constants.WX_APP_ID, false);
//		mWxApi.handleIntent(getIntent(), mEventHandler);
	}

	@Override
	protected void onNewIntent(Intent intent) {
		super.onNewIntent(intent);
		mWxApi.handleIntent(intent, mEventHandler);
		mEventHandler = null;
		finish();
	}

}