package com.yeon.practice_samplecallintent_32;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText et_phone;
    Button btn_call, btn_menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_phone = findViewById(R.id.et_phone);
        btn_call = findViewById(R.id.btn_call);
        btn_menu = findViewById(R.id.btn_menu);

        btn_call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String data = et_phone.getText().toString();

                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(data));
                startActivity(intent);
            }
        });

        btn_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                ComponentName name = new ComponentName("org.techtown.samplecallintent", "org.techtown.samplecallintent.MenuActivity");
                intent.setComponent(name);
                startActivityForResult(intent, 101);
            }
        });
    }
}