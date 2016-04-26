package com.love_cookies.e_office.Model.Bean;

/**
 * Created by xiekun on 2016/4/19 0019.
 *
 * 考勤实体类
 */
public class AttendanceBean {
    private int id;
    private int user_id;
    private String sign_in;
    private String sign_out;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
}
