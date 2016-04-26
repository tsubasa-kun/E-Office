package com.love_cookies.e_office.Model.Biz;

import android.database.Cursor;

import com.love_cookies.e_office.ActivityCollections;
import com.love_cookies.e_office.E_OfficeApplication;
import com.love_cookies.e_office.Model.Bean.UserBean;
import com.love_cookies.e_office.Model.Biz.Interface.ILoginBiz;
import com.love_cookies.e_office.R;
import com.love_cookies.e_office.View.Interface.CallBack;

/**
 * Created by xiekun on 2016/4/4.
 *
 * 登录逻辑
 */
public class LoginBiz implements ILoginBiz{
    /**
     * 登录
     * @param username
     * @param password
     * @param callBack
     */
    @Override
    public void doLogin(String username, String password, final CallBack callBack) {
        try {
            String sql = "SELECT * FROM user WHERE username = ? AND password = ?";
            Cursor cursor = E_OfficeApplication.db.rawQuery(sql, new String[]{username, password});
            if(cursor.moveToFirst()){
                UserBean userBean = new UserBean();
                userBean.setId(cursor.getInt(cursor.getColumnIndex("id")));
                userBean.setUsername(cursor.getString(cursor.getColumnIndex("username")));
                userBean.setNickname(cursor.getString(cursor.getColumnIndex("nickname")));
                callBack.onSuccess(userBean);
            } else {
                callBack.onFailed(ActivityCollections.getInstance().currentActivity().getResources().getString(R.string.login_failed_text));
            }
            cursor.close();
        } catch (Exception ex) {
            callBack.onFailed(ex.getMessage());
        }
    }
}
