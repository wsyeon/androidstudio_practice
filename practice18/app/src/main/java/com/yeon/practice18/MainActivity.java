package com.yeon.practice18;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btn_go_out;
    long backBtn = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_go_out = findViewById(R.id.btn_go_out);

        btn_go_out.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish(); // 종료 버튼 누르면 바로 나가진다
            }
        });
    }

    @Override
    public void onBackPressed() {

        long curTime = System.currentTimeMillis();
        long  gapTime = curTime - backBtn;

        // 0초와 2초 사이에 한번 더 누르면 종료
        if (0 <= gapTime && gapTime <= 2000) {
            super.onBackPressed();
        }
        else {
            backBtn = curTime;
            Toast.makeText(getApplicationContext(), "한번 더 누르시면 종료됩니다!", Toast.LENGTH_SHORT).show();
        }


    }
}