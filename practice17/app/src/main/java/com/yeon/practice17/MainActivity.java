package com.yeon.practice17;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btn_message;
    EditText et_write;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edittext);

        btn_message = findViewById(R.id.btn_message);
        et_write = findViewById(R.id.et_write);

        btn_message.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str = et_write.getText().toString();
                Toast.makeText(getApplicationContext(), "내가 쓴 문자\n\n" + str, Toast.LENGTH_SHORT).show();
            }
        });

    }
}