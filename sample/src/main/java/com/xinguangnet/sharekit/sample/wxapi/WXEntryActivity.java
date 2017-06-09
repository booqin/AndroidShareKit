package com.xinguangnet.sharekit.sample.wxapi;

import com.xinguangnet.sharekit.WXCallbackActivity;

import android.content.Intent;
import android.os.Bundle;

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