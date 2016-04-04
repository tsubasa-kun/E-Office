package com.love_cookies.e_office.Presenter;

import com.love_cookies.cookie_library.Interface.CallBack;
import com.love_cookies.e_office.Model.Biz.LoginBiz;
import com.love_cookies.e_office.View.Interface.ILoginView;

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

    public void doLogin(String username, String password) {
        loginBiz.doLogin(username, password, new CallBack() {
            @Override
            public void getSuccess(Object result) {
                iLoginView.turnToMain();
            }

            @Override
            public void getFailed(Object msg) {
                iLoginView.loginFailed((String)msg);
            }
        });
    }

}
