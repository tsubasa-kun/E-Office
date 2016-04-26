package com.love_cookies.e_office.Presenter;

import com.love_cookies.e_office.Model.Bean.AttendanceBean;
import com.love_cookies.e_office.Model.Biz.AttendanceBiz;
import com.love_cookies.e_office.View.Interface.CallBack;
import com.love_cookies.e_office.View.Interface.IAttendanceView;

import java.util.List;

/**
 * Created by xiekun on 2016/4/20 0020.
 *
 * 考勤Presenter
 */
public class AttendancePresenter {
    private AttendanceBiz attendanceBiz;
    private IAttendanceView iAttendanceView;

    public AttendancePresenter(IAttendanceView iAttendanceView) {
        attendanceBiz = new AttendanceBiz();
        this.iAttendanceView = iAttendanceView;
    }

    public void getAttendance(int offset) {
        attendanceBiz.getAttendance(offset, new CallBack() {
            @Override
            public void onSuccess(Object result) {
                iAttendanceView.setAttendance((List<AttendanceBean>)result);
            }

            @Override
            public void onFailed(Object msg) {

            }
        });
    }
}
