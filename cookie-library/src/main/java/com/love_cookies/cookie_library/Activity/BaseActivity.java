package com.love_cookies.cookie_library.Activity;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.love_cookies.cookie_library.Application.ActivityCollections;

import org.xutils.x;

/**
 * Created by xiekun on 2016/3/27.
 *
 * Activity基类
 */
public abstract class BaseActivity extends AppCompatActivity implements View.OnClickListener {

    /**
     * 初始化控件和事件
     * @param savedInstanceState
     */
    public abstract void initWidget(Bundle savedInstanceState);

    /**
     * 控件的点击事件
     * @param view
     */
    public abstract void widgetClick(View view);

    @Override
    public void onClick(View v) {
        widgetClick(v);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);// 竖屏锁定
        ActivityCollections.getInstance().addActivity(this);
        x.view().inject(this);
        initWidget(savedInstanceState);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityCollections.getInstance().finishActivity(this);
    }
}
