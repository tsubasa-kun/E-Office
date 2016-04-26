package com.love_cookies.e_office.Model.Biz;

import com.love_cookies.e_office.ActivityCollections;
import com.love_cookies.e_office.Model.Bean.NoticeBean;
import com.love_cookies.e_office.Model.Bean.UserBean;
import com.love_cookies.e_office.Model.Biz.Interface.IAddNoticeBiz;
import com.love_cookies.e_office.Utils.DateTimeUtil;
import com.love_cookies.e_office.View.Interface.CallBack;

import cn.bmob.v3.BmobUser;
import cn.bmob.v3.listener.SaveListener;

/**
 * Created by xiekun on 2016/4/25.
 *
 * 添加通知逻辑
 */
public class AddNoticeBiz implements IAddNoticeBiz {
    /**
     * 添加通知
     * @param title
     * @param content
     * @param callBack
     */
    @Override
    public void addNotice(String title, String content, final CallBack callBack) {
        UserBean userBean = BmobUser.getCurrentUser(ActivityCollections.getInstance().currentActivity(), UserBean.class);
        NoticeBean noticeBean = new NoticeBean();
        noticeBean.setTitle(title);
        noticeBean.setNickname(userBean.getNickname());
        noticeBean.setTime(DateTimeUtil.getCurrentTime());
        noticeBean.setContent(content);
        noticeBean.save(ActivityCollections.getInstance().currentActivity(), new SaveListener() {
            @Override
            public void onSuccess() {
                callBack.onSuccess(0);
            }

            @Override
            public void onFailure(int i, String s) {
                callBack.onFailed(s);
            }
        });
    }
}
