package com.love_cookies.e_office.View.Interface;

import com.love_cookies.e_office.Model.Bean.AttendanceBean;

import java.util.List;

/**
 * Created by xiekun on 2016/4/20 0020.
 *
 * 考勤页 View接口
 */
public interface IAttendanceView {
    /**
     * 获取考勤列表
     * @param offset
     */
    void getAttendance(int offset);

    /**
     * 设置考勤列表
     * @param attendances
     */
    void setAttendance(List<AttendanceBean> attendances);
}
