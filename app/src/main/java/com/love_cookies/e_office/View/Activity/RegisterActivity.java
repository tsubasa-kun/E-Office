package com.love_cookies.e_office.View.Activity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.love_cookies.cookie_library.Activity.BaseActivity;
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

    @Override
    public void initWidget(Bundle savedInstanceState) {
        title.setText(R.string.register_title);
    }

    @Override
    public void widgetClick(View view) {

    }

    @Override
    public void doRegister() {

    }

    @Override
    public void turnToLogin() {

    }

    @Override
    public void registerFailed() {

    }
}
