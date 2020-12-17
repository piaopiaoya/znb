package com.example.myapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.view.RvActivity;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    private ImageView iv;
    private Button but;
    private Timer timer;
    private int time;
    private boolean aTrue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SharedPreferences name = getSharedPreferences("name", MODE_PRIVATE);
        aTrue = name.getBoolean("true", false);
        initView();
        initData();
    }

    private void initData() {
        timer = new Timer();
        time = 3;
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        but.setText(time+"");
                        time--;
                        if (time==0){
                            if (aTrue){
                                timer.cancel();
                                startActivity(new Intent(MainActivity.this, RvActivity.class));
                                finish();
                            }else {
                                timer.cancel();
                                startActivity(new Intent(MainActivity.this, HomeActivity.class));
                                finish();
                            }

                        }
                    }
                });
            }
        },1000,1000);
    }

    private void initView() {
        iv = (ImageView) findViewById(R.id.iv);
        but = (Button) findViewById(R.id.but);
    }
}