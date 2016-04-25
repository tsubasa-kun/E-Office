package com.love_cookies.e_office.View.Interface;

/**
 * Created by xiekun on 2016/4/25.
 *
 * 添加通知页 View接口
 */
public interface IAddNoticeView {
    /**
     * 添加通知
     */
    void addNotice();

    /**
     * 添加成功
     */
    void addSuccess();

    /**
     * 添加失败
     * @param msg
     */
    void addFailed(String msg);
}
