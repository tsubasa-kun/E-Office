package com.love_cookies.e_office;

import android.app.Application;
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

    public static UserBean user;

    public static SharedPreferences sp;
    public static SharedPreferences.Editor editor;

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

    public void getSP() {
        sp = getSharedPreferences("data", MODE_PRIVATE);
    }

    public void getSPEditor() {
        editor = getSharedPreferences("data", MODE_PRIVATE).edit();
    }

    public void setUser(UserBean userBean) {
        user = userBean;
    }
}
