package com.love_cookies.e_office.View.Activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.love_cookies.cookie_library.Activity.BaseActivity;
import com.love_cookies.e_office.Model.Bean.EnterpriseBean;
import com.love_cookies.e_office.R;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;

@ContentView(R.layout.activity_enterprise_detail)
public class EnterpriseDetailActivity extends BaseActivity {

    @ViewInject(R.id.title_tv)
    private TextView titleTV;
    @ViewInject(R.id.left_btn)
    private ImageView leftBtn;
    @ViewInject(R.id.detail_title_tv)
    private TextView detailTitleTV;
    @ViewInject(R.id.detail_time_tv)
    private TextView detailTimeTV;
    @ViewInject(R.id.detail_content_tv)
    private TextView detailContentTV;

    /**
     * 初始化控件
     * @param savedInstanceState
     */
    @Override
    public void initWidget(Bundle savedInstanceState) {
        titleTV.setText(R.string.enterprise_detail_title);
        leftBtn.setImageResource(R.mipmap.title_btn_back);
        leftBtn.setOnClickListener(this);
        EnterpriseBean enterpriseBean = getIntent().getExtras().getParcelable("enterprise");
        detailTitleTV.setText(enterpriseBean.getTitle());
        detailTimeTV.setText(enterpriseBean.getTime());
        detailContentTV.setText(enterpriseBean.getContent());
    }

    /**
     * 控件点击事件
     * @param view
     */
    @Override
    public void widgetClick(View view) {
        switch (view.getId()) {
            case R.id.left_btn:
                finish();
                break;
            default:
                break;
        }
    }
}
