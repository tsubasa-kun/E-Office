package com.love_cookies.e_office.View.Activity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.love_cookies.e_office.Model.Bean.EnterpriseBean;
import com.love_cookies.e_office.Presenter.EnterprisePresenter;
import com.love_cookies.e_office.R;
import com.love_cookies.e_office.View.Adapter.EnterpriseAdapter;
import com.love_cookies.e_office.View.Interface.IEnterpriseView;
import com.love_cookies.e_office.View.Widget.LoadAndRefreshView;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiekun on 2016/4/18.
 *
 * 企业页
 */
@ContentView(R.layout.activity_enterprise)
public class EnterpriseActivity extends BaseActivity implements IEnterpriseView, LoadAndRefreshView.OnHeaderRefreshListener, LoadAndRefreshView.OnFooterRefreshListener {
    @ViewInject(R.id.title_tv)
    private TextView titleTV;
    @ViewInject(R.id.left_btn)
    private ImageView leftBtn;
    @ViewInject(R.id.load_and_refresh_view)
    private LoadAndRefreshView loadAndRefreshView;
    @ViewInject(R.id.enterprise_list)
    private ListView enterpriseList;

    private EnterpriseAdapter enterpriseAdapter;
    private List<EnterpriseBean> datas = new ArrayList<>();

    private int offset = 0;

    private EnterprisePresenter enterprisePresenter = new EnterprisePresenter(this);

    /**
     * 初始化控件
     * @param savedInstanceState
     */
    @Override
    public void initWidget(Bundle savedInstanceState) {
        titleTV.setText(R.string.enterprise_title);
        leftBtn.setImageResource(R.mipmap.title_btn_back);
        leftBtn.setOnClickListener(this);
        enterpriseAdapter = new EnterpriseAdapter(this, datas);
        enterpriseList.setAdapter(enterpriseAdapter);
        loadAndRefreshView.setOnHeaderRefreshListener(this);
        loadAndRefreshView.setOnFooterRefreshListener(this);
        getEnterprise(offset);
        enterpriseList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Bundle bundle = new Bundle();
                bundle.putParcelable("enterprise", datas.get(position));
                turn(EnterpriseDetailActivity.class, bundle);
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
            case R.id.left_btn:
                finish();
                break;
            default:
                break;
        }
    }

    /**
     * 获取企业动态
     * @param offset
     */
    @Override
    public void getEnterprise(int offset) {
        enterprisePresenter.getEnterprise(offset);
    }

    /**
     * 设置企业动态
     * @param enterprises
     */
    @Override
    public void setEnterprise(List<EnterpriseBean> enterprises) {
        if(offset == 0) {
            datas.clear();
        }
        datas.addAll(enterprises);
        enterpriseAdapter.notifyDataSetChanged();
        onComplete();
    }

    /**
     * 上拉加载
     * @param view
     */
    @Override
    public void onFooterRefresh(LoadAndRefreshView view) {
        getEnterprise(++offset);
    }

    /**
     * 下拉刷新
     * @param view
     */
    @Override
    public void onHeaderRefresh(LoadAndRefreshView view) {
        offset = 0;
        getEnterprise(offset);
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
