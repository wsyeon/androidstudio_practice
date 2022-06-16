package com.yeon.practice_challenge08_37;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    Button btn_login;
    EditText et_id, et_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btn_login = findViewById(R.id.btn_login);
        et_id = findViewById(R.id.et_id);
        et_password = findViewById(R.id.et_password);

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (TextUtils.isEmpty(et_id.getText().toString())) {
                    Toast.makeText(getBaseContext(), "id를 입력헤주세요.", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(et_password.getText().toString())) {
                    Toast.makeText(getBaseContext(), "password를 입력헤주세요.", Toast.LENGTH_SHORT ).show();
                    return;
                }

                Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
                startActivity(intent);

            }
        });

    }
}