package com.love_cookies.e_office.Model.Biz;

import android.database.Cursor;

import com.love_cookies.e_office.E_OfficeApplication;
import com.love_cookies.e_office.Model.Bean.ProjectBean;
import com.love_cookies.e_office.Model.Bean.ProjectLogBean;
import com.love_cookies.e_office.Model.Biz.Interface.IProjectDetailBiz;
import com.love_cookies.e_office.View.Interface.CallBack;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiekun on 2016/4/23.
 *
 * 项目详情逻辑
 */
public class ProjectDetailBiz implements IProjectDetailBiz {
    /**
     * 获取项目详情
     * @param project_id
     * @param callBack
     */
    @Override
    public void getProjectDetail(String project_id, final CallBack callBack) {
        try {
            ProjectBean projectBean = null;
            String sql = "SELECT * FROM project WHERE id = ?";
            Cursor cursor = E_OfficeApplication.db.rawQuery(sql, new String[]{project_id});
            while (cursor.moveToNext()) {
                projectBean = new ProjectBean();
                projectBean.setId(cursor.getInt(cursor.getColumnIndex("id")));
                projectBean.setTitle(cursor.getString(cursor.getColumnIndex("title")));
                projectBean.setContent(cursor.getString(cursor.getColumnIndex("content")));
            }
            cursor.close();
            callBack.onSuccess(projectBean);
        } catch (Exception ex) {
            callBack.onFailed(ex.getMessage());
        }
    }

    /**
     * 获取项目日志
     * @param project_id
     * @param offset
     * @param callBack
     */
    @Override
    public void getProjectLog(String project_id, int offset, final CallBack callBack) {
        try {
            List<ProjectLogBean> result = new ArrayList<>();
            ProjectLogBean projectLogBean = null;
            String sql = "SELECT * FROM project_log WHERE project_id = ? ORDER BY time DESC LIMIT 10 OFFSET " + (offset * 10);
            Cursor cursor = E_OfficeApplication.db.rawQuery(sql, new String[]{project_id});
            while (cursor.moveToNext()) {
                projectLogBean = new ProjectLogBean();
                projectLogBean.setId(cursor.getInt(cursor.getColumnIndex("id")));
                projectLogBean.setNickname(cursor.getString(cursor.getColumnIndex("nickname")));
                projectLogBean.setTime(cursor.getString(cursor.getColumnIndex("time")));
                projectLogBean.setContent(cursor.getString(cursor.getColumnIndex("content")));
                result.add(projectLogBean);
            }
            cursor.close();
            callBack.onSuccess(result);
        } catch (Exception ex) {
            callBack.onFailed(ex.getMessage());
        }
    }
}
