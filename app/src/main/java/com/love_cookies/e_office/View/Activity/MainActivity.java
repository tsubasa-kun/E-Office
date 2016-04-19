package com.love_cookies.e_office.View.Activity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.love_cookies.cookie_library.Activity.BaseActivity;
import com.love_cookies.cookie_library.Application.ActivityCollections;
import com.love_cookies.cookie_library.Utils.ToastUtils;
import com.love_cookies.e_office.Model.Bean.UserBean;
import com.love_cookies.e_office.R;
import com.love_cookies.e_office.View.Widget.MenuItemView;

import org.xutils.image.ImageOptions;
import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import cn.bmob.v3.BmobUser;

/**
 * Created by xiekun on 2016/4/18.
 *
 * 主页
 */
@ContentView(R.layout.activity_main)
public class MainActivity extends BaseActivity {
    @ViewInject(R.id.title_tv)
    private TextView titleTV;
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

    private UserBean userBean;

    private long exitTime;

    /**
     * 初始化控件
     * @param savedInstanceState
     */
    @Override
    public void initWidget(Bundle savedInstanceState) {
        titleTV.setText(R.string.app_name);
        x.image().bind(indexTopBgIV, "assets://index_top_bg.png", new ImageOptions.Builder().setFadeIn(true).build());
        userBean = BmobUser.getCurrentUser(this, UserBean.class);
        userNicknameTV.setText(userBean.getNickname());
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
                    signBtn.setText(R.string.sign_out);
                } else {
                    signBtn.setText(R.string.sign_in);
                }
            }
        });
    }

    /**
     * 控件点击事件
     * @param view
     */
    @Override
    public void widgetClick(View view) {
        switch (view.getId()) {
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
                ToastUtils.show(getApplicationContext(), R.string.exit_tip);
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
