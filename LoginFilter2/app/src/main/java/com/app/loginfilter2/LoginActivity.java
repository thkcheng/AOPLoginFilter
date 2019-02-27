package com.app.loginfilter2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        findViewById(R.id.btnLogin).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SPUtil.putBoolean("isLogin", true);
                Toast.makeText(LoginActivity.this, "登录成功！", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
