package com.love_cookies.e_office.View.Interface;

/**
 * Created by xiekun on 2016/4/23.
 *
 * 添加项目日志页 View接口
 */
public interface IAddProjectLogView {
    /**
     * 添加项目日志
     */
    void addProjectLog();

    /**
     * 添加成功
     */
    void addSuccess();

    /**
     * 添加失败
     * @param msg
     */
    void addFailed(String msg);
}
