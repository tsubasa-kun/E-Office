package com.love_cookies.e_office.View.Interface;

import com.love_cookies.e_office.Model.Bean.OfficialBean;

import java.util.List;

/**
 * Created by xiekun on 2016/4/25.
 *
 * 公文页 View接口
 */
public interface IOfficialView {
    /**
     * 获取公文
     * @param offset
     */
    void getOfficial(int offset);

    /**
     * 设置公文
     * @param officials
     */
    void setOfficial(List<OfficialBean> officials);
}
