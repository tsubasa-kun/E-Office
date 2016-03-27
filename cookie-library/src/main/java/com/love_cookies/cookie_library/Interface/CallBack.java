package com.love_cookies.cookie_library.Interface;

/**
 * Created by xiekun on 2016/3/27.
 *
 * 回调
 */
public interface CallBack<T> {
    void getSuccess(T result);
    void getFailed(String msg);
}
