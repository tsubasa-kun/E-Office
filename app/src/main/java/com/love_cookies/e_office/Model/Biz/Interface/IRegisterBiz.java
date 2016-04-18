package com.love_cookies.e_office.Model.Biz.Interface;

import com.love_cookies.cookie_library.Interface.CallBack;

/**
 * Created by xiekun on 2016/4/4.
 *
 * 注册逻辑接口
 */
public interface IRegisterBiz {
    /**
     * 注册
     * @param username
     * @param password
     * @param nickname
     * @param callBack
     */
    void doRegister(String username, String password, String nickname, CallBack callBack);
}
