package com.love_cookies.e_office.Model.Biz;

import android.database.Cursor;

import com.love_cookies.e_office.E_OfficeApplication;
import com.love_cookies.e_office.Model.Bean.MeetingBean;
import com.love_cookies.e_office.Model.Biz.Interface.IMeetingBiz;
import com.love_cookies.e_office.View.Interface.CallBack;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiekun on 2016/4/25.
 *
 * 会议逻辑
 */
public class MeetingBiz implements IMeetingBiz {
    /**
     * 获取公文列表信息
     * @param offset
     * @param callBack
     */
    @Override
    public void getMeeting(int offset, final CallBack callBack) {
        try {
            List<MeetingBean> result = new ArrayList<>();
            MeetingBean meetingBean;
            String sql = "SELECT * FROM meeting ORDER BY time DESC LIMIT 10 OFFSET " + (offset * 10);
            Cursor cursor = E_OfficeApplication.db.rawQuery(sql, null);
            while (cursor.moveToNext()) {
                meetingBean = new MeetingBean();
                meetingBean.setId(cursor.getInt(cursor.getColumnIndex("id")));
                meetingBean.setSubject(cursor.getString(cursor.getColumnIndex("subject")));
                meetingBean.setTime(cursor.getString(cursor.getColumnIndex("time")));
                meetingBean.setNickname(cursor.getString(cursor.getColumnIndex("nickname")));
                result.add(meetingBean);
            }
            cursor.close();
            callBack.onSuccess(result);
        } catch (Exception ex) {
            callBack.onFailed(ex.getMessage());
        }
    }
}
