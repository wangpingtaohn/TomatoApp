package com.tomato.irrigation;

import android.widget.Toast;

import androidx.annotation.StringRes;


/**
 * desc:
 */
public class ToastUtil {

    private ToastUtil() {
    }

    public static void show(CharSequence text) {
        if (text.length() < 10) {
            Toast.makeText(BaseApplication.getInstance(), text, Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(BaseApplication.getInstance(), text, Toast.LENGTH_LONG).show();
        }
    }

    public static void show(@StringRes int resId) {
        show(BaseApplication.getInstance().getString(resId));
    }

}