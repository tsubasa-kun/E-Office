package com.love_cookies.e_office.View.Activity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;

import com.love_cookies.cookie_library.Activity.BaseActivity;
import com.love_cookies.e_office.R;

import org.xutils.image.ImageOptions;
import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

/**
 * Created by xiekun on 2016/04/03.
 *
 * APP启动页
 */
@ContentView(R.layout.activity_splash)
public class SplashActivity extends BaseActivity {
	@ViewInject(R.id.splash_bg_iv)
	private ImageView splashBgIV;

	private final int SPLASH_DISPLAY_DURATION = 1500;//启动页显示时长
	private Looper looper = Looper.myLooper();
	private Handler handler = new Handler(looper);

	private Runnable runnable = new Runnable() {
		@Override
		public void run() {
			turnThenFinish(LoginActivity.class);
		}
	};

	/**
	 * 初始化控件
	 * @param savedInstanceState
     */
	@Override
	public void initWidget(Bundle savedInstanceState) {
		x.image().bind(splashBgIV, "assets://splash_bg.png", new ImageOptions.Builder().setFadeIn(true).build());
		handler.postDelayed(runnable, SPLASH_DISPLAY_DURATION);
	}

	/**
	 * 空间点击事件
	 * @param v
     */
	@Override
	public void widgetClick(View v) {

	}

	/**
	 * 重写物理按键
	 * @param keyCode
	 * @param event
     * @return
     */
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_BACK) {
			handler.removeCallbacks(runnable);
		}
		return super.onKeyDown(keyCode, event);
	}
}
