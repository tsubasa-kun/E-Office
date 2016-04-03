package com.love_cookies.e_office;

import com.love_cookies.cookie_library.Application.BaseApplication;
import com.love_cookies.e_office.Config.AppConfig;

import cn.bmob.v3.Bmob;

/**
 * Created by xiekun on 2016/4/4.
 *
 * 应用Application
 */
public class E_OfficeApplication extends BaseApplication {
    @Override
    public void onCreate() {
        super.onCreate();
        Bmob.initialize(this, AppConfig.APPID);
    }
}
