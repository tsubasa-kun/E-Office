package com.love_cookies.e_office.Presenter;

import com.love_cookies.cookie_library.Interface.CallBack;
import com.love_cookies.e_office.Model.Bean.ProjectBean;
import com.love_cookies.e_office.Model.Biz.ProjectBiz;
import com.love_cookies.e_office.View.Interface.IProjectView;

import java.util.List;

/**
 * Created by xiekun on 2016/4/23.
 *
 * 项目Presenter
 */
public class ProjectPresenter {

    private ProjectBiz projectBiz;
    private IProjectView iProjectView;

    public ProjectPresenter(IProjectView iProjectView) {
        projectBiz = new ProjectBiz();
        this.iProjectView = iProjectView;
    }

    /**
     * 获取项目
     * @param offset
     */
    public void getProject(int offset) {
        projectBiz.getProject(offset, new CallBack() {
            @Override
            public void onSuccess(Object result) {
                iProjectView.setProject((List<ProjectBean>)result);
            }

            @Override
            public void onFailed(Object msg) {

            }
        });
    }
}
