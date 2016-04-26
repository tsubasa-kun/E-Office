package com.love_cookies.e_office.Model.Biz;

import com.love_cookies.e_office.ActivityCollections;
import com.love_cookies.e_office.Model.Bean.ProjectBean;
import com.love_cookies.e_office.Model.Biz.Interface.IProjectBiz;
import com.love_cookies.e_office.View.Interface.CallBack;

import java.util.List;

import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.listener.FindListener;

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
        BmobQuery<ProjectBean> query = new BmobQuery<>();
        query.setLimit(10);
        query.setSkip(10 * offset);
        query.findObjects(ActivityCollections.getInstance().currentActivity(), new FindListener<ProjectBean>() {
            @Override
            public void onSuccess(List<ProjectBean> list) {
                callBack.onSuccess(list);
            }

            @Override
            public void onError(int i, String s) {
                callBack.onFailed(s);
            }
        });
    }
}
