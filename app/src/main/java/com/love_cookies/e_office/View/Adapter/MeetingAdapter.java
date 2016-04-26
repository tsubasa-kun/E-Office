package com.love_cookies.e_office.View.Adapter;

import android.content.Context;

import com.love_cookies.e_office.Model.Bean.MeetingBean;
import com.love_cookies.e_office.R;

import java.util.List;

/**
 * Created by xiekun on 2016/4/25.
 *
 * 会议适配器
 */
public class MeetingAdapter extends CommonAdapter<MeetingBean> {

    public MeetingAdapter(Context context, List<MeetingBean> datas) {
        super(context, R.layout.item_meeting_list, datas);
    }

    @Override
    public void convert(CommonViewHolder commonViewHolder, MeetingBean meetingBean) {
        commonViewHolder.setText(R.id.subject_tv, "会议主题：" + meetingBean.getSubject());
        commonViewHolder.setText(R.id.time_tv, "会议时间：" + meetingBean.getTime());
        commonViewHolder.setText(R.id.nickname_tv, meetingBean.getNickname());
    }
}
