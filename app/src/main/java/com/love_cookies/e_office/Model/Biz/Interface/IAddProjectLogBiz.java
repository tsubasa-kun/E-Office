package com.love_cookies.e_office.Model.Biz.Interface;

import com.love_cookies.e_office.View.Interface.CallBack;

/**
 * Created by xiekun on 2016/4/23.
 *
 * 添加项目日志逻辑接口
 */
public interface IAddProjectLogBiz {
    /**
     * 添加项目日志
     * @param project_id
     * @param content
     * @param callBack
     */
    void addProjectLog(String project_id, String content, CallBack callBack);
}
