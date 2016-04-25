package com.love_cookies.e_office.Model.Bean;

import cn.bmob.v3.BmobObject;

/**
 * Created by xiekun on 2016/4/25 0025.
 *
 * 会议实体类
 */
public class MeetingBean extends BmobObject {
    private String subject;
    private String time;
    private String nickname;

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
