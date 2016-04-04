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
import com.love_cookies.e_office.Presenter.RegisterPresenter;
import com.love_cookies.e_office.R;
import com.love_cookies.e_office.View.Interface.IRegisterView;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;

/**
 * Created by xiekun on 2016/4/4.
 *
 * 注册页
 */
@ContentView(R.layout.activity_register)
public class RegisterActivity extends BaseActivity implements IRegisterView {

    @ViewInject(R.id.text_title)
    TextView title;
    @ViewInject(R.id.left_btn)
    ImageView leftBtn;
    @ViewInject(R.id.username_et)
    EditText usernameET;
    @ViewInject(R.id.password_et)
    EditText passwordET;
    @ViewInject(R.id.nickname_et)
    EditText nicknameET;
    @ViewInject(R.id.register_btn)
    TextView registerBtn;

    RegisterPresenter registerPresenter = new RegisterPresenter(this);

    @Override
    public void initWidget(Bundle savedInstanceState) {
        title.setText(R.string.register_title);
        leftBtn.setImageResource(R.drawable.title_btn_back);
        leftBtn.setOnClickListener(this);
        registerBtn.setOnClickListener(this);
    }

    @Override
    public void widgetClick(View view) {
        switch (view.getId()) {
            case R.id.left_btn:
                finish();
                break;
            case R.id.register_btn:
                doRegister();
                break;
            default:
                break;
        }
    }

    @Override
    public void doRegister() {
        String username = usernameET.getText().toString();
        String password = passwordET.getText().toString();
        String nickname = nicknameET.getText().toString();
        if (TextUtils.isEmpty(username)) {
            ToastUtils.show(this, R.string.username_text_hint);
        } else if (TextUtils.isEmpty(password)) {
            ToastUtils.show(this, R.string.password_text_hint);
        } else if (TextUtils.isEmpty(nickname)) {
            ToastUtils.show(this, R.string.nickname_text_hint);
        } else {
            ProgressUtils.showProgress(this, R.string.wait_text);
            registerPresenter.doRegister(username, password, nickname);
        }
    }

    @Override
    public void turnToLogin() {
        ProgressUtils.hideProgress();
        ToastUtils.show(this, R.string.register_success_text);
        finish();
    }

    @Override
    public void registerFailed() {
        ProgressUtils.hideProgress();
        ToastUtils.show(this, R.string.register_failed_text);
    }
}
