package com.app.loginfilter1;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.app.loginfilter1.aop.logincore.ILoginFilter;
import com.app.loginfilter1.aop.logincore.LoginManger;

public class MyApplication extends Application {

    private static MyApplication instance;

    public static MyApplication getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;

        LoginManger.getInstance().init(this, iLoginFilter);
    }

    ILoginFilter iLoginFilter = new ILoginFilter() {
        @Override
        public void login(Context context, int loginDefine) {
            switch (loginDefine) {
                case 0:
                    Intent intent = new Intent(context, LoginActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                    break;
                case 1:
                    Toast.makeText(context, "您还没有登录，请登陆后执行", Toast.LENGTH_SHORT).show();
                    break;
                case 2:
                    Toast.makeText(context, "执行失败，因为您还没有登录！", Toast.LENGTH_SHORT).show();
                    break;
            }
        }

        @Override
        public boolean isLogin(Context context) {
            return SPUtil.getBoolean("isLogin");
        }
    };
}
