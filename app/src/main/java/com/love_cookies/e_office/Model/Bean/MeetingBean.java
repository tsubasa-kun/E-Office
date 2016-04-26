package com.love_cookies.e_office.Model.Bean;

/**
 * Created by xiekun on 2016/4/25 0025.
 *
 * 会议实体类
 */
public class MeetingBean {
    private int id;
    private String subject;
    private String time;
    private String nickname;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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
