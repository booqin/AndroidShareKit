package com.xinguangnet.sharekit.sample;

import com.sina.weibo.sdk.WbSdk;
import com.sina.weibo.sdk.auth.AuthInfo;
import com.xinguangnet.sharekit.Constants;
import com.xinguangnet.sharekit.ImageShareAction;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        WbSdk.install(this,new AuthInfo(this, Constants.APP_KEY, Constants.REDIRECT_URL, Constants.SCOPE));

        mButton = (Button) findViewById(R.id.bt);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageShareAction imageShareAction = new ImageShareAction.Builder().setTitle("123").setContent("内容").setImage("").build();
                imageShareAction.showToWB(MainActivity.this);
            }
        });
    }
}
