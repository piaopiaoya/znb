package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myapplication.view.RvActivity;

public class HomeActivity extends AppCompatActivity {

    private EditText et_name;
    private EditText et_paw;
    private Button but_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        initView();
    }

    private void initData() {
        String name = et_name.getText().toString();
        String paw = et_paw.getText().toString();

        String n = "H2003xs";
        String p = "H2003";
        if (name.matches(n)&&paw.matches(p)){
            SharedPreferences sp = getSharedPreferences("name", MODE_PRIVATE);
            SharedPreferences.Editor edit = sp.edit();
            edit.putBoolean("true",true);
            edit.commit();
            finish();
            Toast.makeText(this, "登录成功", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(HomeActivity.this, RvActivity.class));
        }else {
            Toast.makeText(this, "登录失败", Toast.LENGTH_SHORT).show();
        }
    }

    private void initView() {
        et_name = findViewById(R.id.et_name);
        et_paw = findViewById(R.id.et_paw);
        but_login = findViewById(R.id.but_login);
        but_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                initData();
            }
        });
    }
}