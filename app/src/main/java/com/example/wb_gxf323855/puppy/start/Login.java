package com.example.wb_gxf323855.puppy.start;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.wb_gxf323855.puppy.R;

/**
 * Created by wb-gxf323855 on 2017/9/20.
 */

public class Login extends AppCompatActivity implements View.OnClickListener {

    private EditText login_email;
    private EditText login_password;
    private Button btn_login;
    private TextView txt_register;
    private static final int REQUEST_REGISTER = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION, WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);   initView();

    }

    private void initView() {
        login_email = (EditText) findViewById(R.id.login_email);
        login_password = (EditText) findViewById(R.id.login_password);
        btn_login = (Button) findViewById(R.id.btn_login);
        txt_register = (TextView) findViewById(R.id.txt_register);

        btn_login.setOnClickListener(this);
        txt_register.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_login: {
                Intent intent = new Intent(this, Main.class);
                startActivity(intent);
                finish();
            }
            case R.id.txt_register: {
                Intent intent = new Intent(this, Register.class);
                startActivityForResult(intent, REQUEST_REGISTER);
                finish();
            }
            default:
                break;
        }
    }


}
