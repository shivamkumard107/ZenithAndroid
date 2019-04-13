package com.example.zenithandroid;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;

import de.hdodenhof.circleimageview.CircleImageView;

public class ImageResultActivity extends AppCompatActivity {
    ProgressBar mProgressBar;
    CountDownTimer mCountDownTimer;
    int i = 0;
    ImageView iv;
    CircleImageView cv_add, cv_main;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_result);
        iv = findViewById(R.id.iv_);

        mProgressBar = (ProgressBar) findViewById(R.id.progressbar);
        cv_add = findViewById(R.id.bt_add_img);
        cv_main = findViewById(R.id.iv_main_act);
        cv_add.setOnClickListener(view2 ->{
            startActivity(new Intent(this, ChooseYogaActivity.class));
        });
        cv_main.setOnClickListener(view3 ->{
            startActivity(new Intent(this, MainActivity.class));
        });
        mProgressBar.setProgress(i);
        mCountDownTimer = new CountDownTimer(5000, 1000) {

            @Override
            public void onTick(long millisUntilFinished) {
                i++;
                mProgressBar.setProgress((int) i * 100 / (5000 / 1000));

            }

            @Override
            public void onFinish() {
                //Do what you want
                iv.setImageResource(R.drawable.result);
                i++;
                cv_add.setVisibility(View.VISIBLE);
                cv_main.setVisibility(View.VISIBLE);
                mProgressBar.setProgress(100);
            }
        };
        mCountDownTimer.start();
    }
}
