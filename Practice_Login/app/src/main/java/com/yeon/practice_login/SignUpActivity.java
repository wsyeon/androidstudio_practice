package com.yeon.practice_login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class SignUpActivity extends AppCompatActivity {

    private EditText et_id_signup, et_password_signup, et_name_signup, et_age_signup;
    private Button btn_signup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        et_id_signup = findViewById(R.id.et_id_signup);
        et_password_signup = findViewById(R.id.et_password_signup);
        et_name_signup = findViewById(R.id.et_name_signup);
        et_age_signup = findViewById(R.id.et_age_signup);

        // 회원가입 버튼 클릭 시 실행
        btn_signup = findViewById(R.id.btn_signup);
        btn_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // EditText에 현재 입력되어있는 깂 get(가져온다)해온다.
                String userID = et_id_signup.getText().toString();
                String userPassword = et_password_signup.getText().toString();
                String userName = et_name_signup.getText().toString();
                int userAge = Integer.parseInt(et_age_signup.getText().toString());

                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            boolean success = jsonObject.getBoolean("success");
                            if (success) { // 회원등록에 성공한 경우
                                Toast.makeText(getApplicationContext(), "회원 등록에 성공하였습니다.", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(SignUpActivity.this, LoginActivity.class);
                                startActivity(intent);
                            } else { // 회원등록에 실해한 경우
                                Toast.makeText(getApplicationContext(), "회원 등록에 성공하였습니다.", Toast.LENGTH_SHORT).show();
                                return;
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                };
                // 서버로 Volley를 이용해서 요청함
                SignUpRequest signUpRequest = new SignUpRequest(userID, userPassword, userName, userAge, responseListener);
                RequestQueue queue = Volley.newRequestQueue(SignUpActivity.this);
                queue.add(signUpRequest);
            }
        });

    }
}