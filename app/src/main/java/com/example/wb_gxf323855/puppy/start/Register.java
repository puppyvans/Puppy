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

public class Register extends AppCompatActivity implements View.OnClickListener {

    private EditText register_name;
    private EditText register_email;
    private EditText register_moblie;
    private EditText register_password;
    private EditText register_rePassword;
    private Button btn_register;
    private TextView txt_login;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION, WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);

        initView();
    }

    private void initView() {
        register_name = (EditText) findViewById(R.id.register_name);
        register_email = (EditText) findViewById(R.id.register_email);
        register_moblie = (EditText) findViewById(R.id.register_moblie);
        register_password = (EditText) findViewById(R.id.register_password);
        register_rePassword = (EditText) findViewById(R.id.register_rePassword);
        btn_register = (Button) findViewById(R.id.btn_register);
        txt_login = (TextView) findViewById(R.id.txt_login);

        btn_register.setOnClickListener(this);
        txt_login.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_register: {
                Intent intent = new Intent(this, Main.class);
                startActivity(intent);
                finish();
                break;
            }
            case R.id.txt_login: {
                Intent intent = new Intent(this, Login.class);
                startActivity(intent);
                finish();
                break;
            }
            default:
                break;
        }
    }
}
