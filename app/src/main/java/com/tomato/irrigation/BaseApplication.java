package com.tomato.irrigation;

import android.app.Application;

/**

 *
 * @Desc：
 */
public class BaseApplication extends Application {

    public static BaseApplication mApp;


    public static BaseApplication getInstance() {
        return mApp;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mApp = this;
    }
}
