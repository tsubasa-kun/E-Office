package com.love_cookies.e_office.View.Activity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.love_cookies.e_office.Event.AddMeetingEvent;
import com.love_cookies.e_office.Presenter.AddMeetingPresenter;
import com.love_cookies.e_office.R;
import com.love_cookies.e_office.Utils.DateTimeUtil;
import com.love_cookies.e_office.Utils.ProgressUtils;
import com.love_cookies.e_office.Utils.ToastUtils;
import com.love_cookies.e_office.View.Interface.IAddMeetingView;
import com.love_cookies.e_office.View.Widget.DateAndTimePicker;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;

import de.greenrobot.event.EventBus;

/**
 * Created by xiekun on 2016/4/25.
 *
 * 添加会议页
 */
@ContentView(R.layout.activity_add_meeting)
public class AddMeetingActivity extends BaseActivity implements IAddMeetingView {

    @ViewInject(R.id.title_tv)
    private TextView titleTV;
    @ViewInject(R.id.left_btn)
    private ImageView leftBtn;
    @ViewInject(R.id.right_btn)
    private TextView rightBtn;
    @ViewInject(R.id.meeting_subject_et)
    private EditText meetingSubjectET;
    @ViewInject(R.id.meeting_time_tv)
    private TextView meetingTimeTV;

    private AddMeetingPresenter addMeetingPresenter = new AddMeetingPresenter(this);

    /**
     * 初始化控件
     * @param savedInstanceState
     */
    @Override
    public void initWidget(Bundle savedInstanceState) {
        titleTV.setText(R.string.add_meeting_title);
        leftBtn.setImageResource(R.mipmap.title_btn_back);
        leftBtn.setOnClickListener(this);
        rightBtn.setText(R.string.submit_btn_text);
        rightBtn.setOnClickListener(this);
        meetingTimeTV.setOnClickListener(this);
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
            case R.id.meeting_time_tv:
                DateAndTimePicker dateAndTimePicker = new DateAndTimePicker(this, DateTimeUtil.getCurrentTime());
                dateAndTimePicker.dateTimePicKDialog(meetingTimeTV);
                break;
            case R.id.right_btn:
                addMeeting();
                break;
            default:
                break;
        }
    }

    /**
     * 添加会议
     */
    @Override
    public void addMeeting() {
        String subject = meetingSubjectET.getText().toString();
        String time = meetingTimeTV.getText().toString();
        if (TextUtils.isEmpty(subject)) {
            ToastUtils.show(this, R.string.meeting_subject_hint);
        } else if (TextUtils.isEmpty(time)) {
            ToastUtils.show(this, R.string.meeting_time_hint);
        } else {
            ProgressUtils.showProgress(this, R.string.wait_text);
            addMeetingPresenter.addMeeting(subject, time);
        }
    }

    /**
     * 添加成功
     */
    @Override
    public void addSuccess() {
        ToastUtils.show(this, R.string.add_meeting_success_tip);
        ProgressUtils.hideProgress();
        EventBus.getDefault().post(new AddMeetingEvent());
        finish();
    }

    /**
     * 添加失败
     * @param msg
     */
    @Override
    public void addFailed(String msg) {
        ToastUtils.show(this, msg);
        ProgressUtils.hideProgress();
    }
}
