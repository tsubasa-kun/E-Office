package com.love_cookies.e_office.View.Activity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.love_cookies.cookie_library.Activity.BaseActivity;
import com.love_cookies.cookie_library.Widget.LoadAndRefreshView;
import com.love_cookies.e_office.Event.AddNoticeEvent;
import com.love_cookies.e_office.Model.Bean.NoticeBean;
import com.love_cookies.e_office.Presenter.NoticePresenter;
import com.love_cookies.e_office.R;
import com.love_cookies.e_office.View.Adapter.NoticeAdapter;
import com.love_cookies.e_office.View.Interface.INoticeView;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;

import java.util.ArrayList;
import java.util.List;

import de.greenrobot.event.EventBus;

/**
 * Created by xiekun on 2016/4/18.
 *
 * 通知页
 */
@ContentView(R.layout.activity_notice)
public class NoticeActivity extends BaseActivity implements INoticeView, LoadAndRefreshView.OnHeaderRefreshListener, LoadAndRefreshView.OnFooterRefreshListener {
    @ViewInject(R.id.title_tv)
    private TextView titleTV;
    @ViewInject(R.id.left_btn)
    private ImageView leftBtn;
    @ViewInject(R.id.right_btn)
    private TextView rightBtn;
    @ViewInject(R.id.load_and_refresh_view)
    private LoadAndRefreshView loadAndRefreshView;
    @ViewInject(R.id.notice_list)
    private ListView noticeList;

    private NoticeAdapter noticeAdapter;
    private List<NoticeBean> datas = new ArrayList<>();

    private int offset = 0;

    private NoticePresenter noticePresenter = new NoticePresenter(this);

    /**
     * 初始化控件
     * @param savedInstanceState
     */
    @Override
    public void initWidget(Bundle savedInstanceState) {
        titleTV.setText(R.string.notice_title);
        leftBtn.setImageResource(R.mipmap.title_btn_back);
        leftBtn.setOnClickListener(this);
        rightBtn.setText(R.string.publish_btn_text);
        rightBtn.setOnClickListener(this);
        loadAndRefreshView.setOnHeaderRefreshListener(this);
        loadAndRefreshView.setOnFooterRefreshListener(this);
        noticeAdapter = new NoticeAdapter(this, datas);
        noticeList.setAdapter(noticeAdapter);
        getNotice(offset);
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
                turn(AddNoticeActivity.class);
                break;
            default:
                break;
        }
    }

    /**
     * 获取通知
     * @param offset
     */
    @Override
    public void getNotice(int offset) {
        noticePresenter.getNotice(offset);
    }

    /**
     * 设置通知
     * @param notices
     */
    @Override
    public void setNotice(List<NoticeBean> notices) {
        if(offset == 0) {
            datas.clear();
        }
        datas.addAll(notices);
        noticeAdapter.notifyDataSetChanged();
        onComplete();
    }

    /**
     * 上拉加载
     * @param view
     */
    @Override
    public void onFooterRefresh(LoadAndRefreshView view) {
        getNotice(++offset);
    }

    /**
     * 下拉刷新
     * @param view
     */
    @Override
    public void onHeaderRefresh(LoadAndRefreshView view) {
        offset = 0;
        getNotice(offset);
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
     * 添加通知事件
     * from {@link AddNoticeActivity#addSuccess()}
     * @param addNoticeEvent
     */
    public void onEvent(AddNoticeEvent addNoticeEvent) {
        offset = 0;
        getNotice(offset);
    }
}
