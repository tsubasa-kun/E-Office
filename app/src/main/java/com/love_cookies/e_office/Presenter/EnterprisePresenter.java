package com.love_cookies.e_office.Presenter;

import com.love_cookies.cookie_library.Interface.CallBack;
import com.love_cookies.e_office.Model.Bean.EnterpriseBean;
import com.love_cookies.e_office.Model.Biz.EnterpriseBiz;
import com.love_cookies.e_office.View.Interface.IEnterpriseView;

import java.util.List;

/**
 * Created by xiekun on 2016/4/24.
 *
 * 企业动态Presenter
 */
public class EnterprisePresenter {

    private EnterpriseBiz enterpriseBiz;
    private IEnterpriseView iEnterpriseView;

    public EnterprisePresenter(IEnterpriseView iEnterpriseView) {
        enterpriseBiz = new EnterpriseBiz();
        this.iEnterpriseView = iEnterpriseView;
    }

    /**
     * 获取企业动态
     * @param offset
     */
    public void getEnterprise(int offset) {
        enterpriseBiz.getEnterprise(offset, new CallBack() {
            @Override
            public void onSuccess(Object result) {
                iEnterpriseView.setEnterprise((List<EnterpriseBean>)result);
            }

            @Override
            public void onFailed(Object msg) {

            }
        });
    }
}
