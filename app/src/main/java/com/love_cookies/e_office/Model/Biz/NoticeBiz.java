package com.love_cookies.e_office.Model.Biz;

import com.love_cookies.cookie_library.Application.ActivityCollections;
import com.love_cookies.cookie_library.Interface.CallBack;
import com.love_cookies.e_office.Model.Bean.NoticeBean;
import com.love_cookies.e_office.Model.Biz.Interface.INoticeBiz;

import java.util.List;

import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.listener.FindListener;

/**
 * Created by xiekun on 2016/4/21 0021.
 *
 * 通知逻辑
 */
public class NoticeBiz implements INoticeBiz {
    /**
     * 获取通知信息
     * @param offset
     * @param callBack
     */
    @Override
    public void getNotice(int offset, final CallBack callBack) {
        BmobQuery<NoticeBean> query = new BmobQuery<>();
        query.setLimit(10);
        query.setSkip(10 * offset);
        query.order("-time");
        query.findObjects(ActivityCollections.getInstance().currentActivity(), new FindListener<NoticeBean>() {
            @Override
            public void onSuccess(List<NoticeBean> list) {
                callBack.onSuccess(list);
            }

            @Override
            public void onError(int i, String s) {
                callBack.onFailed(s);
            }
        });
    }
}
