package com.love_cookies.e_office.Model.Biz.Interface;

import com.love_cookies.e_office.View.Interface.CallBack;

/**
 * Created by xiekun on 2016/4/19 0019.
 *
 * 考勤逻辑接口
 */
public interface IAttendanceBiz {
    /**
     * 签到
     * @param callBack
     */
    void doSignIn(CallBack callBack);

    /**
     * 签退
     * @param callBack
     */
    void doSignOut(CallBack callBack);

    /**
     * 获取考勤信息
     * @param offset
     * @param callBack
     */
    void getAttendance(int offset, CallBack callBack);
}
