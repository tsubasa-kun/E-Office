package com.love_cookies.e_office.Model.Bean;

import cn.bmob.v3.BmobUser;

/**
 * Created by xiekun on 2016/4/4.
 *
 * 用户实体类
 */
public class UserBean extends BmobUser{
    private String nickname;

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
}
