package com.kookmin.jongmin.kookimincommunity.sign.in.and.up;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.kookmin.jongmin.kookimincommunity.MessageBox;
import com.kookmin.jongmin.kookimincommunity.R;

/**
 * Created by JongMin on 2018-02-09.
 */

public class SignUpActivity extends AppCompatActivity {

    Activity activity = this;
    int test = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        Button confirm_button = findViewById(R.id.sign_up_confirm_button);
        Button confirm_id_button = findViewById(R.id.confirm_id_button);

        confirm_button.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                if (test == 0) {
                    MessageBox.show(activity, "이메일 아이디 중복확인을 해주세요.");
                }
                else
                {
                    test = 0;
                    MessageBox.show_false(activity, "입력하신 이메일로 인증 링크를 발송하였습니다. 인증 링크로 접속하면 회원가입이 완료됩니다.", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            SignUpActivity.this.finish();
                        }
                    });
                }
            }
        });

        confirm_id_button.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                if (true)
                {
                    MessageBox.show(activity, "사용해도 되는 아이디입니다.");
                    test = 1;
                }
            }
        });
    }
}
