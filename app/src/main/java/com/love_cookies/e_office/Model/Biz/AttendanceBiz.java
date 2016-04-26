package com.love_cookies.e_office.Model.Biz;

import android.content.ContentValues;
import android.database.Cursor;

import com.love_cookies.e_office.E_OfficeApplication;
import com.love_cookies.e_office.Model.Bean.AttendanceBean;
import com.love_cookies.e_office.Model.Biz.Interface.IAttendanceBiz;
import com.love_cookies.e_office.Utils.DateTimeUtils;
import com.love_cookies.e_office.View.Interface.CallBack;

import java.util.ArrayList;
import java.util.List;

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
    public void doSignIn(final CallBack callBack) {
        try {
            String sql = "SELECT * FROM attendance WHERE user_id = ? AND sign_in LIKE ?";
            Cursor cursor = E_OfficeApplication.db.rawQuery(sql, new String[]{E_OfficeApplication.user.getId() + "", "%" + DateTimeUtils.getCurrentYear() + "%"});
            if(cursor.moveToFirst()){
                ContentValues values = new ContentValues();
                values.put("sign_in", DateTimeUtils.getCurrentTime());
                E_OfficeApplication.db.update("attendance", values, "id = ?", new String[]{cursor.getInt(cursor.getColumnIndex("id")) + ""});
                callBack.onSuccess(0);
            } else {
                ContentValues values = new ContentValues();
                values.put("user_id", E_OfficeApplication.user.getId());
                values.put("sign_in", DateTimeUtils.getCurrentTime());
                E_OfficeApplication.db.insert("attendance", null, values);
                callBack.onSuccess(0);
            }
            cursor.close();
        } catch (Exception ex) {
            callBack.onFailed(ex.getMessage());
        }
    }

    /**
     * 签退
     * @param callBack
     */
    @Override
    public void doSignOut(final CallBack callBack) {
        try {
            String sql = "SELECT * FROM attendance WHERE user_id = ? AND sign_in LIKE ?";
            Cursor cursor = E_OfficeApplication.db.rawQuery(sql, new String[]{E_OfficeApplication.user.getId() + "", "%" + DateTimeUtils.getCurrentYear() + "%"});
            if(cursor.moveToFirst()){
                ContentValues values = new ContentValues();
                values.put("sign_out", DateTimeUtils.getCurrentTime());
                E_OfficeApplication.db.update("attendance", values, "id = ?", new String[]{cursor.getInt(cursor.getColumnIndex("id")) + ""});
                callBack.onSuccess(0);
            } else {
                ContentValues values = new ContentValues();
                values.put("user_id", E_OfficeApplication.user.getId());
                values.put("sign_out", DateTimeUtils.getCurrentTime());
                E_OfficeApplication.db.insert("attendance", null, values);
                callBack.onSuccess(0);
            }
            cursor.close();
        } catch (Exception ex) {
            callBack.onFailed(ex.getMessage());
        }
    }

    /**
     * 获取考勤信息
     * @param offset
     * @param callBack
     */
    @Override
    public void getAttendance(int offset, final CallBack callBack) {
        try {
            List<AttendanceBean> result = new ArrayList<>();
            AttendanceBean attendanceBean;
            String sql = "SELECT * FROM attendance WHERE user_id = ? ORDER BY sign_in DESC LIMIT 10 OFFSET " + (offset * 10);
            Cursor cursor = E_OfficeApplication.db.rawQuery(sql, new String[]{E_OfficeApplication.user.getId() + ""});
            while (cursor.moveToNext()) {
                attendanceBean = new AttendanceBean();
                attendanceBean.setId(cursor.getInt(cursor.getColumnIndex("id")));
                attendanceBean.setUser_id(cursor.getInt(cursor.getColumnIndex("user_id")));
                attendanceBean.setSign_in(cursor.getString(cursor.getColumnIndex("sign_in")));
                attendanceBean.setSign_out(cursor.getString(cursor.getColumnIndex("sign_out")));
                result.add(attendanceBean);
            }
            cursor.close();
            callBack.onSuccess(result);
        } catch (Exception ex) {
            callBack.onFailed(ex.getMessage());
        }
    }
}
