package com.love_cookies.e_office.View.Activity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.love_cookies.e_office.Model.Bean.ProjectBean;
import com.love_cookies.e_office.Presenter.ProjectPresenter;
import com.love_cookies.e_office.R;
import com.love_cookies.e_office.View.Adapter.ProjectAdapter;
import com.love_cookies.e_office.View.Interface.IProjectView;
import com.love_cookies.e_office.View.Widget.LoadAndRefreshView;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiekun on 2016/4/18.
 *
 * 项目页
 */
@ContentView(R.layout.activity_project)
public class ProjectActivity extends BaseActivity implements IProjectView, LoadAndRefreshView.OnHeaderRefreshListener, LoadAndRefreshView.OnFooterRefreshListener {
    @ViewInject(R.id.title_tv)
    private TextView titleTV;
    @ViewInject(R.id.left_btn)
    private ImageView leftBtn;
    @ViewInject(R.id.load_and_refresh_view)
    private LoadAndRefreshView loadAndRefreshView;
    @ViewInject(R.id.project_list)
    private ListView projectList;

    private ProjectAdapter projectAdapter;
    private List<ProjectBean> datas = new ArrayList<>();

    private int offset = 0;

    private ProjectPresenter projectPresenter = new ProjectPresenter(this);

    /**
     * 初始化控件
     * @param savedInstanceState
     */
    @Override
    public void initWidget(Bundle savedInstanceState) {
        titleTV.setText(R.string.project_title);
        leftBtn.setImageResource(R.mipmap.title_btn_back);
        leftBtn.setOnClickListener(this);
        loadAndRefreshView.setOnHeaderRefreshListener(this);
        loadAndRefreshView.setOnFooterRefreshListener(this);
        projectAdapter = new ProjectAdapter(this, datas);
        projectList.setAdapter(projectAdapter);
        projectList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Bundle bundle = new Bundle();
                bundle.putString("project_id", datas.get(position).getObjectId());
                turn(ProjectDetailActivity.class, bundle);
            }
        });
        getProject(offset);
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
     * 获取项目
     * @param offset
     */
    @Override
    public void getProject(int offset) {
        projectPresenter.getProject(offset);
    }

    /**
     * 设置项目信息
     * @param projects
     */
    @Override
    public void setProject(List<ProjectBean> projects) {
        if(offset == 0) {
            datas.clear();
        }
        datas.addAll(projects);
        projectAdapter.notifyDataSetChanged();
        onComplete();
    }

    /**
     * 上拉加载
     * @param view
     */
    @Override
    public void onFooterRefresh(LoadAndRefreshView view) {
        getProject(++offset);
    }

    /**
     * 下拉刷新
     * @param view
     */
    @Override
    public void onHeaderRefresh(LoadAndRefreshView view) {
        offset = 0;
        getProject(offset);
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
