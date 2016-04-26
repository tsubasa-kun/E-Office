package com.love_cookies.e_office.Model.Biz.Interface;

import com.love_cookies.e_office.View.Interface.CallBack;

/**
 * Created by xiekun on 2016/4/21 0021.
 *
 * 通知逻辑接口
 */
public interface INoticeBiz {
    /**
     * 获取通知信息
     * @param offset
     * @param callBack
     */
    void getNotice(int offset, CallBack callBack);
}
