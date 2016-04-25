package com.love_cookies.e_office.View.Activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.love_cookies.cookie_library.Activity.BaseActivity;
import com.love_cookies.e_office.Model.Bean.OfficialBean;
import com.love_cookies.e_office.R;

import org.xutils.image.ImageOptions;
import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

/**
 * Created by xiekun on 2016/4/25 0025.
 *
 * 公文详情页
 */
@ContentView(R.layout.activity_official_detail)
public class OfficialDetailActivity extends BaseActivity {

    @ViewInject(R.id.title_tv)
    private TextView titleTV;
    @ViewInject(R.id.left_btn)
    private ImageView leftBtn;
    @ViewInject(R.id.official_title_tv)
    private TextView officialTitleTV;
    @ViewInject(R.id.official_content_iv)
    private ImageView officialContentIV;

    /**
     * 初始化控件
     * @param savedInstanceState
     */
    @Override
    public void initWidget(Bundle savedInstanceState) {
        titleTV.setText(R.string.official_detail_title);
        leftBtn.setImageResource(R.mipmap.title_btn_back);
        leftBtn.setOnClickListener(this);
        OfficialBean officialBean = getIntent().getExtras().getParcelable("official");
        officialTitleTV.setText(officialBean.getTitle());
        x.image().bind(officialContentIV, "assets://" + officialBean.getContent(), new ImageOptions.Builder().setFadeIn(true).build());
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
