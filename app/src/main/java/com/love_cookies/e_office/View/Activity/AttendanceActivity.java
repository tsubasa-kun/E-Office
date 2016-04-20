package com.love_cookies.e_office.View.Activity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.love_cookies.cookie_library.Activity.BaseActivity;
import com.love_cookies.cookie_library.Widget.LoadAndRefreshView;
import com.love_cookies.e_office.Model.Bean.AttendanceBean;
import com.love_cookies.e_office.Presenter.AttendancePresenter;
import com.love_cookies.e_office.R;
import com.love_cookies.e_office.View.Adapter.AttendanceAdapter;
import com.love_cookies.e_office.View.Interface.IAttendanceView;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiekun on 2016/4/18.
 *
 * 出勤页
 */
@ContentView(R.layout.activity_attendance)
public class AttendanceActivity extends BaseActivity implements IAttendanceView, LoadAndRefreshView.OnHeaderRefreshListener, LoadAndRefreshView.OnFooterRefreshListener {
    @ViewInject(R.id.title_tv)
    private TextView titleTV;
    @ViewInject(R.id.left_btn)
    private ImageView leftBtn;
    @ViewInject(R.id.load_and_refresh_view)
    private LoadAndRefreshView loadAndRefreshView;
    @ViewInject(R.id.attendance_list)
    private ListView attendanceList;
    private View listHearderView;

    private AttendanceAdapter attendanceAdapter;
    private List<AttendanceBean> datas = new ArrayList<>();

    private int offset = 0;

    private AttendancePresenter attendancePresenter = new AttendancePresenter(this);

    /**
     * 初始化控件
     * @param savedInstanceState
     */
    @Override
    public void initWidget(Bundle savedInstanceState) {
        titleTV.setText(R.string.attendance_title);
        leftBtn.setImageResource(R.mipmap.title_btn_back);
        leftBtn.setOnClickListener(this);
        attendanceAdapter = new AttendanceAdapter(this, datas);
        listHearderView = LayoutInflater.from(this).inflate(R.layout.view_attendance_list_header, attendanceList, false);
        attendanceList.addHeaderView(listHearderView);
        attendanceList.setAdapter(attendanceAdapter);
        loadAndRefreshView.setOnHeaderRefreshListener(this);
        loadAndRefreshView.setOnFooterRefreshListener(this);
        getAttendance(offset);
    }

    /**
     * 控件点击事件
     * @param view
     */
    @Override
    public void widgetClick(View view) {
        switch (view.getId()) {
            case R.id.left_btn:
                finish();
                break;
            default:
                break;
        }
    }

    /**
     * 获取考勤列表
     * @param offset
     */
    @Override
    public void getAttendance(int offset) {
        attendancePresenter.getAttendance(offset);
    }

    /**
     * 设置考勤列表
     * @param attendances
     */
    @Override
    public void setAttendance(List<AttendanceBean> attendances) {
        if(offset == 0) {
            datas.clear();
        }
        datas.addAll(attendances);
        attendanceAdapter.notifyDataSetChanged();
        onComplete();
    }

    /**
     * 上拉加载
     * @param view
     */
    @Override
    public void onFooterRefresh(LoadAndRefreshView view) {
        getAttendance(++offset);
    }

    /**
     * 下拉刷新
     * @param view
     */
    @Override
    public void onHeaderRefresh(LoadAndRefreshView view) {
        offset = 0;
        getAttendance(offset);
    }

    /**
     * 下拉刷新&上拉加载完成
     */
    public void onComplete() {
        //故意延迟3s
        final int duration = 3000;
        new Handler() {
            @Override
            public void handleMessage(Message msg) {
                switch (msg.what) {
                    case 0:
                        loadAndRefreshView.onHeaderRefreshComplete();
                        loadAndRefreshView.onFooterRefreshComplete();
                        break;
                }
            }
        }.sendEmptyMessageDelayed(0, duration);
    }
}
