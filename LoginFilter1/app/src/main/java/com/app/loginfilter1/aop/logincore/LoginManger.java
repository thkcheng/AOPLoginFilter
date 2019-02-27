package com.app.loginfilter1.aop.logincore;

import android.content.Context;

/**
 * https://blog.csdn.net/wb_001/article/details/81975645
 */
public class LoginManger {

    private static LoginManger instance;

    private LoginManger() {
    }

    /**
     * DoubleCheck单例 高效的、线程安全的
     */
    public static LoginManger getInstance() {
        if (null == instance) {
            synchronized (LoginManger.class) {
                if (null == instance) {
                    instance = new LoginManger();
                }
            }
        }
        return instance;
    }


    public void init(Context context, ILoginFilter iLoginFilter) {
        LoginAssistant.getInstance().setContext(context);
        LoginAssistant.getInstance().setLoginFilter(iLoginFilter);
    }

}
