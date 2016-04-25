package com.love_cookies.e_office.Model.Biz.Interface;

import com.love_cookies.cookie_library.Interface.CallBack;

/**
 * Created by xiekun on 2016/4/25.
 *
 * 会议逻辑接口
 */
public interface IMeetingBiz {
    /**
     * 获取会议列表信息
     * @param offset
     * @param callBack
     */
    void getMeeting(int offset, CallBack callBack);
}
