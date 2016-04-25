package com.love_cookies.e_office.Model.Biz.Interface;

import com.love_cookies.cookie_library.Interface.CallBack;

/**
 * Created by xiekun on 2016/4/25.
 *
 * 添加通知逻辑接口
 */
public interface IAddNoticeBiz {
    /**
     * 添加通知
     * @param title
     * @param content
     * @param callBack
     */
    void addNotice(String title, String content, CallBack callBack);
}
