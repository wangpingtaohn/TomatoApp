package com.tomato.irrigation.ui;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

import com.tomato.irrigation.R;
import com.tomato.irrigation.utils.SpUtils;
import com.tomato.irrigation.utils.ToastUtil;

public class LoginActivity extends AppCompatActivity {

    private EditText etAccount;
    private EditText etPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initView();

    }

    /**
     * 初始化组件
     */
    private void initView(){
        etAccount = findViewById(R.id.etAccount);
        etPassword = findViewById(R.id.etPassword);

        findViewById(R.id.btnLogin).setOnClickListener(v -> login());

        String account = SpUtils.getInstance().getStringValue("account");
        String password = SpUtils.getInstance().getStringValue("password");
        if (!TextUtils.isEmpty(account)){
            etAccount.setText(account);
        }
        if (!TextUtils.isEmpty(password)){
            etPassword.setText(password);
        }
    }

    private void login(){
        String account = etAccount.getText().toString();
        String password = etPassword.getText().toString();
        if (TextUtils.isEmpty(account)){
            ToastUtil.show("账号不能为空");
            return;
        }
        if (TextUtils.isEmpty(password)){
            ToastUtil.show("密码不能为空");
            return;
        }
        SpUtils.getInstance().setStringValue("account",account);
        SpUtils.getInstance().setStringValue("password",password);
        startActivity(new Intent(this,MainActivity.class));
        finish();
    }
}