package com.love_cookies.e_office.Model.Biz;

import android.content.ContentValues;
import android.database.Cursor;

import com.love_cookies.e_office.ActivityCollections;
import com.love_cookies.e_office.E_OfficeApplication;
import com.love_cookies.e_office.Model.Biz.Interface.IRegisterBiz;
import com.love_cookies.e_office.R;
import com.love_cookies.e_office.View.Interface.CallBack;

/**
 * Created by xiekun on 2016/4/4.
 *
 * 注册逻辑
 */
public class RegisterBiz implements IRegisterBiz {
    /**
     * 注册
     * @param username
     * @param password
     * @param nickname
     * @param callBack
     */
    @Override
    public void doRegister(String username, String password, String nickname, final CallBack callBack) {
        try {
            String sql = "SELECT * FROM user WHERE username = ?";
            Cursor cursor = E_OfficeApplication.db.rawQuery(sql, new String[]{username});
            if(cursor.moveToFirst()){
                callBack.onFailed(ActivityCollections.getInstance().currentActivity().getResources().getString(R.string.re_account_exist));
            } else {
                ContentValues values = new ContentValues();
                values.put("username", username);
                values.put("password", password);
                values.put("nickname", nickname);
                E_OfficeApplication.db.insert("user", null, values);
                callBack.onSuccess(0);
            }
            cursor.close();
        } catch (Exception ex) {
            callBack.onFailed(ex.getMessage());
        }
    }
}
