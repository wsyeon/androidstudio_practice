package com.yeon.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    public static final int REQUEST_CODE_MENU = 1001;

    EditText usernameInput;
    EditText passwordInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button loginButton = findViewById(R.id.loginButton);
        loginButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String username = usernameInput.getText().toString();
                String password = passwordInput.getText().toString();

                Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
                intent.putExtra("username", username);
                intent.putExtra("password", password);

                startActivityForResult(intent, REQUEST_CODE_MENU);
            }
        });

        usernameInput = findViewById(R.id.usernameInput);
        passwordInput = findViewById(R.id.passwordInput);

    }

    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);

        if (requestCode == REQUEST_CODE_MENU) {
            if (intent != null) {
                String menu = intent.getStringExtra("menu");
                String message = intent.getStringExtra("message");

                Toast toast = Toast.makeText(getBaseContext(), "result code : " + resultCode + ", menu : " + menu + ", message : " + message, Toast.LENGTH_LONG);
                toast.show();
            }
        }

    }

}