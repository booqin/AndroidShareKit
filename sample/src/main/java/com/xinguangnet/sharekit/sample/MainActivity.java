package com.xinguangnet.sharekit.sample;

import com.sina.weibo.sdk.WbSdk;
import com.sina.weibo.sdk.auth.AuthInfo;
import com.xinguangnet.sharekit.Constants;
import com.xinguangnet.sharekit.action.ImageShareAction;
import com.xinguangnet.sharekit.callback.ShareResultCallback;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button mButton;
    private ImageShareAction mImageShareAction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        WbSdk.install(this,new AuthInfo(this, Constants.APP_KEY, Constants.REDIRECT_URL, Constants.SCOPE));

        mButton = (Button) findViewById(R.id.bt);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mImageShareAction = new ImageShareAction.Builder().setTitle("123").setContent("内容").setImage("").build();
                mImageShareAction.setShareResultCallback(new ShareResultCallback() {
                    @Override
                    public void onShareSuccess() {
                        Toast.makeText(MainActivity.this, "Success", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onShareFail() {
                        Toast.makeText(MainActivity.this, "Fail", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onShareCancel() {
                        Toast.makeText(MainActivity.this, "Cancel", Toast.LENGTH_SHORT).show();
                    }
                });
                mImageShareAction.showToWB(MainActivity.this);
            }
        });
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (mImageShareAction!=null) {
            mImageShareAction.doResultIntent(intent);
        }
    }
}
