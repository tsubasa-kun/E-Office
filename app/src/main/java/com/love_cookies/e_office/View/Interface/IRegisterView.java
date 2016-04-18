package com.love_cookies.e_office.View.Interface;

/**
 * Created by xiekun on 2016/4/4.
 *
 * 注册页View接口
 */
public interface IRegisterView {
    /**
     * 注册
     */
    void doRegister();

    /**
     * 跳转到登录页
     */
    void turnToLogin();

    /**
     * 注册失败
     * @param msg
     */
    void registerFailed(String msg);
}
