package com.kookmin.jongmin.kookimincommunity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by JongMin on 2018-02-09.
 */

public class LoginActivity extends AppCompatActivity {

    final LoginActivity activity = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button login_button = findViewById(R.id.login_button);
        TextView signup_button = findViewById(R.id.signup_text_view);

        login_button.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v)
            {
                EditText login_id_edit_text = findViewById(R.id.login_ID_edit_text);
                EditText login_pw_edit_text = findViewById(R.id.login_PW_edit_text);

                String id = login_id_edit_text.getText().toString();
                String pw = login_pw_edit_text.getText().toString();

                // 로그인 버튼 클릭
                if (id.compareTo("test") == 0 && pw.compareTo("1") == 0)        // 아이디와 비밀번호가 모두 맞으면
                {
                    LoginActivity.this.startActivity(new Intent(LoginActivity.this, MainActivity.class));
                    LoginActivity.this.finish();
                }
                else if (id.compareTo("test2") == 0 && pw.compareTo("1") == 0)      // 이메일 인증을 받지 않은 계정이라면
                {
                    MessageBox.show(activity, "아직 이메일 인증 확인이 되지 않은 계정입니다.");
                }
                else    // 아이디 또는 비밀번호가 틀릴 경우
                {
                    MessageBox.show(activity, "아이디 또는 비밀번호가 틀립니다.");
                }
            }
        });

        signup_button.setOnClickListener(new TextView.OnClickListener() {
            public void onClick(View v)
            {
                LoginActivity.this.startActivity(new Intent(LoginActivity.this, SignUpActivity.class));
            }
        });
    }
}
