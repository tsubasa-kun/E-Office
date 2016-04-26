package com.love_cookies.e_office.Model.Biz;

import com.love_cookies.e_office.ActivityCollections;
import com.love_cookies.e_office.Model.Bean.ProjectLogBean;
import com.love_cookies.e_office.Model.Bean.UserBean;
import com.love_cookies.e_office.Model.Biz.Interface.IAddProjectLogBiz;
import com.love_cookies.e_office.Utils.DateTimeUtils;
import com.love_cookies.e_office.View.Interface.CallBack;

import cn.bmob.v3.BmobUser;
import cn.bmob.v3.listener.SaveListener;

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
        UserBean userBean = BmobUser.getCurrentUser(ActivityCollections.getInstance().currentActivity(), UserBean.class);
        ProjectLogBean projectLogBean = new ProjectLogBean();
        projectLogBean.setProject_id(project_id);
        projectLogBean.setNickname(userBean.getNickname());
        projectLogBean.setContent(content);
        projectLogBean.setTime(DateTimeUtils.getCurrentTime());
        projectLogBean.save(ActivityCollections.getInstance().currentActivity(), new SaveListener() {
            @Override
            public void onSuccess() {
                callBack.onSuccess(0);
            }

            @Override
            public void onFailure(int i, String s) {
                callBack.onFailed(s);
            }
        });
    }
}
