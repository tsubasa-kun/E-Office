package com.love_cookies.e_office.Model.Bean;

import cn.bmob.v3.BmobObject;

/**
 * Created by xiekun on 2016/4/21 0021.
 *
 * 通知实体类
 */
public class NoticeBean extends BmobObject {
    private String nickname;
    private String title;
    private String time;
    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
}
