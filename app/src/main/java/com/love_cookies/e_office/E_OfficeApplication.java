package com.love_cookies.e_office;

import android.app.Application;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;

import com.love_cookies.e_office.Config.AppConfig;
import com.love_cookies.e_office.Model.Bean.UserBean;

import org.xutils.x;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import cn.bmob.v3.Bmob;

/**
 * Created by xiekun on 2016/4/4.
 *
 * 应用Application
 */
public class E_OfficeApplication extends Application {

    public static final String DATABASE_NAME = "e_office.db";
    public static final String DATABASE_PATH = "/data/data/com.love_cookies.e_office/databases";
    public static SQLiteDatabase db;

    public static SharedPreferences sp;
    public static SharedPreferences.Editor editor;

    public static ProgressDialog mDialog = null;

    public static UserBean user;

    @Override
    public void onCreate() {
        super.onCreate();
        getDB();
        getSP();
        getSPEditor();
        x.Ext.init(this);
        x.Ext.setDebug(true);
        Bmob.initialize(this, AppConfig.APPID);
    }

    /**
     * 获取数据库
     */
    public void getDB() {
        String databaseFilename = DATABASE_PATH + "/" + DATABASE_NAME;
        File dir = new File(DATABASE_PATH);
        if (!dir.exists())
            dir.mkdir();
        if (!(new File(databaseFilename)).exists()) {
            InputStream is = getResources().openRawResource(R.raw.e_office);
            try {
                FileOutputStream fos = new FileOutputStream(databaseFilename);
                byte[] buffer = new byte[8192];
                int count = 0;
                while ((count = is.read(buffer)) > 0) {
                    fos.write(buffer, 0, count);
                }
                fos.close();
                is.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        db = SQLiteDatabase.openOrCreateDatabase(databaseFilename, null);
    }

    /**
     * 获取SharedPreferences
     */
    public void getSP() {
        sp = getSharedPreferences("data", MODE_PRIVATE);
    }

    /**
     * 获取SharedPreferences.editor
     */
    public void getSPEditor() {
        editor = getSharedPreferences("data", MODE_PRIVATE).edit();
    }

    /**
     * 显示加载窗
     * @param context
     * @param textRes
     */
    public static void showProgress(Context context, int textRes) {
        try {
            if (mDialog == null) {
                mDialog = new ProgressDialog(context);
            }
            mDialog.setCancelable(false);
            mDialog.setMessage(context.getString(textRes));
            mDialog.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 隐藏加载窗
     */
    public static void hideProgress() {
        try {
            if (mDialog != null) {
                mDialog.dismiss();
                mDialog = null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 设置用户
     * @param userBean
     */
    public void setUser(UserBean userBean) {
        user = userBean;
    }
}
