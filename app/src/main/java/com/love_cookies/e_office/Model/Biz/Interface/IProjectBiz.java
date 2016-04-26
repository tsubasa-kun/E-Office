package com.love_cookies.e_office.Model.Biz.Interface;

import com.love_cookies.e_office.View.Interface.CallBack;

/**
 * Created by xiekun on 2016/4/23.
 *
 * 项目逻辑接口
 */
public interface IProjectBiz {
    /**
     * 获取项目列表信息
     * @param offset
     * @param callBack
     */
    void getProject(int offset, CallBack callBack);
}
