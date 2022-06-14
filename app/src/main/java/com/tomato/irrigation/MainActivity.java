package com.tomato.irrigation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.app.Dialog;
import android.os.Bundle;
import android.widget.TextView;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private TextView tvTip;

    private Dialog dialog;

    private final String[] temperatures = {"18°","30°"};
    private final String[] humidityArray = {"90%","70%"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

    }

    /**
     * 初始化组件
     */
    private void initView(){
        TextView tvTemperature = findViewById(R.id.tvTemperatureValue);
        TextView tvHumidity = findViewById(R.id.tvHumidityValue);

        Random random = new Random();
        int tempIndex = random.nextInt(temperatures.length);
        int humidityIndex = random.nextInt(humidityArray.length);

        tvTemperature.setText(temperatures[tempIndex]);
        tvHumidity.setText(humidityArray[humidityIndex]);

        SimpleDateFormat format= new SimpleDateFormat("HH:mm", Locale.getDefault());

        findViewById(R.id.tvOpen).setOnClickListener(v -> showValveDialog(true));
        findViewById(R.id.tvclose).setOnClickListener(v -> showValveDialog(false));

    }

    private void showValveDialog(boolean isOpen){
        if (dialog == null){
            dialog = new Dialog(this);
            dialog.setContentView(R.layout.dialog_layout);
            tvTip = dialog.findViewById(R.id.tvTip);
            TextView tvOk = dialog.findViewById(R.id.tvConfirm);
            tvOk.setOnClickListener(view -> {
                dialog.dismiss();
            });
        }
        tvTip.setText(isOpen ? "阀门已开" : "阀门已关");
        tvTip.setTextColor(ContextCompat.getColor(this,isOpen ? R.color.purple_200 : R.color.color_666));
        dialog.show();
    }
}