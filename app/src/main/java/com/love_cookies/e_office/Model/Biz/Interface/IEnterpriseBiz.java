package com.love_cookies.e_office.Model.Biz.Interface;

import com.love_cookies.e_office.View.Interface.CallBack;

/**
 * Created by xiekun on 2016/4/24.
 *
 * 企业动态逻辑接口
 */
public interface IEnterpriseBiz {
    /**
     * 获取企业动态
     * @param offset
     * @param callBack
     */
    void getEnterprise(int offset, CallBack callBack);
}
