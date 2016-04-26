package com.love_cookies.e_office.Model.Biz;

import com.love_cookies.e_office.ActivityCollections;
import com.love_cookies.e_office.Model.Bean.EnterpriseBean;
import com.love_cookies.e_office.Model.Biz.Interface.IEnterpriseBiz;
import com.love_cookies.e_office.View.Interface.CallBack;

import java.util.List;

import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.listener.FindListener;

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
        BmobQuery<EnterpriseBean> query = new BmobQuery<>();
        query.setLimit(10);
        query.setSkip(10 * offset);
        query.order("-time");
        query.findObjects(ActivityCollections.getInstance().currentActivity(), new FindListener<EnterpriseBean>() {
            @Override
            public void onSuccess(List<EnterpriseBean> list) {
                callBack.onSuccess(list);
            }

            @Override
            public void onError(int i, String s) {
                callBack.onFailed(s);
            }
        });
    }
}
