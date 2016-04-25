package com.love_cookies.e_office.View.Interface;

/**
 * Created by xiekun on 2016/4/25.
 *
 * 添加会议页 View接口
 */
public interface IAddMeetingView {
    /**
     * 添加会议
     */
    void addMeeting();

    /**
     * 添加成功
     */
    void addSuccess();

    /**
     * 添加失败
     * @param msg
     */
    void addFailed(String msg);
}
