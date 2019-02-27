package com.app.loginfilter1.aop.logincore;

import android.content.Context;

/**
 * Description：定义登录拦截接口
 */
public interface ILoginFilter {

    void login(Context context, int loginDefine);

    boolean isLogin(Context context);

}
