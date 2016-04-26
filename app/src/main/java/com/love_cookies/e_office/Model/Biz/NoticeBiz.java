package com.love_cookies.e_office.Model.Biz;

import android.database.Cursor;

import com.love_cookies.e_office.E_OfficeApplication;
import com.love_cookies.e_office.Model.Bean.NoticeBean;
import com.love_cookies.e_office.Model.Biz.Interface.INoticeBiz;
import com.love_cookies.e_office.View.Interface.CallBack;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiekun on 2016/4/21 0021.
 *
 * 通知逻辑
 */
public class NoticeBiz implements INoticeBiz {
    /**
     * 获取通知信息
     * @param offset
     * @param callBack
     */
    @Override
    public void getNotice(int offset, final CallBack callBack) {
        try {
            List<NoticeBean> result = new ArrayList<>();
            NoticeBean noticeBean;
            String sql = "SELECT * FROM notice ORDER BY time DESC LIMIT 10 OFFSET " + (offset * 10);
            Cursor cursor = E_OfficeApplication.db.rawQuery(sql, null);
            while (cursor.moveToNext()) {
                noticeBean = new NoticeBean();
                noticeBean.setId(cursor.getInt(cursor.getColumnIndex("id")));
                noticeBean.setNickname(cursor.getString(cursor.getColumnIndex("nickname")));
                noticeBean.setTitle(cursor.getString(cursor.getColumnIndex("title")));
                noticeBean.setTime(cursor.getString(cursor.getColumnIndex("time")));
                noticeBean.setContent(cursor.getString(cursor.getColumnIndex("content")));
                result.add(noticeBean);
            }
            cursor.close();
            callBack.onSuccess(result);
        } catch (Exception ex) {
            callBack.onFailed(ex.getMessage());
        }
    }
}
