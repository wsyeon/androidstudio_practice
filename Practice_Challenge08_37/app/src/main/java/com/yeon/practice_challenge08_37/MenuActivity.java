package com.yeon.practice_challenge08_37;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MenuActivity extends AppCompatActivity {

    Button btn_client, btn_sale, btn_goods;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        btn_client = findViewById(R.id.btn_goback_m);
        btn_sale = findViewById(R.id.btn_goback_l);
        btn_goods = findViewById(R.id.btn_goods);

        btn_client.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ClientActivity.class);
                startActivity(intent);
            }
        });

        btn_sale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), SaleActivity.class);
                startActivity(intent);
            }
        });

        btn_goods.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), GoodsActivity.class);
                startActivity(intent);
            }
        });
    }
}