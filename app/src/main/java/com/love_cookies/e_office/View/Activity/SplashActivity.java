package com.love_cookies.e_office.View.Activity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.KeyEvent;
import android.view.View;

import com.love_cookies.cookie_library.Activity.BaseActivity;
import com.love_cookies.e_office.R;

import org.xutils.view.annotation.ContentView;

/**
 * Created by xiekun on 2016/04/03.
 *
 * APP启动页
 */
@ContentView(R.layout.activity_splash)
public class SplashActivity extends BaseActivity {

	private final int SPLASH_DISPLAY_DURATION = 1500;//启动页显示时长
	Looper looper = Looper.myLooper();
	private Handler handler = new Handler(looper);

	Runnable runnable = new Runnable() {
		@Override
		public void run() {
			turnThenFinish(MainActivity.class);
		}
	};

	@Override
	public void initWidget(Bundle savedInstanceState) {
		handler.postDelayed(runnable, SPLASH_DISPLAY_DURATION);
	}

	@Override
	public void widgetClick(View v) {

	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_BACK) {
			handler.removeCallbacks(runnable);
		}
		return super.onKeyDown(keyCode, event);
	}
}
