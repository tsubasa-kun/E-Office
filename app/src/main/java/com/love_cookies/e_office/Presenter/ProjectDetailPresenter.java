package com.love_cookies.e_office.Presenter;

import com.love_cookies.cookie_library.Interface.CallBack;
import com.love_cookies.e_office.Model.Bean.ProjectBean;
import com.love_cookies.e_office.Model.Bean.ProjectLogBean;
import com.love_cookies.e_office.Model.Biz.ProjectDetailBiz;
import com.love_cookies.e_office.View.Interface.IProjectDetailView;

import java.util.List;

/**
 * Created by xiekun on 2016/4/23.
 *
 * 项目详情Presenter
 */
public class ProjectDetailPresenter {

    private ProjectDetailBiz projectDetailBiz;
    private IProjectDetailView iProjectDetailView;

    public ProjectDetailPresenter(IProjectDetailView iProjectDetailView) {
        projectDetailBiz = new ProjectDetailBiz();
        this.iProjectDetailView = iProjectDetailView;
    }

    /**
     * 获取项目详情
     * @param project_id
     */
    public void getProjectDetail(String project_id) {
        projectDetailBiz.getProjectDetail(project_id, new CallBack() {
            @Override
            public void onSuccess(Object result) {
                iProjectDetailView.setProjectDetail((ProjectBean)result);
            }

            @Override
            public void onFailed(Object msg) {

            }
        });

    }

    /**
     * 获取项目日志
     * @param project_id
     * @param offset
     */
    public void getProjectLog(String project_id, int offset) {
        projectDetailBiz.getProjectLog(project_id, offset, new CallBack() {
            @Override
            public void onSuccess(Object result) {
                iProjectDetailView.setProjectLog((List<ProjectLogBean>)result);
            }

            @Override
            public void onFailed(Object msg) {

            }
        });
    }
}
