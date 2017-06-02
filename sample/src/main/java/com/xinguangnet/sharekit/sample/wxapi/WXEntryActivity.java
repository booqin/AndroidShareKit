package com.xinguangnet.sharekit.sample.wxapi;

import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.IWXAPIEventHandler;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import com.xinguangnet.sharekit.ShareKit;
import com.xinguangnet.sharekit.WXCallbackActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

public class WXEntryActivity extends WXCallbackActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		finish();

	}

	@Override
	protected void onNewIntent(Intent intent) {
		super.onNewIntent(intent);

		finish();
	}

}