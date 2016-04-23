package com.love_cookies.e_office.Presenter;

import com.love_cookies.cookie_library.Interface.CallBack;
import com.love_cookies.e_office.Model.Biz.AddProjectLogBiz;
import com.love_cookies.e_office.View.Interface.IAddProjectLogView;

/**
 * Created by xiekun on 2016/4/23.
 *
 * 添加项目日志Presenter
 */
public class AddProjectLogPresenter {

    private AddProjectLogBiz addProjectLogBiz;
    private IAddProjectLogView iAddProjectLogView;

    public AddProjectLogPresenter(IAddProjectLogView iAddProjectLogView) {
        addProjectLogBiz = new AddProjectLogBiz();
        this.iAddProjectLogView = iAddProjectLogView;
    }

    /**
     * 添加项目日志
     * @param project_id
     * @param content
     */
    public void addProjectLog(String project_id, String content) {
        addProjectLogBiz.addProjectLog(project_id, content, new CallBack() {
            @Override
            public void onSuccess(Object result) {
                iAddProjectLogView.addSuccess();
            }

            @Override
            public void onFailed(Object msg) {
                iAddProjectLogView.addFailed((String)msg);
            }
        });
    }
}
