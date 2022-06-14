package com.tomato.irrigation.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

import com.tomato.irrigation.base.BaseApplication;

import java.util.Map;

/**

 * SharedPreferences
 */

public class SpUtils {

    private static SpUtils sInstance;
    private SharedPreferences mSharedPreferences;


    private SpUtils() {
        mSharedPreferences = BaseApplication.mApp.getSharedPreferences("SharedPreferences", Context.MODE_PRIVATE);
    }

    public static SpUtils getInstance() {
        if (sInstance == null) {
            synchronized (SpUtils.class) {
                if (sInstance == null) {
                    sInstance = new SpUtils();
                }
            }
        }
        return sInstance;
    }


    /**
     * save a string
     */
    public void setStringValue(String key, String value) {
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putString(key, value);
        editor.apply();
    }


    /**
     * get a string
     */
    public String getStringValue(String key) {
        return mSharedPreferences.getString(key, "");
    }

    /**
     * save a boolean
     */
    public void setBooleanValue(String key, boolean value) {
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putBoolean(key, value);
        editor.apply();
    }

    /**
     * get a boolean
     */
    public boolean getBooleanValue(String key) {
        return mSharedPreferences.getBoolean(key, false);
    }

    public boolean getBooleanValue(String key, boolean defaultValue) {
        return mSharedPreferences.getBoolean(key, defaultValue);
    }

    /**
     * save multiple booleans
     */
    public void setMultiBooleanValue(Map<String, Boolean> pairs) {
        if (pairs == null || pairs.size() == 0) {
            return;
        }
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        for (Map.Entry<String, Boolean> entry : pairs.entrySet()) {
            String key = entry.getKey();
            Boolean value = entry.getValue();
            if (!TextUtils.isEmpty(key)) {
                editor.putBoolean(key, value);
            }
        }
        editor.apply();
    }

    /**
     * get multiple booleans
     */
    public boolean[] getMultiBooleanValue(String[] keys) {
        if (keys == null || keys.length == 0) {
            return null;
        }
        int length = keys.length;
        boolean[] result = new boolean[length];
        for (int i = 0; i < length; i++) {
            boolean temp = false;
            if (!TextUtils.isEmpty(keys[i])) {
                temp = mSharedPreferences.getBoolean(keys[i], false);
            }
            result[i] = temp;
        }
        return result;
    }


    public void setFirstTime(String key, boolean value) {
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putBoolean(key, value);
        editor.apply();
    }


    /**
     * store int
     *
     * @param key
     * @param value
     */
    public void setIntValue(String key, int value) {
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putInt(key, value);
        editor.apply();
    }

    /**
     * take out int
     *
     * @param key
     * @return
     */
    public int getIntValue(String key) {
        return getIntValue(key, 0);
    }

    /**
     * take out int
     *
     * @param key
     * @return
     */
    public int getIntValue(String key, int defaultValue) {
        return mSharedPreferences.getInt(key, defaultValue);
    }

    /**
     * store long
     *
     * @param key
     * @param value
     */
    public void setLongValue(String key, long value) {
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putLong(key, value);
        editor.apply();
    }

    /**
     * get long
     *
     * @param key
     * @return
     */
    public long getLongValue(String key) {
        return mSharedPreferences.getLong(key, 0);
    }

    /**
     * store Double
     *
     * @param key
     * @param value
     */
    public void setDoubleValue(String key, double value) {
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putString(key, String.valueOf(value));
        editor.apply();
    }

    /**
     * get long
     *
     * @param key
     * @return
     */
    public double getDoubleValue(String key) {
        String value = mSharedPreferences.getString(key, "0");
        return value == null ? 0 : Double.parseDouble(value);
    }

}
