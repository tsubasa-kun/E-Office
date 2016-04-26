package com.love_cookies.e_office.Model.Biz;

import android.content.ContentValues;

import com.love_cookies.e_office.E_OfficeApplication;
import com.love_cookies.e_office.Model.Biz.Interface.IAddNoticeBiz;
import com.love_cookies.e_office.Utils.DateTimeUtils;
import com.love_cookies.e_office.View.Interface.CallBack;

/**
 * Created by xiekun on 2016/4/25.
 *
 * 添加通知逻辑
 */
public class AddNoticeBiz implements IAddNoticeBiz {
    /**
     * 添加通知
     * @param title
     * @param content
     * @param callBack
     */
    @Override
    public void addNotice(String title, String content, final CallBack callBack) {
        try {
            ContentValues values = new ContentValues();
            values.put("nickname", E_OfficeApplication.user.getNickname());
            values.put("title", title);
            values.put("time", DateTimeUtils.getCurrentTime());
            values.put("content", content);
            E_OfficeApplication.db.insert("notice", null, values);
            callBack.onSuccess(0);
        } catch (Exception ex) {
            callBack.onFailed(ex.getMessage());
        }
    }
}
