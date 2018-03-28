package com.qun.test;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.qun.lib.rotatemenu.RotateMenuView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RotateMenuView rotateMenuView = findViewById(R.id.rotateMenu);
        rotateMenuView.setOnChannelClickListener(new RotateMenuView.OnChannelClickListener() {
            @Override
            public void onClick(int channelId) {
                Log.e("weiqun12345", "channelId=" + channelId);
            }
        });
    }
}
