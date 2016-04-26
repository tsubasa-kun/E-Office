package com.love_cookies.e_office.Presenter;

import com.love_cookies.e_office.E_OfficeApplication;
import com.love_cookies.e_office.Model.Bean.UserBean;
import com.love_cookies.e_office.Model.Biz.AttendanceBiz;
import com.love_cookies.e_office.View.Interface.CallBack;
import com.love_cookies.e_office.View.Interface.IMainView;

/**
 * Created by xiekun on 2016/4/19 0019.
 *
 * 主页Presenter
 */
public class MainPresenter {

    private AttendanceBiz attendanceBiz;
    private IMainView iMainView;

    public MainPresenter(IMainView iMainView) {
        attendanceBiz = new AttendanceBiz();
        this.iMainView = iMainView;
    }

    /**
     * 获取用户
     */
    public void getUser() {
        UserBean userBean = E_OfficeApplication.user;
        iMainView.setUser(userBean);
    }

    /**
     * 签到
     */
    public void doSignIn() {
        attendanceBiz.doSignIn(new CallBack() {
            @Override
            public void onSuccess(Object result) {
                iMainView.signInSuccess();
            }

            @Override
            public void onFailed(Object msg) {
                iMainView.signInFailed();
            }
        });
    }

    /**
     * 签退
     */
    public void doSignOut() {
        attendanceBiz.doSignOut(new CallBack() {
            @Override
            public void onSuccess(Object result) {
                iMainView.signOutSuccess();
            }

            @Override
            public void onFailed(Object msg) {
                iMainView.signOutFailed();
            }
        });
    }

    /**
     * 登出
     */
    public void doLogout() {
        E_OfficeApplication.setUser(null);
        E_OfficeApplication.editor.clear();
        E_OfficeApplication.editor.commit();
        iMainView.turnToLogin();
    }
}
