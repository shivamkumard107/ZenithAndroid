package com.example.zenithandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ImageView;

public class StartupActivity extends AppCompatActivity {
    ImageButton ib_next;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout);
        ib_next = findViewById(R.id.btnNext);
        ib_next.setOnClickListener(v -> {
            startActivity(new Intent(this, MainActivity.class));
        });
    }
}
