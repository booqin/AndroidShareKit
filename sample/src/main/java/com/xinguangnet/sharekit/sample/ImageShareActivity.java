package com.xinguangnet.sharekit.sample;

import com.xinguangnet.sharekit.action.ImageShareAction;
import com.xinguangnet.sharekit.callback.ShareResultCallback;
import com.xinguangnet.sharekit.callback.ShareStatusCallback;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * 图文分享Demo界面
 * Created by Boqin on 2017/6/1.
 * Modified by Boqin
 *
 * @Version
 */
public class ImageShareActivity extends AppCompatActivity{

    private Button mWBButton;
    private Button mWXButton;
    private ImageShareAction mImageShareAction;
    private ProgressDialog mProgressDialog;

    @Override
    protected void onCreate(
            @Nullable
                    Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_share);

        mImageShareAction = new ImageShareAction.Builder().setTitle("123").setContent("内容").setImageRes(R.drawable.test).build();
        mImageShareAction.setShareResultCallback(new ShareResultCallback() {
            @Override
            public void onShareSuccess() {
                Toast.makeText(ImageShareActivity.this, "Success", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onShareFail() {
                Toast.makeText(ImageShareActivity.this, "Fail", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onShareCancel() {
                Toast.makeText(ImageShareActivity.this, "Cancel", Toast.LENGTH_SHORT).show();
            }
        });

        mImageShareAction.setShareStatusCallback(new ShareStatusCallback() {
            @Override
            public void onStart() {
                mProgressDialog = new ProgressDialog(ImageShareActivity.this);
                mProgressDialog.show();
            }

            @Override
            public void onFinish() {
                if (mProgressDialog!=null) {
                    mProgressDialog.cancel();
                }
            }
        });

        mWBButton = (Button) findViewById(R.id.bt);
        mWXButton = (Button) findViewById(R.id.bt2);
        mWBButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mImageShareAction.showToWB(ImageShareActivity.this);
            }
        });

        mWXButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mImageShareAction.showToWX(ImageShareActivity.this);
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mImageShareAction.onDestroy();
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (mImageShareAction!=null) {
            mImageShareAction.doResultIntent(intent);
        }
    }
}
