package com.love_cookies.e_office.View.Interface;

import com.love_cookies.e_office.Model.Bean.UserBean;

/**
 * Created by xiekun on 2016/4/19 0019.
 *
 * 主页 View接口
 */
public interface IMainView {
    /**
     * 获取用户
     */
    void getUser();

    /**
     * 设置用户
     * @param userBean
     */
    void setUser(UserBean userBean);

    /**
     * 签到
     */
    void doSignIn();

    /**
     * 签到成功
     */
    void signInSuccess();

    /**
     * 签到失败
     */
    void signInFailed();

    /**
     * 签退
     */
    void doSignOut();

    /**
     * 签退成功
     */
    void signOutSuccess();

    /**
     * 签退失败
     */
    void signOutFailed();

    /**
     * 登出
     */
    void doLogout();

    /**
     * 跳转到登录页
     */
    void turnToLogin();

}
