package com.love_cookies.e_office.View.Activity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.love_cookies.e_office.ActivityCollections;
import com.love_cookies.e_office.E_OfficeApplication;
import com.love_cookies.e_office.Model.Bean.UserBean;
import com.love_cookies.e_office.Presenter.MainPresenter;
import com.love_cookies.e_office.R;
import com.love_cookies.e_office.Utils.DateTimeUtils;
import com.love_cookies.e_office.View.Interface.IMainView;
import com.love_cookies.e_office.View.Widget.MenuItemView;

import org.xutils.image.ImageOptions;
import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

/**
 * Created by xiekun on 2016/4/18.
 *
 * 主页
 */
@ContentView(R.layout.activity_main)
public class MainActivity extends BaseActivity implements IMainView {
    @ViewInject(R.id.title_tv)
    private TextView titleTV;
    @ViewInject(R.id.right_btn)
    private TextView rightBtn;
    @ViewInject(R.id.index_top_bg_iv)
    private ImageView indexTopBgIV;
    @ViewInject(R.id.user_nickname_tv)
    private TextView userNicknameTV;
    @ViewInject(R.id.sign_btn)
    private CheckBox signBtn;
    @ViewInject(R.id.project_btn)
    private MenuItemView projectBtn;
    @ViewInject(R.id.official_btn)
    private MenuItemView officialBtn;
    @ViewInject(R.id.notice_btn)
    private MenuItemView noticeBtn;
    @ViewInject(R.id.enterprise_btn)
    private MenuItemView enterpriseBtn;
    @ViewInject(R.id.meeting_btn)
    private MenuItemView meetingBtn;
    @ViewInject(R.id.attendance_btn)
    private MenuItemView attendanceBtn;

    private MainPresenter mainPresenter = new MainPresenter(this);

    private long exitTime;

    /**
     * 初始化控件
     * @param savedInstanceState
     */
    @Override
    public void initWidget(Bundle savedInstanceState) {

        if (!(E_OfficeApplication.sp.getString("date", "1992-02-12")).contains(DateTimeUtils.getCurrentYear())) {
            E_OfficeApplication.editor.putBoolean("sign_in", false);
            E_OfficeApplication.editor.commit();
        }

        titleTV.setText(R.string.app_name);
        rightBtn.setText(R.string.logout_btn_text);
        rightBtn.setOnClickListener(this);
        x.image().bind(indexTopBgIV, "assets://index_top_bg.png", new ImageOptions.Builder().setFadeIn(true).build());
        getUser();
        projectBtn.setOnClickListener(this);
        officialBtn.setOnClickListener(this);
        noticeBtn.setOnClickListener(this);
        enterpriseBtn.setOnClickListener(this);
        meetingBtn.setOnClickListener(this);
        attendanceBtn.setOnClickListener(this);
        signBtn.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    if (!E_OfficeApplication.sp.getBoolean("sign_in", false)) {
                        doSignIn();
                    }
                } else {
                    doSignOut();
                }
            }
        });
        if (E_OfficeApplication.sp.getBoolean("sign_in", false)) {
            signBtn.setChecked(true);
            signBtn.setText(R.string.sign_out);
        }
    }

    /**
     * 控件点击事件
     * @param view
     */
    @Override
    public void widgetClick(View view) {
        switch (view.getId()) {
            case R.id.right_btn:
                doLogout();
                break;
            case R.id.project_btn:
                turn(ProjectActivity.class);
                break;
            case R.id.official_btn:
                turn(OfficialActivity.class);
                break;
            case R.id.notice_btn:
                turn(NoticeActivity.class);
                break;
            case R.id.enterprise_btn:
                turn(EnterpriseActivity.class);
                break;
            case R.id.meeting_btn:
                turn(MeetingActivity.class);
                break;
            case R.id.attendance_btn:
                turn(AttendanceActivity.class);
                break;
            default:
                break;
        }
    }

    /**
     * 获取用户
     */
    @Override
    public void getUser() {
        mainPresenter.getUser();
    }

    /**
     * 设置用户
     * @param userBean
     */
    @Override
    public void setUser(UserBean userBean) {
        userNicknameTV.setText(userBean.getNickname());
    }

    /**
     * 签到
     */
    @Override
    public void doSignIn() {
        mainPresenter.doSignIn();
    }

    /**
     * 签到成功
     */
    @Override
    public void signInSuccess() {
        Toast.makeText(this, R.string.sign_in_success_tip, Toast.LENGTH_SHORT).show();
        E_OfficeApplication.editor.putBoolean("sign_in", true);
        E_OfficeApplication.editor.putString("date", DateTimeUtils.getCurrentYear());
        E_OfficeApplication.editor.commit();
        signBtn.setText(R.string.sign_out);
    }

    /**
     * 签到失败
     */
    @Override
    public void signInFailed() {
        Toast.makeText(this, R.string.sign_in_failed_tip, Toast.LENGTH_SHORT).show();
        signBtn.setText(R.string.sign_in);
    }

    /**
     * 签退
     */
    @Override
    public void doSignOut() {
        mainPresenter.doSignOut();
    }

    /**
     * 签退成功
     */
    @Override
    public void signOutSuccess() {
        Toast.makeText(this, R.string.sign_out_success_tip, Toast.LENGTH_SHORT).show();
        E_OfficeApplication.editor.putBoolean("sign_in", false);
        E_OfficeApplication.editor.commit();
        signBtn.setText(R.string.sign_in);
    }

    /**
     * 签退失败
     */
    @Override
    public void signOutFailed() {
        Toast.makeText(this, R.string.sign_out_failed_tip, Toast.LENGTH_SHORT).show();
        signBtn.setText(R.string.sign_out);
    }

    /**
     * 登出
     */
    @Override
    public void doLogout() {
        mainPresenter.doLogout();
    }

    /**
     * 跳转到登录页
     */
    @Override
    public void turnToLogin() {
        turn(LoginActivity.class);
        ActivityCollections.getInstance().finishAllActivity();
    }

    /**
     * 点两次返回退出程序
     * @param keyCode
     * @param event
     * @return
     */
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN) {
            if ((System.currentTimeMillis() - exitTime) > 2000)
            {
                Toast.makeText(this, R.string.exit_tip, Toast.LENGTH_SHORT).show();
                exitTime = System.currentTimeMillis();
            } else {
                ActivityCollections.getInstance().finishAllActivity();
                System.exit(0);
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
