package com.love_cookies.e_office.View.Activity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.love_cookies.cookie_library.Activity.BaseActivity;
import com.love_cookies.cookie_library.Utils.ProgressUtils;
import com.love_cookies.cookie_library.Utils.ToastUtils;
import com.love_cookies.e_office.Presenter.LoginPresenter;
import com.love_cookies.e_office.R;
import com.love_cookies.e_office.View.Interface.ILoginView;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;

/**
 * Created by xiekun on 2016/4/4.
 *
 * 登录页
 */
@ContentView(R.layout.activity_login)
public class LoginActivity extends BaseActivity implements ILoginView{

    @ViewInject(R.id.text_title)
    TextView titleTV;
    @ViewInject(R.id.username_et)
    EditText usernameET;
    @ViewInject(R.id.password_et)
    EditText passwordET;
    @ViewInject(R.id.login_btn)
    TextView loginBtn;
    @ViewInject(R.id.register_btn)
    TextView registerBtn;

    LoginPresenter loginPresenter = new LoginPresenter(this);

    @Override
    public void initWidget(Bundle savedInstanceState) {
        titleTV.setText(R.string.login_title);
        loginBtn.setOnClickListener(this);
        registerBtn.setOnClickListener(this);
    }

    @Override
    public void widgetClick(View view) {
        switch (view.getId()) {
            case R.id.login_btn:
                doLogin();
                break;
            case R.id.register_btn:
                turn(RegisterActivity.class);
                break;
            default:
                break;
        }
    }

    @Override
    public void doLogin() {
        String username = usernameET.getText().toString();
        String password = passwordET.getText().toString();
        if (TextUtils.isEmpty(username)) {
            ToastUtils.show(this, R.string.username_text_hint);
        } else if (TextUtils.isEmpty(password)) {
            ToastUtils.show(this, R.string.password_text_hint);
        } else {
            ProgressUtils.showProgress(this, R.string.wait_text);
            loginPresenter.doLogin(username, password);
        }
    }

    @Override
    public void turnToMain() {
        ProgressUtils.hideProgress();
        turnThenFinish(MainActivity.class);
    }

    @Override
    public void loginFailed(String msg) {
        ProgressUtils.hideProgress();
        ToastUtils.show(this, msg);
    }

    @Override
    public void autoLogin() {

    }
}
