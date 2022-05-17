package com.yeon.money;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button btn_out, btn_in, btn_add_1, btn_add_2, btn_add_3, btn_add_4, btn_add_5, btn_add_6, btn_add_7, btn_add_8, btn_add_9, btn_add_10, btn_add_11;
    int i = 0;
    int j = 851792;
    TextView tv_money;
    EditText et_1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_add_1 = findViewById(R.id.btn_add_1);
        btn_out = findViewById(R.id.btn_out);
        btn_in = findViewById(R.id.btn_in);
        tv_money = findViewById(R.id.tv_money);
        et_1 = findViewById(R.id.et_1);


        btn_add_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // i = Integer.parseInt(et_1.getText().toString());
                j = j - Integer.parseInt(et_1.getText().toString());
                tv_money.setText(i);
            }
        });
    }
}