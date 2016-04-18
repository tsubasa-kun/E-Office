package com.love_cookies.e_office.Presenter;

import com.love_cookies.cookie_library.Application.ActivityCollections;
import com.love_cookies.cookie_library.Interface.CallBack;
import com.love_cookies.e_office.Model.Bean.UserBean;
import com.love_cookies.e_office.Model.Biz.LoginBiz;
import com.love_cookies.e_office.View.Interface.ILoginView;

import cn.bmob.v3.BmobUser;

/**
 * Created by xiekun on 2016/4/4.
 *
 * 登录Presenter
 */
public class LoginPresenter {

    private LoginBiz loginBiz;
    private ILoginView iLoginView;

    public LoginPresenter(ILoginView iLoginView) {
        loginBiz = new LoginBiz();
        this.iLoginView = iLoginView;
    }

    /**
     * 登录
     * @param username
     * @param password
     */
    public void doLogin(String username, String password) {
        loginBiz.doLogin(username, password, new CallBack() {
            @Override
            public void onSuccess(Object result) {
                iLoginView.turnToMain();
            }

            @Override
            public void onFailed(Object msg) {
                iLoginView.loginFailed((String)msg);
            }
        });
    }

    /**
     * 自动登录
     */
    public void autoLogin() {
        UserBean userBean = BmobUser.getCurrentUser(ActivityCollections.getInstance().currentActivity(), UserBean.class);
        if(userBean != null) {
            iLoginView.turnToMain();
        }
    }

}
