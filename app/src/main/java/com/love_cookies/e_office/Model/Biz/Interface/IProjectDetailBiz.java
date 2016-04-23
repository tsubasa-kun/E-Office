package com.love_cookies.e_office.Model.Biz.Interface;

import com.love_cookies.cookie_library.Interface.CallBack;

/**
 * Created by xiekun on 2016/4/23.
 *
 * 项目详情逻辑接口
 */
public interface IProjectDetailBiz {
    /**
     * 获取项目详情
     * @param project_id
     * @param callBack
     */
    void getProjectDetail(String project_id, CallBack callBack);

    /**
     * 获取项目日志
     * @param project_id
     * @param offset
     * @param callBack
     */
    void getProjectLog(String project_id, int offset, CallBack callBack);
}
