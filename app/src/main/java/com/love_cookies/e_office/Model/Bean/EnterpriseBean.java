package com.love_cookies.e_office.Model.Bean;

import android.os.Parcel;
import android.os.Parcelable;

import cn.bmob.v3.BmobObject;

/**
 * Created by xiekun on 2016/4/24.
 *
 * 企业动态实体类
 */
public class EnterpriseBean extends BmobObject implements Parcelable {
    private String title;
    private String time;
    private String content;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.title);
        dest.writeString(this.time);
        dest.writeString(this.content);
    }

    public EnterpriseBean() {
    }

    protected EnterpriseBean(Parcel in) {
        this.title = in.readString();
        this.time = in.readString();
        this.content = in.readString();
    }

    public static final Parcelable.Creator<EnterpriseBean> CREATOR = new Parcelable.Creator<EnterpriseBean>() {
        @Override
        public EnterpriseBean createFromParcel(Parcel source) {
            return new EnterpriseBean(source);
        }

        @Override
        public EnterpriseBean[] newArray(int size) {
            return new EnterpriseBean[size];
        }
    };
}
