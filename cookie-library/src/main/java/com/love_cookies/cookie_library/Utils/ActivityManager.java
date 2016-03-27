package com.love_cookies.cookie_library.Utils;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiekun on 2016/3/27.
 *
 * Activity管理类
 */
public class ActivityManager {

    public static List<Activity> activities = new ArrayList<Activity>();

    public static void addActivity(Activity activity) {
        activities.add(activity);
    }

    public static void removeActivity(Activity activity) {
        activities.remove(activity);
    }

    public static void finishAll() {
        for (Activity activity : activities) {
            if (!activity.isFinishing()) {
                activity.finish();
            }
        }
    }

}
