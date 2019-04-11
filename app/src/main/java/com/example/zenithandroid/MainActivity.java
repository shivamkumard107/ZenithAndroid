package com.example.zenithandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button leaderboard, monitor ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        leaderboard = findViewById(R.id.button);
        monitor = findViewById(R.id.bt_monitor);
        leaderboard.setOnClickListener(view  -> {
            Intent i = new Intent(this, LeaderBoardActivity.class);
            startActivity(i);
        });
        monitor.setOnClickListener(someview -> {
            startActivity(new Intent(this, MonitorAct.class));
        });
    }
}
