package com.love_cookies.e_office.Model.Biz;

import android.database.Cursor;

import com.love_cookies.e_office.E_OfficeApplication;
import com.love_cookies.e_office.Model.Bean.ProjectBean;
import com.love_cookies.e_office.Model.Biz.Interface.IProjectBiz;
import com.love_cookies.e_office.View.Interface.CallBack;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiekun on 2016/4/23.
 *
 * 项目逻辑
 */
public class ProjectBiz implements IProjectBiz {
    /**
     * 获取项目列表信息
     * @param offset
     * @param callBack
     */
    @Override
    public void getProject(int offset, final CallBack callBack) {
        try {
            List<ProjectBean> result = new ArrayList<>();
            ProjectBean projectBean;
            String sql = "SELECT * FROM project LIMIT 10 OFFSET " + (offset * 10);
            Cursor cursor = E_OfficeApplication.db.rawQuery(sql, null);
            while (cursor.moveToNext()) {
                projectBean = new ProjectBean();
                projectBean.setId(cursor.getInt(cursor.getColumnIndex("id")));
                projectBean.setTitle(cursor.getString(cursor.getColumnIndex("title")));
                projectBean.setContent(cursor.getString(cursor.getColumnIndex("content")));
                result.add(projectBean);
            }
            cursor.close();
            callBack.onSuccess(result);
        } catch (Exception ex) {
            callBack.onFailed(ex.getMessage());
        }
    }
}
