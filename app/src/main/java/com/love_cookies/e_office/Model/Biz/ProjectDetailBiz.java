package com.love_cookies.e_office.Model.Biz;

import com.love_cookies.cookie_library.Application.ActivityCollections;
import com.love_cookies.cookie_library.Interface.CallBack;
import com.love_cookies.e_office.Model.Bean.ProjectBean;
import com.love_cookies.e_office.Model.Bean.ProjectLogBean;
import com.love_cookies.e_office.Model.Biz.Interface.IProjectDetailBiz;

import java.util.List;

import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.listener.FindListener;
import cn.bmob.v3.listener.GetListener;

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
        BmobQuery<ProjectBean> query = new BmobQuery<>();
        query.getObject(ActivityCollections.getInstance().currentActivity(), project_id, new GetListener<ProjectBean>() {
            @Override
            public void onSuccess(ProjectBean projectBean) {
                callBack.onSuccess(projectBean);
            }

            @Override
            public void onFailure(int i, String s) {
                callBack.onFailed(s);
            }
        });
    }

    /**
     * 获取项目日志
     * @param project_id
     * @param offset
     * @param callBack
     */
    @Override
    public void getProjectLog(String project_id, int offset, final CallBack callBack) {
        BmobQuery<ProjectLogBean> query = new BmobQuery<>();
        query.addWhereEqualTo("objectId", project_id);
        query.setLimit(10);
        query.setSkip(10 * offset);
        query.findObjects(ActivityCollections.getInstance().currentActivity(), new FindListener<ProjectLogBean>() {
            @Override
            public void onSuccess(List<ProjectLogBean> list) {
                callBack.onSuccess(list);
            }

            @Override
            public void onError(int i, String s) {
                callBack.onFailed(s);
            }
        });
    }
}
