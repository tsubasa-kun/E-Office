package com.love_cookies.e_office.View.Adapter;

import android.content.Context;

import com.love_cookies.e_office.Model.Bean.ProjectLogBean;
import com.love_cookies.e_office.R;

import java.util.List;

/**
 * Created by xiekun on 2016/4/23.
 *
 * 项目日志适配器
 */
public class ProjectLogAdapter extends CommonAdapter<ProjectLogBean> {

    public ProjectLogAdapter(Context context, List<ProjectLogBean> datas) {
        super(context, R.layout.item_project_log_list, datas);
    }

    @Override
    public void convert(CommonViewHolder commonViewHolder, ProjectLogBean projectLogBean) {
        commonViewHolder.setText(R.id.nickname_tv, projectLogBean.getNickname());
        commonViewHolder.setText(R.id.time_tv, projectLogBean.getTime());
        commonViewHolder.setText(R.id.content_tv, projectLogBean.getContent());
    }
}
