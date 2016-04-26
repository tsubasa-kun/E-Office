package com.love_cookies.e_office.Model.Biz;

import android.content.ContentValues;

import com.love_cookies.e_office.E_OfficeApplication;
import com.love_cookies.e_office.Model.Biz.Interface.IAddMeetingBiz;
import com.love_cookies.e_office.Utils.DateTimeUtils;
import com.love_cookies.e_office.View.Interface.CallBack;

/**
 * Created by xiekun on 2016/4/25.
 *
 * 添加会议逻辑
 */
public class AddMeetingBiz implements IAddMeetingBiz {
    /**
     * 添加会议
     * @param subject
     * @param time
     * @param callBack
     */
    @Override
    public void addMeeting(String subject, String time, final CallBack callBack) {
        try {
            ContentValues values = new ContentValues();
            values.put("nickname", E_OfficeApplication.user.getNickname());
            values.put("subject", subject);
            values.put("time", DateTimeUtils.getCurrentTime());
            E_OfficeApplication.db.insert("meeting", null, values);
            callBack.onSuccess(0);
        } catch (Exception ex) {
            callBack.onFailed(ex.getMessage());
        }
    }
}
