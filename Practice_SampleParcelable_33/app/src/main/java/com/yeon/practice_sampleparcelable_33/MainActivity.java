package com.yeon.practice_sampleparcelable_33;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    public static final int REQUEST_CODE_MENU = 10;
    public static final String KEY_SAMPLE_DATA = "data";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
                SampleData data = new SampleData(100, "Hello Android!");
                intent.putExtra(KEY_SAMPLE_DATA, data);
                startActivityForResult(intent, REQUEST_CODE_MENU);
            }
        });
    }
}