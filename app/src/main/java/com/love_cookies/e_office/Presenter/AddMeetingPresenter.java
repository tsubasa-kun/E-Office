package com.love_cookies.e_office.Presenter;

import com.love_cookies.cookie_library.Interface.CallBack;
import com.love_cookies.e_office.Model.Biz.AddMeetingBiz;
import com.love_cookies.e_office.View.Interface.IAddMeetingView;

/**
 * Created by xiekun on 2016/4/25.
 *
 * 添加会议Presenter
 */
public class AddMeetingPresenter {

    private AddMeetingBiz addMeetingBiz;
    private IAddMeetingView iAddMeetingView;

    public AddMeetingPresenter(IAddMeetingView iAddMeetingView) {
        addMeetingBiz = new AddMeetingBiz();
        this.iAddMeetingView = iAddMeetingView;
    }

    /**
     * 添加会议
     * @param subject
     * @param time
     */
    public void addMeeting(String subject, String time) {
        addMeetingBiz.addMeeting(subject, time, new CallBack() {
            @Override
            public void onSuccess(Object result) {
                iAddMeetingView.addSuccess();
            }

            @Override
            public void onFailed(Object msg) {
                iAddMeetingView.addFailed((String)msg);
            }
        });
    }
}
