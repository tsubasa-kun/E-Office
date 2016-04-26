package com.love_cookies.e_office.View.Activity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.love_cookies.e_office.E_OfficeApplication;
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
    @ViewInject(R.id.title_tv)
    private TextView titleTV;
    @ViewInject(R.id.username_et)
    private EditText usernameET;
    @ViewInject(R.id.password_et)
    private EditText passwordET;
    @ViewInject(R.id.login_btn)
    private TextView loginBtn;
    @ViewInject(R.id.register_btn)
    private TextView registerBtn;

    private LoginPresenter loginPresenter = new LoginPresenter(this);

    /**
     * 初始化控件
     * @param savedInstanceState
     */
    @Override
    public void initWidget(Bundle savedInstanceState) {
        titleTV.setText(R.string.login_title);
        loginBtn.setOnClickListener(this);
        registerBtn.setOnClickListener(this);
        if(!TextUtils.isEmpty(E_OfficeApplication.sp.getString("username", ""))) {
            autoLogin();
        }
    }

    /**
     * 控件点击事件
     * @param view
     */
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

    /**
     * 登录
     */
    @Override
    public void doLogin() {
        String username = usernameET.getText().toString();
        String password = passwordET.getText().toString();
        if (TextUtils.isEmpty(username)) {
            Toast.makeText(this, R.string.username_text_hint, Toast.LENGTH_SHORT).show();
        } else if (TextUtils.isEmpty(password)) {
            Toast.makeText(this, R.string.password_text_hint, Toast.LENGTH_SHORT).show();
        } else {
            E_OfficeApplication.showProgress(this, R.string.wait_text);
            loginPresenter.doLogin(username, password);
        }
    }

    /**
     * 跳转到主页
     */
    @Override
    public void turnToMain() {
        E_OfficeApplication.hideProgress();
        turnThenFinish(MainActivity.class);
    }

    /**
     * 登录失败
     * @param msg
     */
    @Override
    public void loginFailed(String msg) {
        E_OfficeApplication.hideProgress();
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    /**
     * 自动登录
     */
    @Override
    public void autoLogin() {
        loginPresenter.doLogin(E_OfficeApplication.sp.getString("username", ""), E_OfficeApplication.sp.getString("password", ""));
    }
}
