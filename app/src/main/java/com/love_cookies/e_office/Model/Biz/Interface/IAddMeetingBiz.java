package com.love_cookies.e_office.Model.Biz.Interface;

import com.love_cookies.e_office.View.Interface.CallBack;

/**
 * Created by xiekun on 2016/4/25.
 *
 * 添加会议逻辑接口
 */
public interface IAddMeetingBiz {
    /**
     * 添加会议
     * @param subject
     * @param time
     * @param callBack
     */
    void addMeeting(String subject, String time, CallBack callBack);
}
