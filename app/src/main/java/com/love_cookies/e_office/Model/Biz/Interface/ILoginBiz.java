package com.love_cookies.e_office.Model.Biz.Interface;

import com.love_cookies.cookie_library.Interface.CallBack;

/**
 * Created by xiekun on 2016/4/4.
 *
 * 登录逻辑接口
 */
public interface ILoginBiz {
    void doLogin(String username, String password, CallBack callBack);
}
