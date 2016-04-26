package com.love_cookies.e_office.View.Adapter;

import android.content.Context;

import com.love_cookies.e_office.Model.Bean.ProjectBean;
import com.love_cookies.e_office.R;

import java.util.List;

/**
 * Created by xiekun on 2016/4/23.
 *
 * 项目适配器
 */
public class ProjectAdapter extends CommonAdapter<ProjectBean> {

    public ProjectAdapter(Context context, List<ProjectBean> datas) {
        super(context, R.layout.item_project_list, datas);
    }

    @Override
    public void convert(CommonViewHolder commonViewHolder, ProjectBean projectBean) {
        commonViewHolder.setText(R.id.title_tv, projectBean.getTitle());
    }
}
