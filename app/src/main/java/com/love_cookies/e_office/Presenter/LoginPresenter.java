package com.love_cookies.e_office.Presenter;

import com.love_cookies.e_office.E_OfficeApplication;
import com.love_cookies.e_office.Model.Bean.UserBean;
import com.love_cookies.e_office.Model.Biz.LoginBiz;
import com.love_cookies.e_office.View.Interface.CallBack;
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

    /**
     * 登录
     * @param username
     * @param password
     */
    public void doLogin(final String username, final String password) {
        loginBiz.doLogin(username, password, new CallBack() {
            @Override
            public void onSuccess(Object result) {
                E_OfficeApplication.setUser((UserBean)result);
                E_OfficeApplication.editor.putString("username", username);
                E_OfficeApplication.editor.putString("password", password);
                E_OfficeApplication.editor.commit();
                iLoginView.turnToMain();
            }

            @Override
            public void onFailed(Object msg) {
                iLoginView.loginFailed((String)msg);
            }
        });
    }

}
