package com.love_cookies.e_office.View.Interface;

import com.love_cookies.e_office.Model.Bean.MeetingBean;

import java.util.List;

/**
 * Created by xiekun on 2016/4/25.
 *
 * 会议页 View接口
 */
public interface IMeetingView {
    /**
     * 获取会议
     * @param offset
     */
    void getMeeting(int offset);

    /**
     * 设置会议
     * @param meetings
     */
    void setMeeting(List<MeetingBean> meetings);
}
