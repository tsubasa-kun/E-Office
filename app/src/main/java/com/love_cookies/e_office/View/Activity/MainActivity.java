package com.love_cookies.e_office.View.Activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.love_cookies.cookie_library.Activity.BaseActivity;
import com.love_cookies.e_office.Model.Bean.UserBean;
import com.love_cookies.e_office.R;

import org.xutils.image.ImageOptions;
import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import cn.bmob.v3.BmobUser;

@ContentView(R.layout.activity_main)
public class MainActivity extends BaseActivity {

    @ViewInject(R.id.text_title)
    TextView titleTV;

    @ViewInject(R.id.index_top_bg_iv)
    ImageView indexTopBgIV;

    @ViewInject(R.id.user_nickname_tv)
    TextView userNicknameTV;

    private UserBean userBean;

    @Override
    public void initWidget(Bundle savedInstanceState) {
        titleTV.setText(R.string.app_name);
        x.image().bind(indexTopBgIV, "assets://index_top_bg.png", new ImageOptions.Builder().setFadeIn(true).build());
        userBean = BmobUser.getCurrentUser(this, UserBean.class);
        userNicknameTV.setText(userBean.getNickname());
    }

    @Override
    public void widgetClick(View view) {

    }
}
