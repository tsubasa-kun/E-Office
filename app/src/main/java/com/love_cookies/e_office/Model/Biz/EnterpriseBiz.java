package com.love_cookies.e_office.Model.Biz;

import android.database.Cursor;

import com.love_cookies.e_office.E_OfficeApplication;
import com.love_cookies.e_office.Model.Bean.EnterpriseBean;
import com.love_cookies.e_office.Model.Biz.Interface.IEnterpriseBiz;
import com.love_cookies.e_office.View.Interface.CallBack;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiekun on 2016/4/24.
 *
 * 企业动态逻辑接口
 */
public class EnterpriseBiz implements IEnterpriseBiz {
    /**
     * 获取企业动态
     * @param offset
     * @param callBack
     */
    @Override
    public void getEnterprise(int offset, final CallBack callBack) {
        try {
            List<EnterpriseBean> result = new ArrayList<>();
            EnterpriseBean enterpriseBean;
            String sql = "SELECT * FROM enterprise ORDER BY time DESC LIMIT 10 OFFSET " + (offset * 10);
            Cursor cursor = E_OfficeApplication.db.rawQuery(sql, null);
            while (cursor.moveToNext()) {
                enterpriseBean = new EnterpriseBean();
                enterpriseBean.setId(cursor.getInt(cursor.getColumnIndex("id")));
                enterpriseBean.setTitle(cursor.getString(cursor.getColumnIndex("title")));
                enterpriseBean.setTime(cursor.getString(cursor.getColumnIndex("time")));
                enterpriseBean.setContent(cursor.getString(cursor.getColumnIndex("content")));
                result.add(enterpriseBean);
            }
            cursor.close();
            callBack.onSuccess(result);
        } catch (Exception ex) {
            callBack.onFailed(ex.getMessage());
        }
    }
}
