package com.example.qf.neihanduanzi.home.View;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.qf.neihanduanzi.R;

public class user_activity extends AppCompatActivity {
    private ImageView back;
    private TextView login_now;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_activity);
        initView();
        setListener();
    }
    private void setListener(){
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        login_now.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(user_activity.this,login_activity.class));
            }
        });
    }

    private void initView(){
        back= (ImageView) findViewById(R.id.back);
        login_now= (TextView) findViewById(R.id.login_now);
    }

}
