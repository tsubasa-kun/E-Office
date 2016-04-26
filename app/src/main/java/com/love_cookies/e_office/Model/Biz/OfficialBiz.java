package com.love_cookies.e_office.Model.Biz;

import android.database.Cursor;

import com.love_cookies.e_office.E_OfficeApplication;
import com.love_cookies.e_office.Model.Bean.OfficialBean;
import com.love_cookies.e_office.Model.Biz.Interface.IOfficialBiz;
import com.love_cookies.e_office.View.Interface.CallBack;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiekun on 2016/4/25.
 *
 * 公文逻辑
 */
public class OfficialBiz implements IOfficialBiz {
    /**
     * 获取公文列表信息
     * @param offset
     * @param callBack
     */
    @Override
    public void getOfficial(int offset, final CallBack callBack) {
        try {
            List<OfficialBean> result = new ArrayList<>();
            OfficialBean officialBean;
            String sql = "SELECT * FROM official LIMIT 10 OFFSET " + (offset * 10);
            Cursor cursor = E_OfficeApplication.db.rawQuery(sql, null);
            while (cursor.moveToNext()) {
                officialBean = new OfficialBean();
                officialBean.setId(cursor.getInt(cursor.getColumnIndex("id")));
                officialBean.setTitle(cursor.getString(cursor.getColumnIndex("title")));
                officialBean.setContent(cursor.getString(cursor.getColumnIndex("content")));
                result.add(officialBean);
            }
            cursor.close();
            callBack.onSuccess(result);
        } catch (Exception ex) {
            callBack.onFailed(ex.getMessage());
        }
    }
}
