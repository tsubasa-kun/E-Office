package com.love_cookies.e_office.View.Activity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.love_cookies.e_office.Event.AddMeetingEvent;
import com.love_cookies.e_office.Model.Bean.MeetingBean;
import com.love_cookies.e_office.Presenter.MeetingPresenter;
import com.love_cookies.e_office.R;
import com.love_cookies.e_office.View.Adapter.MeetingAdapter;
import com.love_cookies.e_office.View.Interface.IMeetingView;
import com.love_cookies.e_office.View.Widget.LoadAndRefreshView;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;

import java.util.ArrayList;
import java.util.List;

import de.greenrobot.event.EventBus;

/**
 * Created by xiekun on 2016/4/18.
 *
 * 会议页
 */
@ContentView(R.layout.activity_meeting)
public class MeetingActivity extends BaseActivity implements IMeetingView, LoadAndRefreshView.OnHeaderRefreshListener, LoadAndRefreshView.OnFooterRefreshListener {
    @ViewInject(R.id.title_tv)
    private TextView titleTV;
    @ViewInject(R.id.left_btn)
    private ImageView leftBtn;
    @ViewInject(R.id.right_btn)
    private TextView rightBtn;
    @ViewInject(R.id.load_and_refresh_view)
    private LoadAndRefreshView loadAndRefreshView;
    @ViewInject(R.id.meeting_list)
    private ListView meetingList;

    private MeetingAdapter meetingAdapter;
    private List<MeetingBean> datas = new ArrayList<>();

    private int offset = 0;

    private MeetingPresenter meetingPresenter = new MeetingPresenter(this);

    /**
     * 初始化控件
     * @param savedInstanceState
     */
    @Override
    public void initWidget(Bundle savedInstanceState) {
        titleTV.setText(R.string.meeting_title);
        leftBtn.setImageResource(R.mipmap.title_btn_back);
        leftBtn.setOnClickListener(this);
        rightBtn.setText(R.string.initiate_btn_text);
        rightBtn.setOnClickListener(this);
        loadAndRefreshView.setOnHeaderRefreshListener(this);
        loadAndRefreshView.setOnFooterRefreshListener(this);
        meetingAdapter = new MeetingAdapter(this, datas);
        meetingList.setAdapter(meetingAdapter);
        getMeeting(offset);
        EventBus.getDefault().register(this);
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
            case R.id.right_btn:
                turn(AddMeetingActivity.class);
                break;
            default:
                break;
        }
    }

    /**
     * 获取会议
     * @param offset
     */
    @Override
    public void getMeeting(int offset) {
        meetingPresenter.getMeeting(offset);
    }

    /**
     * 设置会议
     * @param meetings
     */
    @Override
    public void setMeeting(List<MeetingBean> meetings) {
        if(offset == 0) {
            datas.clear();
        }
        datas.addAll(meetings);
        meetingAdapter.notifyDataSetChanged();
        onComplete();
    }

    /**
     * 上拉加载
     * @param view
     */
    @Override
    public void onFooterRefresh(LoadAndRefreshView view) {
        getMeeting(++offset);
    }

    /**
     * 下拉刷新
     * @param view
     */
    @Override
    public void onHeaderRefresh(LoadAndRefreshView view) {
        offset = 0;
        getMeeting(offset);
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

    /**
     * 添加会议事件
     * from {@link AddMeetingActivity#addSuccess()}
     * @param addMeetingEvent
     */
    public void onEvent(AddMeetingEvent addMeetingEvent) {
        offset = 0;
        getMeeting(offset);
    }
}
