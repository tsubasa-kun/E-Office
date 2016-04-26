package com.love_cookies.e_office.View.Activity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.love_cookies.e_office.Event.AddNoticeEvent;
import com.love_cookies.e_office.Presenter.AddNoticePresenter;
import com.love_cookies.e_office.R;
import com.love_cookies.e_office.Utils.ProgressUtils;
import com.love_cookies.e_office.Utils.ToastUtils;
import com.love_cookies.e_office.View.Interface.IAddNoticeView;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;

import de.greenrobot.event.EventBus;

/**
 * Created by xiekun on 2016/4/25.
 *
 * 添加通知页
 */
@ContentView(R.layout.activity_add_notice)
public class AddNoticeActivity extends BaseActivity implements IAddNoticeView {

    @ViewInject(R.id.title_tv)
    private TextView titleTV;
    @ViewInject(R.id.left_btn)
    private ImageView leftBtn;
    @ViewInject(R.id.right_btn)
    private TextView rightBtn;
    @ViewInject(R.id.notice_title_et)
    private EditText noticeTitleET;
    @ViewInject(R.id.notice_content_et)
    private EditText noticeContentET;

    private AddNoticePresenter addNoticePresenter = new AddNoticePresenter(this);

    /**
     * 初始化控件
     * @param savedInstanceState
     */
    @Override
    public void initWidget(Bundle savedInstanceState) {
        titleTV.setText(R.string.add_notice_title);
        leftBtn.setImageResource(R.mipmap.title_btn_back);
        leftBtn.setOnClickListener(this);
        rightBtn.setText(R.string.submit_btn_text);
        rightBtn.setOnClickListener(this);
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
                addNotice();
                break;
            default:
                break;
        }
    }
    /**
     * 添加通知
     */
    @Override
    public void addNotice() {
        String title = noticeTitleET.getText().toString();
        String content = noticeContentET.getText().toString();
        if (TextUtils.isEmpty(title)) {
            ToastUtils.show(this, R.string.notice_title_hint);
        } else if (TextUtils.isEmpty(content)) {
            ToastUtils.show(this, R.string.notice_content_hint);
        } else {
            ProgressUtils.showProgress(this, R.string.wait_text);
            addNoticePresenter.addNotice(title, content);
        }
    }

    /**
     * 添加成功
     */
    @Override
    public void addSuccess() {
        ToastUtils.show(this, R.string.add_notice_success_tip);
        ProgressUtils.hideProgress();
        EventBus.getDefault().post(new AddNoticeEvent());
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
