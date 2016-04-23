package com.love_cookies.e_office.View.Interface;

import com.love_cookies.e_office.Model.Bean.ProjectBean;

import java.util.List;

/**
 * Created by xiekun on 2016/4/23.
 *
 * 项目页 View接口
 */
public interface IProjectView {
    /**
     * 获取项目
     * @param offset
     */
    void getProject(int offset);

    /**
     * 设置项目信息
     * @param projects
     */
    void setProject(List<ProjectBean> projects);
}
