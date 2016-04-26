package com.love_cookies.e_office.Model.Biz;

import android.content.Context;

import com.love_cookies.e_office.ActivityCollections;
import com.love_cookies.e_office.Model.Bean.AttendanceBean;
import com.love_cookies.e_office.Model.Bean.UserBean;
import com.love_cookies.e_office.Model.Biz.Interface.IAttendanceBiz;
import com.love_cookies.e_office.Utils.DateTimeUtil;
import com.love_cookies.e_office.View.Interface.CallBack;

import java.util.List;

import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.BmobUser;
import cn.bmob.v3.listener.FindListener;
import cn.bmob.v3.listener.SaveListener;
import cn.bmob.v3.listener.UpdateListener;

/**
 * Created by xiekun on 2016/4/19 0019.
 *
 * 考勤逻辑
 */
public class AttendanceBiz implements IAttendanceBiz{
    /**
     * 签到
     * @param callBack
     */
    @Override
    public void doSignIn(final CallBack callBack) {
        final Context context = ActivityCollections.getInstance().currentActivity();
        final UserBean userBean = BmobUser.getCurrentUser(context, UserBean.class);
        BmobQuery<AttendanceBean> query = new BmobQuery<>();
        query.addWhereEqualTo("username", userBean.getUsername());
        query.addWhereContains("sign_in", DateTimeUtil.getCurrentYear());
        query.findObjects(context, new FindListener<AttendanceBean>() {
            @Override
            public void onSuccess(List<AttendanceBean> object) {
                if (object != null && object.size() > 0) {
                    String objectId = object.get(0).getObjectId();
                    AttendanceBean attendanceBean = new AttendanceBean();
                    attendanceBean.setSign_in(DateTimeUtil.getCurrentTime());
                    attendanceBean.update(context, objectId, new UpdateListener() {
                        @Override
                        public void onSuccess() {
                            callBack.onSuccess(0);
                        }
                        @Override
                        public void onFailure(int code, String msg) {
                            callBack.onFailed(msg);
                        }
                    });
                } else {
                    AttendanceBean attendanceBean = new AttendanceBean();
                    attendanceBean.setUsername(userBean.getUsername());
                    attendanceBean.setSign_in(DateTimeUtil.getCurrentTime());
                    attendanceBean.save(context, new SaveListener() {
                        @Override
                        public void onSuccess() {
                            callBack.onSuccess(0);
                        }
                        @Override
                        public void onFailure(int code, String msg) {
                            callBack.onFailed(msg);
                        }
                    });
                }
            }
            @Override
            public void onError(int code, String msg) {
                AttendanceBean attendanceBean = new AttendanceBean();
                attendanceBean.setUsername(userBean.getUsername());
                attendanceBean.setSign_in(DateTimeUtil.getCurrentTime());
                attendanceBean.save(context, new SaveListener() {
                    @Override
                    public void onSuccess() {
                        callBack.onSuccess(0);
                    }
                    @Override
                    public void onFailure(int code, String msg) {
                        callBack.onFailed(msg);
                    }
                });
            }
        });
    }

    /**
     * 签退
     * @param callBack
     */
    @Override
    public void doSignOut(final CallBack callBack) {
        final Context context = ActivityCollections.getInstance().currentActivity();
        final UserBean userBean = BmobUser.getCurrentUser(context, UserBean.class);
        BmobQuery<AttendanceBean> query = new BmobQuery<AttendanceBean>();
        query.addWhereEqualTo("username", userBean.getUsername());
        query.addWhereContains("sign_in", DateTimeUtil.getCurrentYear());
        query.findObjects(context, new FindListener<AttendanceBean>() {
            @Override
            public void onSuccess(List<AttendanceBean> object) {
                if (object != null && object.size() > 0) {
                    String objectId = object.get(0).getObjectId();
                    AttendanceBean attendanceBean = new AttendanceBean();
                    attendanceBean.setSign_out(DateTimeUtil.getCurrentTime());
                    attendanceBean.update(context, objectId, new UpdateListener() {
                        @Override
                        public void onSuccess() {
                            callBack.onSuccess(0);
                        }
                        @Override
                        public void onFailure(int code, String msg) {
                            callBack.onFailed(msg);
                        }
                    });
                } else {
                    AttendanceBean attendanceBean = new AttendanceBean();
                    attendanceBean.setUsername(userBean.getUsername());
                    attendanceBean.setSign_out(DateTimeUtil.getCurrentTime());
                    attendanceBean.save(context, new SaveListener() {
                        @Override
                        public void onSuccess() {
                            callBack.onSuccess(0);
                        }
                        @Override
                        public void onFailure(int code, String msg) {
                            callBack.onFailed(msg);
                        }
                    });
                }
            }
            @Override
            public void onError(int code, String msg) {
                AttendanceBean attendanceBean = new AttendanceBean();
                attendanceBean.setUsername(userBean.getUsername());
                attendanceBean.setSign_out(DateTimeUtil.getCurrentTime());
                attendanceBean.save(context, new SaveListener() {
                    @Override
                    public void onSuccess() {
                        callBack.onSuccess(0);
                    }
                    @Override
                    public void onFailure(int code, String msg) {
                        callBack.onFailed(msg);
                    }
                });
            }
        });
    }

    /**
     * 获取考勤信息
     * @param offset
     * @param callBack
     */
    @Override
    public void getAttendance(int offset, final CallBack callBack) {
        BmobQuery<AttendanceBean> query = new BmobQuery<>();
        UserBean userBean = BmobUser.getCurrentUser(ActivityCollections.getInstance().currentActivity(), UserBean.class);
        query.addWhereEqualTo("username", userBean.getUsername());
        query.setLimit(10);
        query.setSkip(10 * offset);
        query.order("-sign_in");
        query.findObjects(ActivityCollections.getInstance().currentActivity(), new FindListener<AttendanceBean>() {
            @Override
            public void onSuccess(List<AttendanceBean> list) {
                callBack.onSuccess(list);
            }

            @Override
            public void onError(int i, String s) {
                callBack.onFailed(s);
            }
        });
    }
}
