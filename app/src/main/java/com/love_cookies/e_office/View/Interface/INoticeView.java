package com.love_cookies.e_office.View.Interface;

import com.love_cookies.e_office.Model.Bean.NoticeBean;

import java.util.List;

/**
 * Created by xiekun on 2016/4/21 0021.
 *
 * 通知页 View接口
 */
public interface INoticeView {
    /**
     * 获取通知
     * @param offset
     */
    void getNotice(int offset);

    /**
     * 设置通知
     * @param notices
     */
    void setNotice(List<NoticeBean> notices);
}
