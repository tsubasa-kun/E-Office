package com.love_cookies.e_office.View.Adapter;

import android.content.Context;

import com.love_cookies.cookie_library.Adapter.CommonAdapter;
import com.love_cookies.cookie_library.Adapter.CommonViewHolder;
import com.love_cookies.e_office.Model.Bean.EnterpriseBean;
import com.love_cookies.e_office.R;

import java.util.List;

/**
 * Created by xiekun on 2016/4/24.
 *
 * 企业动态适配器
 */
public class EnterpriseAdapter extends CommonAdapter<EnterpriseBean> {
    public EnterpriseAdapter(Context context, List<EnterpriseBean> datas) {
        super(context, R.layout.item_enterprise_list, datas);
    }

    @Override
    public void convert(CommonViewHolder commonViewHolder, EnterpriseBean enterpriseBean) {
        commonViewHolder.setText(R.id.title_tv, enterpriseBean.getTitle());
        commonViewHolder.setText(R.id.time_tv, enterpriseBean.getTime());
        commonViewHolder.setText(R.id.content_tv, enterpriseBean.getContent());
    }
}
