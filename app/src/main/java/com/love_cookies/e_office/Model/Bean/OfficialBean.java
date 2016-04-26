package com.love_cookies.e_office.Model.Bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by xiekun on 2016/4/25 0025.
 *
 * 公文实体类
 */
public class OfficialBean implements Parcelable {
    private int id;
    private String title;
    private String content;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.id);
        dest.writeString(this.title);
        dest.writeString(this.content);
    }

    public OfficialBean() {
    }

    protected OfficialBean(Parcel in) {
        this.id = in.readInt();
        this.title = in.readString();
        this.content = in.readString();
    }

    public static final Creator<OfficialBean> CREATOR = new Creator<OfficialBean>() {
        @Override
        public OfficialBean createFromParcel(Parcel source) {
            return new OfficialBean(source);
        }

        @Override
        public OfficialBean[] newArray(int size) {
            return new OfficialBean[size];
        }
    };
}
