package com.love_cookies.e_office.Model.Biz;

import com.love_cookies.cookie_library.Application.ActivityCollections;
import com.love_cookies.cookie_library.Interface.CallBack;
import com.love_cookies.e_office.Model.Bean.MeetingBean;
import com.love_cookies.e_office.Model.Biz.Interface.IMeetingBiz;

import java.util.List;

import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.listener.FindListener;

/**
 * Created by xiekun on 2016/4/25.
 *
 * 会议逻辑
 */
public class MeetingBiz implements IMeetingBiz {
    /**
     * 获取公文列表信息
     * @param offset
     * @param callBack
     */
    @Override
    public void getMeeting(int offset, final CallBack callBack) {
        BmobQuery<MeetingBean> query = new BmobQuery<>();
        query.setLimit(10);
        query.setSkip(10 * offset);
        query.order("-time");
        query.findObjects(ActivityCollections.getInstance().currentActivity(), new FindListener<MeetingBean>() {
            @Override
            public void onSuccess(List<MeetingBean> list) {
                callBack.onSuccess(list);
            }

            @Override
            public void onError(int i, String s) {
                callBack.onFailed(s);
            }
        });
    }
}
