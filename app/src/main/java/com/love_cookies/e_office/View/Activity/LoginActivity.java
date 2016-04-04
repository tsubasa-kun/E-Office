package com.love_cookies.e_office.View.Activity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.love_cookies.cookie_library.Activity.BaseActivity;
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
    TextView title;

    @Override
    public void initWidget(Bundle savedInstanceState) {
        title.setText(R.string.login_title);
    }

    @Override
    public void widgetClick(View view) {

    }

    @Override
    public void doLogin() {

    }

    @Override
    public void turnToMain() {
        turnThenFinish(MainActivity.class);
    }

    @Override
    public void loginFailed() {

    }

    @Override
    public void autoLogin() {

    }
}
