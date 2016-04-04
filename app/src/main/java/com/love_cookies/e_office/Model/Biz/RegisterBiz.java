package com.love_cookies.e_office.Model.Biz;

import com.love_cookies.cookie_library.Application.ActivityCollections;
import com.love_cookies.cookie_library.Interface.CallBack;
import com.love_cookies.e_office.Model.Bean.UserBean;
import com.love_cookies.e_office.Model.Biz.Interface.IRegisterBiz;

import cn.bmob.v3.listener.SaveListener;

/**
 * Created by xiekun on 2016/4/4.
 *
 * 注册逻辑
 */
public class RegisterBiz implements IRegisterBiz {
    @Override
    public void doRegister(String username, String password, String nickname, final CallBack callBack) {
        final UserBean userBean = new UserBean();
        userBean.setUsername(username);
        userBean.setPassword(password);
        userBean.setNickname(nickname);
        userBean.signUp(ActivityCollections.getInstance().currentActivity(), new SaveListener() {
            @Override
            public void onSuccess() {
                callBack.getSuccess(userBean);
            }

            @Override
            public void onFailure(int i, String s) {
                callBack.getFailed(s);
            }
        });
    }
}
