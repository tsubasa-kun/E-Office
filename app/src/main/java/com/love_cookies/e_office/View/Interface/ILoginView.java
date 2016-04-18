package com.love_cookies.e_office.View.Interface;

/**
 * Created by xiekun on 2016/4/4.
 *
 * 登录页View接口
 */
public interface ILoginView {
    /**
     * 登录
     */
    void doLogin();

    /**
     * 跳转到主页
     */
    void turnToMain();

    /**
     * 登录失败
     * @param msg
     */
    void loginFailed(String msg);

    /**
     * 自动登录
     */
    void autoLogin();
}
