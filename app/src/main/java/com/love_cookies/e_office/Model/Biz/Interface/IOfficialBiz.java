package com.love_cookies.e_office.Model.Biz.Interface;

import com.love_cookies.cookie_library.Interface.CallBack;

/**
 * Created by xiekun on 2016/4/25.
 *
 * 公文逻辑接口
 */
public interface IOfficialBiz {
    /**
     * 获取公文列表信息
     * @param offset
     * @param callBack
     */
    void getOfficial(int offset, CallBack callBack);
}
