package com.example.zenithandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

import com.example.zenithandroid.LeaderBoard.LeaderBoardActivity;

public class MainActivity extends AppCompatActivity {
    private ImageView leaderboard, monitor, accCheck ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        leaderboard = findViewById(R.id.button);
        monitor = findViewById(R.id.bt_monitor);
        accCheck = findViewById(R.id.bt_acc);
        leaderboard.setOnClickListener(view  -> {
            Intent i = new Intent(this, LeaderBoardActivity.class);
            startActivity(i);
        });
        monitor.setOnClickListener(someview -> {
            startActivity(new Intent(this, MonitorAct.class));
        });
        accCheck.setOnClickListener(view2 -> {
            startActivity(new Intent(this, ChooseYogaActivity.class));
        });
    }
}
