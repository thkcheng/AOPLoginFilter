package com.app.loginfilter1.aop.logincore;

import android.content.Context;

public class LoginAssistant {

    private LoginAssistant() {
    }

    private static LoginAssistant instance;

    /**
     * DoubleCheck单例 高效的、线程安全的
     */
    public static LoginAssistant getInstance() {
        if (instance == null) {
            synchronized (LoginAssistant.class) {
                if (instance == null) {
                    instance = new LoginAssistant();
                }
            }
        }
        return instance;
    }

    private ILoginFilter loginFilter;
    private Context context;

    public ILoginFilter getLoginFilter() {
        return loginFilter;
    }

    public void setLoginFilter(ILoginFilter loginFilter) {
        this.loginFilter = loginFilter;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }
}
