package com.yeon.sampleorientation_19;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showToast("onCreate 호출됨.");
    }

    @Override
    protected void onStart() {
        super.onStart();

        showToast("onStart 호출됨.");
    }

    @Override
    protected void onStop() {
        super.onStop();

        showToast("onStop 호출됨.");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        showToast("onDestroy 호출됨.");
    }

    private void showToast(String data) {
        Toast.makeText(getApplicationContext(), data, Toast.LENGTH_LONG).show();
    }
}