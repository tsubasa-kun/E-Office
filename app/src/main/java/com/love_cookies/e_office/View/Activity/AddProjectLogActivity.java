package com.love_cookies.e_office.View.Activity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.love_cookies.cookie_library.Activity.BaseActivity;
import com.love_cookies.cookie_library.Utils.ProgressUtils;
import com.love_cookies.cookie_library.Utils.ToastUtils;
import com.love_cookies.e_office.Event.AddProjectLogEvent;
import com.love_cookies.e_office.Presenter.AddProjectLogPresenter;
import com.love_cookies.e_office.R;
import com.love_cookies.e_office.View.Interface.IAddProjectLogView;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;

import de.greenrobot.event.EventBus;

/**
 * Created by xiekun on 2016/4/23.
 *
 * 添加项目日志页
 */
@ContentView(R.layout.activity_add_project_log)
public class AddProjectLogActivity extends BaseActivity implements IAddProjectLogView {

    @ViewInject(R.id.title_tv)
    private TextView titleTV;
    @ViewInject(R.id.left_btn)
    private ImageView leftBtn;
    @ViewInject(R.id.right_btn)
    private TextView rightBtn;
    @ViewInject(R.id.log_content_et)
    private EditText logContentET;

    private AddProjectLogPresenter addProjectLogPresenter = new AddProjectLogPresenter(this);

    private String project_id;

    /**
     * 初始化控件
     * @param savedInstanceState
     */
    @Override
    public void initWidget(Bundle savedInstanceState) {
        titleTV.setText(R.string.add_project_log_title);
        leftBtn.setImageResource(R.mipmap.title_btn_back);
        leftBtn.setOnClickListener(this);
        rightBtn.setText(R.string.publish_btn_text);
        rightBtn.setOnClickListener(this);
        project_id = getIntent().getExtras().getString("project_id");
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
                addProjectLog();
                break;
            default:
                break;
        }
    }

    /**
     * 添加项目日志
     */
    @Override
    public void addProjectLog() {
        String logContent = logContentET.getText().toString();
        if (TextUtils.isEmpty(logContent)) {
            ToastUtils.show(this, R.string.log_content_hint);
        } else {
            ProgressUtils.showProgress(this, R.string.wait_text);
            addProjectLogPresenter.addProjectLog(project_id, logContent);
        }
    }

    /**
     * 添加成功
     */
    @Override
    public void addSuccess() {
        ProgressUtils.hideProgress();
        EventBus.getDefault().post(new AddProjectLogEvent());
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
