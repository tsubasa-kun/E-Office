package com.love_cookies.e_office.Model.Biz;

import com.love_cookies.cookie_library.Application.ActivityCollections;
import com.love_cookies.cookie_library.Interface.CallBack;
import com.love_cookies.e_office.Model.Bean.UserBean;
import com.love_cookies.e_office.Model.Biz.Interface.ILoginBiz;

import cn.bmob.v3.listener.SaveListener;

/**
 * Created by xiekun on 2016/4/4.
 *
 * 登录逻辑
 */
public class LoginBiz implements ILoginBiz{
    @Override
    public void doLogin(String username, String password, final CallBack callBack) {
        final UserBean userBean = new UserBean();
        userBean.setUsername(username);
        userBean.setPassword(password);
        userBean.login(ActivityCollections.getInstance().currentActivity(), new SaveListener() {
            @Override
            public void onSuccess() {
                callBack.onSuccess(userBean);
            }

            @Override
            public void onFailure(int i, String s) {
                callBack.onFailed(s);
            }
        });
    }
}
