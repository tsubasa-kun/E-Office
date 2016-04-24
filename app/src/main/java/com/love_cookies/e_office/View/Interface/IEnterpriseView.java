package com.love_cookies.e_office.View.Interface;

import com.love_cookies.e_office.Model.Bean.EnterpriseBean;

import java.util.List;

/**
 * Created by xiekun on 2016/4/24.
 *
 * 企业动态页 View接口
 */
public interface IEnterpriseView {
    /**
     * 获取企业动态
     * @param offset
     */
    void getEnterprise(int offset);

    /**
     * 设置企业动态
     * @param enterprises
     */
    void setEnterprise(List<EnterpriseBean> enterprises);
}
