package com.love_cookies.e_office;

import com.love_cookies.cookie_library.Application.BaseApplication;
import com.love_cookies.cookie_library.Utils.SPUtils;
import com.love_cookies.e_office.Config.AppConfig;
import com.love_cookies.e_office.Utils.DateTimeUtil;

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
        if (!((String)SPUtils.get(this, "date", "1992-02-12")).contains(DateTimeUtil.getCurrentYear())) {
            SPUtils.put(this, "sign_in", false);
        }
    }
}
