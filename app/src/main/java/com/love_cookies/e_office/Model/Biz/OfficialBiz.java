package com.love_cookies.e_office.Model.Biz;

import com.love_cookies.cookie_library.Application.ActivityCollections;
import com.love_cookies.cookie_library.Interface.CallBack;
import com.love_cookies.e_office.Model.Bean.OfficialBean;
import com.love_cookies.e_office.Model.Biz.Interface.IOfficialBiz;

import java.util.List;

import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.listener.FindListener;

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
        BmobQuery<OfficialBean> query = new BmobQuery<>();
        query.setLimit(10);
        query.setSkip(10 * offset);
        query.findObjects(ActivityCollections.getInstance().currentActivity(), new FindListener<OfficialBean>() {
            @Override
            public void onSuccess(List<OfficialBean> list) {
                callBack.onSuccess(list);
            }

            @Override
            public void onError(int i, String s) {
                callBack.onFailed(s);
            }
        });
    }
}
