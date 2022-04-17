package com.yeon.practice_sampleevent;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView tv_1;
    View v_1, v_2;
    GestureDetector detector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_1 = findViewById(R.id.tv_1);
        v_1 = findViewById(R.id.v_1);
        v_2 = findViewById(R.id.v_2);

        v_1.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                int action = motionEvent.getAction();

                // x좌표
                float curX = motionEvent.getX();
                // y좌표
                float curY = motionEvent.getY();
                String str = curX + ", " + curY;

                if (action == MotionEvent.ACTION_DOWN) { // 손가락이 눌렸을 때
                    println("손가락 눌림 : " + curX + ", " + curY);
                    Log.d("손가락 눌림 : ", str);
                } else if (action == MotionEvent.ACTION_MOVE) { // 손가락이 눌린 상태로 움직일 때
                    println("손가락 움직임 : " + curX + ", " + curY);
                    Log.d("손가락 움직임 : ", str);
                } else if (action == MotionEvent.ACTION_UP) { // 손가락이 떼졌을 때
                    println("손가락 뗌 : " + curX + ", " + curY);
                    Log.d("손가락 뗌 : ", str);
                }

                return true;
            }
        });

        detector = new GestureDetector(this, new GestureDetector.OnGestureListener() {
            @Override
            public boolean onDown(MotionEvent motionEvent) {
                println("onDown() 호출됨.");

                return true;
            }

            @Override
            public void onShowPress(MotionEvent motionEvent) {
                println("onShowPress() 호출됨.");
            }

            @Override
            public boolean onSingleTapUp(MotionEvent motionEvent) {
                println("onSingleTapUp() 호출됨.");

                return true;
            }

            @Override
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
                String str = v + ", " + v1;
                println("onScroll() 호출됨 : " + v + ", " + v1); // 드래그
                Log.d("onScroll() 호출됨 : ", str);

                return true;
            }

            @Override
            public void onLongPress(MotionEvent motionEvent) {
                println("onLongPress() 호출됨.");
            }

            @Override
            public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
                String str = v + ", " + v1;
                println("onFling() 호출됨 : " + v + ", " + v1); // 속도
                Log.d("onFling() 호출됨 : ", str);

                return  true;
            }
        });

        v_2.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                detector.onTouchEvent(motionEvent);
                return true;
            }
        });

    }

    private void println(String data) {
        tv_1.append(data + "\n");
    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {


        if (keyCode == KeyEvent.KEYCODE_BACK) {
            String str = "[BACK] 버튼을 눌렀음";
            Toast.makeText(getApplicationContext(), "시스템 [BACK] 버튼이 눌렸습니다.", Toast.LENGTH_LONG).show();
            Log.d("사용자 ", str);

            return true;
        }

        return true;
    }
}