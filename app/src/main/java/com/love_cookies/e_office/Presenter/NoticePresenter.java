package com.love_cookies.e_office.Presenter;

import com.love_cookies.e_office.Model.Bean.NoticeBean;
import com.love_cookies.e_office.Model.Biz.NoticeBiz;
import com.love_cookies.e_office.View.Interface.CallBack;
import com.love_cookies.e_office.View.Interface.INoticeView;

import java.util.List;

/**
 * Created by jk on 2016/4/21 0021.
 *
 * 通知Presenter
 */
public class NoticePresenter {

    private NoticeBiz noticeBiz;
    private INoticeView iNoticeView;

    public NoticePresenter(INoticeView iNoticeView) {
        noticeBiz = new NoticeBiz();
        this.iNoticeView = iNoticeView;
    }

    /**
     * 获取通知
     * @param offset
     */
    public void getNotice(int offset) {
        noticeBiz.getNotice(offset, new CallBack() {
            @Override
            public void onSuccess(Object result) {
                iNoticeView.setNotice((List<NoticeBean>)result);
            }

            @Override
            public void onFailed(Object msg) {

            }
        });
    }
}
