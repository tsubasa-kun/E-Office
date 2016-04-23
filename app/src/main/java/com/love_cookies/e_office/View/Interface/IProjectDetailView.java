package com.love_cookies.e_office.View.Interface;

import com.love_cookies.e_office.Model.Bean.ProjectBean;
import com.love_cookies.e_office.Model.Bean.ProjectLogBean;

import java.util.List;

/**
 * Created by xiekun on 2016/4/23.
 *
 * 项目详情 View接口
 */
public interface IProjectDetailView {
    /**
     * 获取项目详情
     * @param project_id
     */
    void getProjectDetail(String project_id);

    /**
     * 设置项目详情
     * @param projectBean
     */
    void setProjectDetail(ProjectBean projectBean);

    /**
     * 获取项目日志
     * @param project_id
     * @param offset
     */
    void getProjectLog(String project_id, int offset);

    /**
     * 设置项目日志
     * @param projectLogs
     */
    void setProjectLog(List<ProjectLogBean> projectLogs);
}
