package com.xinguangnet.sharekit.sample;

import com.xinguangnet.sharekit.action.ImageShareAction;
import com.xinguangnet.sharekit.action.TextShareAction;
import com.xinguangnet.sharekit.callback.ShareResultCallback;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * TODO
 * Created by Boqin on 2017/6/1.
 * Modified by Boqin
 *
 * @Version
 */
public class TextShareActivity extends AppCompatActivity{

    private Button mWBButton;
    private Button mWXButton;
    private TextShareAction mTextShareAction;

    @Override
    protected void onCreate(
            @Nullable
                    Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_share);

        mTextShareAction = new TextShareAction.Builder().setTitle("123").setContent("内容").build();
        mTextShareAction.setShareResultCallback(new ShareResultCallback() {
            @Override
            public void onShareSuccess() {
                Toast.makeText(TextShareActivity.this, "Success", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onShareFail() {
                Toast.makeText(TextShareActivity.this, "Fail", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onShareCancel() {
                Toast.makeText(TextShareActivity.this, "Cancel", Toast.LENGTH_SHORT).show();
            }
        });

        mWBButton = (Button) findViewById(R.id.bt);
        mWXButton = (Button) findViewById(R.id.bt2);
        mWBButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTextShareAction.showToWB(TextShareActivity.this);
            }
        });

        mWXButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }


    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (mTextShareAction!=null) {
            mTextShareAction.doResultIntent(intent);
        }
    }
}
