package com.love_cookies.e_office.View.Adapter;

import android.content.Context;

import com.love_cookies.e_office.Model.Bean.OfficialBean;
import com.love_cookies.e_office.R;

import java.util.List;

/**
 * Created by xiekun on 2016/4/25.
 *
 * 公文适配器
 */
public class OfficialAdapter extends CommonAdapter<OfficialBean> {

    public OfficialAdapter(Context context, List<OfficialBean> datas) {
        super(context, R.layout.item_official_list, datas);
    }

    @Override
    public void convert(CommonViewHolder commonViewHolder, OfficialBean officialBean) {
        commonViewHolder.setText(R.id.title_tv, officialBean.getTitle());
    }
}
