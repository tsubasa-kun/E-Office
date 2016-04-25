package com.love_cookies.e_office.View.Adapter;

import android.content.Context;

import com.love_cookies.cookie_library.Adapter.CommonAdapter;
import com.love_cookies.cookie_library.Adapter.CommonViewHolder;
import com.love_cookies.e_office.Model.Bean.NoticeBean;
import com.love_cookies.e_office.R;

import java.util.List;

/**
 * Created by xiekun on 2016/4/25 0025.
 *
 * 通知适配器
 */
public class NoticeAdapter extends CommonAdapter<NoticeBean> {
    public NoticeAdapter(Context context, List<NoticeBean> datas) {
        super(context, R.layout.item_notice_list, datas);
    }

    @Override
    public void convert(CommonViewHolder commonViewHolder, NoticeBean noticeBean) {
        commonViewHolder.setText(R.id.title_tv, noticeBean.getTitle());
        commonViewHolder.setText(R.id.status_tv, noticeBean.getNickname() + "　" + noticeBean.getTime());
        commonViewHolder.setText(R.id.content_tv, noticeBean.getContent());
    }
}
