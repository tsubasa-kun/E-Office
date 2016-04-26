package com.love_cookies.e_office.Model.Biz;

import com.love_cookies.e_office.ActivityCollections;
import com.love_cookies.e_office.Model.Bean.MeetingBean;
import com.love_cookies.e_office.Model.Bean.UserBean;
import com.love_cookies.e_office.Model.Biz.Interface.IAddMeetingBiz;
import com.love_cookies.e_office.View.Interface.CallBack;

import cn.bmob.v3.BmobUser;
import cn.bmob.v3.listener.SaveListener;

/**
 * Created by xiekun on 2016/4/25.
 *
 * 添加会议逻辑
 */
public class AddMeetingBiz implements IAddMeetingBiz {
    /**
     * 添加会议
     * @param subject
     * @param time
     * @param callBack
     */
    @Override
    public void addMeeting(String subject, String time, final CallBack callBack) {
        UserBean userBean = BmobUser.getCurrentUser(ActivityCollections.getInstance().currentActivity(), UserBean.class);
        MeetingBean meetingBean = new MeetingBean();
        meetingBean.setSubject(subject);
        meetingBean.setTime(time);
        meetingBean.setNickname(userBean.getNickname());
        meetingBean.save(ActivityCollections.getInstance().currentActivity(), new SaveListener() {
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
