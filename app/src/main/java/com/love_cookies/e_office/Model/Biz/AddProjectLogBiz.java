package com.love_cookies.e_office.Model.Biz;

import android.content.ContentValues;

import com.love_cookies.e_office.E_OfficeApplication;
import com.love_cookies.e_office.Model.Biz.Interface.IAddProjectLogBiz;
import com.love_cookies.e_office.Utils.DateTimeUtils;
import com.love_cookies.e_office.View.Interface.CallBack;

/**
 * Created by xiekun on 2016/4/23.
 *
 * 添加项目日志逻辑
 */
public class AddProjectLogBiz implements IAddProjectLogBiz {
    /**
     * 添加项目日志
     * @param project_id
     * @param content
     * @param callBack
     */
    @Override
    public void addProjectLog(String project_id, String content, final CallBack callBack) {
        try {
            ContentValues values = new ContentValues();
            values.put("project_id", project_id);
            values.put("nickname", E_OfficeApplication.user.getNickname());
            values.put("time", DateTimeUtils.getCurrentTime());
            values.put("content", content);
            E_OfficeApplication.db.insert("project_log", null, values);
            callBack.onSuccess(0);
        } catch (Exception ex) {
            callBack.onFailed(ex.getMessage());
        }
    }
}
