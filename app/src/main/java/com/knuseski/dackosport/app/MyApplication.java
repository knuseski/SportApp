package com.knuseski.dackosport.app;

import android.app.Application;
import android.content.Context;

public class MyApplication extends Application {
    public static final String TAG = "KIKO";

    private static MyApplication instance = null;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }

    public static Context getAppContext() {
        return instance.getApplicationContext();
    }

}
