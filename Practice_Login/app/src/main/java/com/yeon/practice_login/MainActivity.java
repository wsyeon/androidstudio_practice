package com.yeon.practice_login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView tv_id, tv_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_id = findViewById(R.id.tv_id);
        tv_password = findViewById(R.id.tv_password);

        Intent intent = getIntent();
        String str = intent.getStringExtra("userID");
        String str2 = intent.getStringExtra("userPassword");

        tv_id.setText(str);
        tv_password.setText(str2);
    }
}