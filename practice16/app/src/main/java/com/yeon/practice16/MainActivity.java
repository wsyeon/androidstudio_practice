package com.yeon.practice16;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btn_text;
    private EditText et_message;
    private String str;
    long btnBack = 1;
    private Button btn_close;
    private TextView tv_writing;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_text = findViewById(R.id.btn_text);
        et_message = findViewById(R.id.et_message);
        tv_writing = findViewById(R.id.tv_writing);
        btn_close = findViewById(R.id.btn_close);



        btn_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                str = et_message.getText().toString();
                Toast.makeText(getApplicationContext(), "전송할 문자\n\n" + str, Toast.LENGTH_SHORT).show();
            }
        });

        et_message.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                str = et_message.getText().toString();
                tv_writing.setText(str.length() + " / 80 바이트");
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });


        btn_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }

    @Override
    public void onBackPressed() {

        long curTime = System.currentTimeMillis();
        long gapTime = curTime - btnBack;

        if (0 <= gapTime && 2000 >= gapTime) {
            super.onBackPressed();
        }
        else {
            btnBack = curTime;
            Toast.makeText(getApplicationContext(), "한번 더 누르시면 종료됩니다.", Toast.LENGTH_SHORT).show();
        }
    }
}