package com.love_cookies.e_office.Presenter;

import com.love_cookies.cookie_library.Interface.CallBack;
import com.love_cookies.e_office.Model.Biz.AddNoticeBiz;
import com.love_cookies.e_office.View.Interface.IAddNoticeView;

/**
 * Created by xiekun on 2016/4/25.
 *
 * 添加通知Presenter
 */
public class AddNoticePresenter {

    private AddNoticeBiz addNoticeBiz;
    private IAddNoticeView iAddNoticeView;

    public AddNoticePresenter(IAddNoticeView iAddNoticeView) {
        addNoticeBiz = new AddNoticeBiz();
        this.iAddNoticeView = iAddNoticeView;
    }

    /**
     * 添加通知
     * @param title
     * @param content
     */
    public void addNotice(String title, String content) {
        addNoticeBiz.addNotice(title, content, new CallBack() {
            @Override
            public void onSuccess(Object result) {
                iAddNoticeView.addSuccess();
            }

            @Override
            public void onFailed(Object msg) {
                iAddNoticeView.addFailed((String)msg);
            }
        });
    }
}
