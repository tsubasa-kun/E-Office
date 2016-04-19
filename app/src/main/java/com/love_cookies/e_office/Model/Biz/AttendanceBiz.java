package com.love_cookies.e_office.Model.Biz;

import com.love_cookies.cookie_library.Interface.CallBack;
import com.love_cookies.e_office.Model.Biz.Interface.IAttendanceBiz;

/**
 * Created by xiekun on 2016/4/19 0019.
 *
 * 考勤逻辑
 */
public class AttendanceBiz implements IAttendanceBiz{
    /**
     * 签到
     * @param callBack
     */
    @Override
    public void doSignIn(CallBack callBack) {
        callBack.onSuccess(0);
    }

    /**
     * 签退
     * @param callBack
     */
    @Override
    public void doSignOut(CallBack callBack) {
        callBack.onSuccess(0);
    }

    /**
     * 获取考勤信息
     * @param callBack
     */
    @Override
    public void getAttendance(CallBack callBack) {

    }
}
