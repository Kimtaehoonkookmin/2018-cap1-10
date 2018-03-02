package com.kookmin.jongmin.kookimincommunity;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Activity activity = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            FragmentNavigator.replaceFragment(activity, R.id.main_fragment, new MainFragment(), "BACK");
            TextView title_text = findViewById(R.id.title_text_view);
            title_text.setText("국민대학교 커뮤니티");
        }

        TextView home_button = findViewById(R.id.home_button);
        TextView logout_button = findViewById(R.id.logout_button);

        home_button.setOnClickListener(new TextView.OnClickListener() {
            public void onClick(View v) {
                FragmentNavigator.replaceFragment(activity, R.id.main_fragment, new MainFragment(), "BACK");
                TextView title_text = findViewById(R.id.title_text_view);
                title_text.setText("국민대학교 커뮤니티");
            }
        });

        logout_button.setOnClickListener(new TextView.OnClickListener() {
            public void onClick(View v) {
                MainActivity.this.startActivity(new Intent(MainActivity.this, LoginActivity.class));
                MainActivity.this.finish();
            }
        });
    }

    @Override
    public void onBackPressed() {
        BackAbleFragment listener = (BackAbleFragment)getFragmentManager().findFragmentByTag("BACK");
        if (listener != null) {
            listener.onBackPressed();
        } else {
            super.onBackPressed();
        }
    }
}
