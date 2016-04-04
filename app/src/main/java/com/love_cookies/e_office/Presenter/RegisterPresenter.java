package com.love_cookies.e_office.Presenter;

import com.love_cookies.cookie_library.Interface.CallBack;
import com.love_cookies.e_office.Model.Biz.RegisterBiz;
import com.love_cookies.e_office.View.Interface.IRegisterView;

/**
 * Created by xiekun on 2016/4/4.
 *
 * 注册Presenter
 */
public class RegisterPresenter {

    private RegisterBiz registerBiz;
    private IRegisterView iRegisterView;

    public RegisterPresenter(IRegisterView iRegisterView) {
        registerBiz = new RegisterBiz();
        this.iRegisterView = iRegisterView;
    }

    public void doRegister(String username, String password, String nickname) {
        registerBiz.doRegister(username, password, nickname, new CallBack() {
            @Override
            public void getSuccess(Object result) {
                iRegisterView.turnToLogin();
            }

            @Override
            public void getFailed(Object msg) {
                iRegisterView.registerFailed((String)msg);
            }
        });
    }

}
