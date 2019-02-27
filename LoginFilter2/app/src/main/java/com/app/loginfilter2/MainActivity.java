package com.app.loginfilter2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.app.loginfilter2.aop.annotation.LoginFilter;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btnBuy).setOnClickListener(this);
    }

    @LoginFilter(type = 0)
    @Override
    public void onClick(View v) {
        startActivity(new Intent(this, BuyActivity.class));
    }

    public void clickLogout(View v) {
        Log.e("LoginFilterAspect", "ClickLogout() ");
        SPUtil.putBoolean("isLogin", false);
        Toast.makeText(MainActivity.this, "退出登录成功！", Toast.LENGTH_SHORT).show();
    }

}
