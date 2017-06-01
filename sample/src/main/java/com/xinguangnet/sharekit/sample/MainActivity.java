package com.xinguangnet.sharekit.sample;

import com.xinguangnet.sharekit.action.ImageShareAction;
import com.xinguangnet.sharekit.callback.ShareResultCallback;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button mButton;
    private Button mWXButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mButton = (Button) findViewById(R.id.bt);
        mWXButton = (Button) findViewById(R.id.bt2);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), TextShareActivity.class);
                v.getContext().startActivity(intent);
            }
        });

        mWXButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), ImageShareActivity.class);
                v.getContext().startActivity(intent);
            }
        });
    }

}
