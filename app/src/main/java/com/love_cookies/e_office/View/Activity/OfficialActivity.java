package com.love_cookies.e_office.View.Activity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.love_cookies.cookie_library.Activity.BaseActivity;
import com.love_cookies.cookie_library.Widget.LoadAndRefreshView;
import com.love_cookies.e_office.Model.Bean.OfficialBean;
import com.love_cookies.e_office.Presenter.OfficialPresenter;
import com.love_cookies.e_office.R;
import com.love_cookies.e_office.View.Adapter.OfficialAdapter;
import com.love_cookies.e_office.View.Interface.IOfficialView;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiekun on 2016/4/18.
 *
 * 公文页
 */
@ContentView(R.layout.activity_official)
public class OfficialActivity extends BaseActivity implements IOfficialView, LoadAndRefreshView.OnHeaderRefreshListener, LoadAndRefreshView.OnFooterRefreshListener {
    @ViewInject(R.id.title_tv)
    private TextView titleTV;
    @ViewInject(R.id.left_btn)
    private ImageView leftBtn;
    @ViewInject(R.id.load_and_refresh_view)
    private LoadAndRefreshView loadAndRefreshView;
    @ViewInject(R.id.official_list)
    private ListView officialList;

    private OfficialAdapter officialAdapter;
    private List<OfficialBean> datas = new ArrayList<>();

    private int offset = 0;

    private OfficialPresenter officialPresenter = new OfficialPresenter(this);

    /**
     * 初始化控件
     * @param savedInstanceState
     */
    @Override
    public void initWidget(Bundle savedInstanceState) {
        titleTV.setText(R.string.official_title);
        leftBtn.setImageResource(R.mipmap.title_btn_back);
        leftBtn.setOnClickListener(this);
        loadAndRefreshView.setOnHeaderRefreshListener(this);
        loadAndRefreshView.setOnFooterRefreshListener(this);
        officialAdapter = new OfficialAdapter(this, datas);
        officialList.setAdapter(officialAdapter);
        officialList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Bundle bundle = new Bundle();
                bundle.putParcelable("official", datas.get(position));
                turn(OfficialDetailActivity.class, bundle);
            }
        });
        getOfficial(offset);
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

    /**
     * 获取公文
     * @param offset
     */
    @Override
    public void getOfficial(int offset) {
        officialPresenter.getOfficial(offset);
    }

    /**
     * 设置公文
     * @param officials
     */
    @Override
    public void setOfficial(List<OfficialBean> officials) {
        if(offset == 0) {
            datas.clear();
        }
        datas.addAll(officials);
        officialAdapter.notifyDataSetChanged();
        onComplete();
    }

    /**
     * 上拉加载
     * @param view
     */
    @Override
    public void onFooterRefresh(LoadAndRefreshView view) {
        getOfficial(++offset);
    }

    /**
     * 下拉刷新
     * @param view
     */
    @Override
    public void onHeaderRefresh(LoadAndRefreshView view) {
        offset = 0;
        getOfficial(offset);
    }

    /**
     * 下拉刷新&上拉加载完成
     */
    public void onComplete() {
        //故意延迟3s
        final int duration = 3000;
        new Handler() {
            @Override
            public void handleMessage(Message msg) {
                switch (msg.what) {
                    case 0:
                        loadAndRefreshView.onHeaderRefreshComplete();
                        loadAndRefreshView.onFooterRefreshComplete();
                        break;
                }
            }
        }.sendEmptyMessageDelayed(0, duration);
    }

}
