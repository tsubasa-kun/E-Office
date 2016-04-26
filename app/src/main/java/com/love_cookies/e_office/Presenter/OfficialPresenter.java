package com.love_cookies.e_office.Presenter;

import com.love_cookies.e_office.Model.Bean.OfficialBean;
import com.love_cookies.e_office.Model.Biz.OfficialBiz;
import com.love_cookies.e_office.View.Interface.CallBack;
import com.love_cookies.e_office.View.Interface.IOfficialView;

import java.util.List;

/**
 * Created by xiekun on 2016/4/25.
 *
 * 公文Presenter
 */
public class OfficialPresenter {

    private OfficialBiz officialBiz;
    private IOfficialView iOfficialView;

    public OfficialPresenter(IOfficialView iOfficialView) {
        officialBiz = new OfficialBiz();
        this.iOfficialView = iOfficialView;
    }

    /**
     * 获取公文
     * @param offset
     */
    public void getOfficial(int offset) {
        officialBiz.getOfficial(offset, new CallBack() {
            @Override
            public void onSuccess(Object result) {
                iOfficialView.setOfficial((List<OfficialBean>)result);
            }

            @Override
            public void onFailed(Object msg) {

            }
        });
    }
}
