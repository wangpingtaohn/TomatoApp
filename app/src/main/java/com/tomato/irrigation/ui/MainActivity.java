package com.tomato.irrigation.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.tomato.irrigation.R;
import com.tomato.irrigation.utils.StatusBarUtil;

import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private TextView tvTip;

    private Dialog dialog;

    private final String[] temperatures = {"18°", "30°"};
    private final String[] humidityArray = {"90%", "70%"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setStatusBar();
        initView();

    }

    protected void setStatusBar() {
        Window window = getWindow();
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        StatusBarUtil.setDarkMode(this);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(0);
    }

    /**
     * 初始化组件
     */
    private void initView() {
        TextView tvTemperature = findViewById(R.id.tvTemperatureValue);
        TextView tvHumidity = findViewById(R.id.tvHumidityValue);

        Random random = new Random();
        int tempIndex = random.nextInt(temperatures.length);
        int humidityIndex = random.nextInt(humidityArray.length);

        tvTemperature.setText(temperatures[tempIndex]);
        tvHumidity.setText(humidityArray[humidityIndex]);

        SimpleDateFormat format = new SimpleDateFormat("HH:mm", Locale.getDefault());

        findViewById(R.id.tvOpen).setOnClickListener(v -> showValveDialog(true));
        findViewById(R.id.tvClose).setOnClickListener(v -> showValveDialog(false));

    }

    private void showValveDialog(boolean isOpen) {
        if (dialog == null) {
            dialog = new Dialog(this);
            dialog.setContentView(R.layout.dialog_layout);
            tvTip = dialog.findViewById(R.id.tvTip);
            TextView tvOk = dialog.findViewById(R.id.tvConfirm);
            tvOk.setOnClickListener(view -> {
                dialog.dismiss();
            });
        }
        tvTip.setText(isOpen ? "阀门已开" : "阀门已关");
        tvTip.setTextColor(ContextCompat.getColor(this, isOpen ? R.color.purple_200 : R.color.color_666));
        dialog.show();
    }
}