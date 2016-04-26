package com.love_cookies.e_office.View.Adapter;

import android.content.Context;
import android.text.TextUtils;
import com.love_cookies.e_office.Model.Bean.AttendanceBean;
import com.love_cookies.e_office.R;

import java.util.List;

/**
 * Created by xiekun on 2016/4/20 0020.
 *
 * 考勤适配器
 */
public class AttendanceAdapter extends CommonAdapter<AttendanceBean> {

    public AttendanceAdapter(Context context, List<AttendanceBean> datas) {
        super(context, R.layout.item_attendance_list, datas);
    }

    @Override
    public void convert(CommonViewHolder commonViewHolder, AttendanceBean attendanceBean) {
        String date = "--";
        String sign_in = attendanceBean.getSign_in();
        String sign_out = attendanceBean.getSign_out();
        if (TextUtils.isEmpty(sign_in)) {
            sign_in = "--";
        } else {
            date = sign_in.substring(0, 10);
            sign_in = sign_in.substring(11, sign_in.length());
        }
        if(TextUtils.isEmpty(sign_out)) {
            sign_out = "--";
        } else {
            sign_out = sign_out.substring(11, sign_out.length());
        }
        commonViewHolder.setText(R.id.date_tv, date);
        commonViewHolder.setText(R.id.sign_in_tv, sign_in);
        commonViewHolder.setText(R.id.sign_out_tv, sign_out);
    }

}
