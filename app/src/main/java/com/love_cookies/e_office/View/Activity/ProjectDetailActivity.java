package com.love_cookies.e_office.View.Activity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.love_cookies.e_office.Event.AddProjectLogEvent;
import com.love_cookies.e_office.Model.Bean.ProjectBean;
import com.love_cookies.e_office.Model.Bean.ProjectLogBean;
import com.love_cookies.e_office.Presenter.ProjectDetailPresenter;
import com.love_cookies.e_office.R;
import com.love_cookies.e_office.View.Adapter.ProjectLogAdapter;
import com.love_cookies.e_office.View.Interface.IProjectDetailView;
import com.love_cookies.e_office.View.Widget.LoadAndRefreshView;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;

import java.util.ArrayList;
import java.util.List;

import de.greenrobot.event.EventBus;

/**
 * Created by xiekun on 2016/4/23.
 *
 * 项目详情页
 */
@ContentView(R.layout.activity_project_detail)
public class ProjectDetailActivity extends BaseActivity implements IProjectDetailView, LoadAndRefreshView.OnHeaderRefreshListener, LoadAndRefreshView.OnFooterRefreshListener {

    @ViewInject(R.id.title_tv)
    private TextView titleTV;
    @ViewInject(R.id.left_btn)
    private ImageView leftBtn;
    @ViewInject(R.id.right_btn)
    private TextView rightBtn;
    @ViewInject(R.id.load_and_refresh_view)
    private LoadAndRefreshView loadAndRefreshView;
    @ViewInject(R.id.project_title_tv)
    private TextView projectTitleTV;
    @ViewInject(R.id.project_content_tv)
    private TextView projectContentTV;
    @ViewInject(R.id.project_log_list)
    private ListView projectLogList;

    private String project_id;

    private ProjectLogAdapter projectLogAdapter;
    private List<ProjectLogBean> datas = new ArrayList<>();

    private int offset = 0;

    private ProjectDetailPresenter projectDetailPresenter = new ProjectDetailPresenter(this);

    /**
     * 初始化控件
     * @param savedInstanceState
     */
    @Override
    public void initWidget(Bundle savedInstanceState) {
        titleTV.setText(R.string.project_detail_title);
        leftBtn.setImageResource(R.mipmap.title_btn_back);
        leftBtn.setOnClickListener(this);
        rightBtn.setText(R.string.add_btn_text);
        rightBtn.setOnClickListener(this);
        loadAndRefreshView.setOnHeaderRefreshListener(this);
        loadAndRefreshView.setOnFooterRefreshListener(this);
        projectLogAdapter = new ProjectLogAdapter(this, datas);
        projectLogList.setAdapter(projectLogAdapter);
        project_id = getIntent().getExtras().getString("project_id");
        getProjectDetail(project_id);
        getProjectLog(project_id, offset);
        EventBus.getDefault().register(this);
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
            case R.id.right_btn:
                Bundle bundle = new Bundle();
                bundle.putString("project_id", project_id);
                turn(AddProjectLogActivity.class, bundle);
                break;
            default:
                break;
        }
    }

    /**
     * 获取项目详情
     * @param project_id
     */
    @Override
    public void getProjectDetail(String project_id) {
        projectDetailPresenter.getProjectDetail(project_id);
    }

    /**
     * 设置项目详情
     * @param projectBean
     */
    @Override
    public void setProjectDetail(ProjectBean projectBean) {
        projectTitleTV.setText(projectBean.getTitle());
        projectContentTV.setText(projectBean.getContent());
    }

    /**
     * 获取项目日志
     * @param offset
     */
    @Override
    public void getProjectLog(String project_id, int offset) {
        projectDetailPresenter.getProjectLog(project_id, offset);
    }

    /**
     * 设置项目日志
     * @param projectLogs
     */
    @Override
    public void setProjectLog(List<ProjectLogBean> projectLogs) {
        if(offset == 0) {
            datas.clear();
        }
        datas.addAll(projectLogs);
        projectLogAdapter.notifyDataSetChanged();
        onComplete();
    }

    /**
     * 上拉加载
     * @param view
     */
    @Override
    public void onFooterRefresh(LoadAndRefreshView view) {
        getProjectLog(project_id, ++offset);
    }

    /**
     * 下拉刷新
     * @param view
     */
    @Override
    public void onHeaderRefresh(LoadAndRefreshView view) {
        offset = 0;
        getProjectLog(project_id, offset);
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

    /**
     * 添加项目日志事件
     * from {@link AddProjectLogActivity#addSuccess()}
     * @param addProjectLogEvent
     */
    public void onEvent(AddProjectLogEvent addProjectLogEvent) {
        offset = 0;
        getProjectLog(project_id, offset);
    }
}
