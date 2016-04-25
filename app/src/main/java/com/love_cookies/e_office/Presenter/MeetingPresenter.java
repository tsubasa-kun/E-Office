package com.love_cookies.e_office.Presenter;

import com.love_cookies.cookie_library.Interface.CallBack;
import com.love_cookies.e_office.Model.Bean.MeetingBean;
import com.love_cookies.e_office.Model.Biz.MeetingBiz;
import com.love_cookies.e_office.View.Interface.IMeetingView;

import java.util.List;

/**
 * Created by xiekun on 2016/4/25.
 *
 * 会议Presenter
 */
public class MeetingPresenter {

    private MeetingBiz meetingBiz;
    private IMeetingView iMeetingView;

    public MeetingPresenter(IMeetingView iMeetingView) {
        meetingBiz = new MeetingBiz();
        this.iMeetingView = iMeetingView;
    }

    /**
     * 获取会议
     * @param offset
     */
    public void getMeeting(int offset) {
        meetingBiz.getMeeting(offset, new CallBack() {
            @Override
            public void onSuccess(Object result) {
                iMeetingView.setMeeting((List<MeetingBean>)result);
            }

            @Override
            public void onFailed(Object msg) {

            }
        });
    }
}
