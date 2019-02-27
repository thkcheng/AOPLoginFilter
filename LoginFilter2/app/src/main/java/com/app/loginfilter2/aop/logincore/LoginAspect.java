package com.app.loginfilter2.aop.logincore;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.app.loginfilter2.LoginActivity;
import com.app.loginfilter2.SPUtil;
import com.app.loginfilter2.aop.annotation.LoginFilter;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;

/**
 * 切面
 */
@Aspect
public class LoginAspect {

    /**
     * 对含有某个方法的特定注解打上切点
     * Pointcut表示式: 表示匹配LoginFilter里的所有方法
     */
    @Pointcut("execution(@com.app.loginfilter2.aop.annotation.LoginFilter * *(..))")
    public void LoginFilter() {

    }

    /**
     * 处理 特定的打上切点的方法
     *
     * @param joinPoint
     * @Around不同于@After和@Before可以同时在所拦截方法的前后执行一段逻辑
     */
    @Around("LoginFilter()")
    public void aroundLoginPoint(ProceedingJoinPoint joinPoint) throws Throwable {
        //判断是否登录
        if (SPUtil.getBoolean("isLogin")) {
            joinPoint.proceed();
            return;
        }

        if (joinPoint.getThis() instanceof Context) {
            // 获得注解参数
            MethodSignature signature = (MethodSignature) joinPoint.getSignature();
            LoginFilter annotation = signature.getMethod().getAnnotation(LoginFilter.class);
            int type = annotation.type();

            dealWithType(type, (Context) joinPoint.getThis());
        }
    }

    private void dealWithType(int type, Context context) {
        switch (type) {
            case 0:
                Intent intent = new Intent(context, LoginActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
                break;
            default:
                Toast.makeText(context, "请先进行登陆!", Toast.LENGTH_SHORT).show();
                break;
        }
    }

}
