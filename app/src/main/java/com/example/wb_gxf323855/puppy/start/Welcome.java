package com.example.wb_gxf323855.puppy.start;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;

import com.example.wb_gxf323855.puppy.R;

/**
 * Created by wb-gxf323855 on 2017/9/20.
 */

public class Welcome extends AppCompatActivity {

    private static final int GO_GUIDE = 0;
    private static final int GO_LOGIN = 1;
    private static final int DELAY = 2000;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        initLoad();
    }

    private void initLoad() {
        SharedPreferences sharedPreferences=getSharedPreferences("puppy",MODE_PRIVATE);
        boolean guide=sharedPreferences.getBoolean("guide",true);
        if (!guide){
            handler.sendEmptyMessageDelayed(GO_LOGIN,DELAY);
        }
        else {
            handler.sendEmptyMessageDelayed(GO_GUIDE,DELAY);
            SharedPreferences.Editor editor=sharedPreferences.edit();
            editor.apply();
        }

    }

    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {

                case GO_GUIDE: {
                    goGuide();
                    break;
                }
                case GO_LOGIN: {
                    goLogin();
                    break;
                }
                default:
                    break;
            }
        }
    };

    private void goLogin() {
        Intent intent = new Intent(this, Login.class);
        startActivity(intent);
        finish();
    }

    private void goGuide() {
        Intent intent = new Intent(this, Guide.class);
        startActivity(intent);
        finish();
    }
}
