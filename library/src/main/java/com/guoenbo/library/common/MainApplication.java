package com.guoenbo.library.common;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.widget.Toast;

import com.guoenbo.library.util.CacheUtil;

import java.util.ArrayList;

public class MainApplication extends Application {

    private static ArrayList<Activity> list = new ArrayList<Activity>();

    private static Context context;


    public static Context getContext() {
        return context;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
        registerActivityListener();



    }


    /**
     * 添加Activity到集合中
     */
    public void addActivity(Activity activity) {
        list.add(activity);
    }

    /**
     * 从集合中移除Activity
     */
    public void removeActivity(Activity activity) {
        list.remove(activity);
    }

    /**
     * 关闭所有的Activity
     */
    public static void closeActivity() {
        if (list == null) {
            return;
        }
        for (Activity activity : list) {
            if (null != activity) {
                activity.finish();
            }
        }
        list.clear();
    }


    /**
     * 注册Activity活动监听（android 4.0 API 14 以上）
     */
    private void registerActivityListener() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.ICE_CREAM_SANDWICH) {
            registerActivityLifecycleCallbacks(new ActivityLifecycleCallbacks() {
                @Override
                public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
                    /**
                     *  监听到 Activity创建事件 将该 Activity 加入list
                     */
                    addActivity(activity);

                }

                @Override
                public void onActivityStarted(Activity activity) {

                }

                @Override
                public void onActivityResumed(Activity activity) {

                }

                @Override
                public void onActivityPaused(Activity activity) {

                }

                @Override
                public void onActivityStopped(Activity activity) {

                }

                @Override
                public void onActivitySaveInstanceState(Activity activity, Bundle outState) {

                }

                @Override
                public void onActivityDestroyed(Activity activity) {
                    if (null == list && list.isEmpty()) {
                        return;
                    }
                    if (list.contains(activity)) {
                        /**
                         *  监听到Activity销毁事件 该Activity从list中移除
                         */
                        removeActivity(activity);
                    }
                }
            });
        }
    }

    /**
     * 获取LoginBean
     */
    public static  <T> T getLoginBean() {
        T bean = (T) CacheUtil.getValue(context, Constants.KEY_USER_CACHE);
        return bean;
    }

    /**
     * 设置LoginBean
     * */
//    public static void setUserBean(Context context, UserBean mUserBean){
//        CacheUtil.putValue(context, Constants.KEY_USER_CACHE, mUserBean);
//    }

}
