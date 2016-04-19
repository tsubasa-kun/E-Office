package com.love_cookies.e_office.Model.Bean;

import cn.bmob.v3.BmobObject;

/**
 * Created by xiekun on 2016/4/19 0019.
 *
 * 考勤实体类
 */
public class AttendanceBean extends BmobObject {
    private String username;
    private String sign_in;
    private String sign_out;

    public String getSign_in() {
        return sign_in;
    }

    public void setSign_in(String sign_in) {
        this.sign_in = sign_in;
    }

    public String getSign_out() {
        return sign_out;
    }

    public void setSign_out(String sign_out) {
        this.sign_out = sign_out;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
