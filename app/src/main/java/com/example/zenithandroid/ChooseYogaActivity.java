package com.example.zenithandroid;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class ChooseYogaActivity extends AppCompatActivity {
    String[] name = {"vrikshasana", "Virabhadrasana", "Utthita Hasta Padangusthasana", "ardha chandrasana", "Yoga Asan"};

    Integer[] image = {R.drawable.vrikshasana, R.drawable.warrior_pose, R.drawable.extended_hand_big_toe_pose, R.drawable.half_moon_pose,
            R.drawable.star_asan};
    String[] desc = {"The Tree Pose Yoga is helpful for individuals experiencing postural disfigurements of spine, joint inflammation of joints of upper and lower furthest points, shortcoming of legs and shoulders and gentle happiness.",
            "The moon has a rich symbolic significance in yoga mythology. In hatha yoga, for example, the sun and the moon represent the two polar energies of the human body. In fact, the word hatha itself is often divided into its two constituent syllables, \"ha\" and \"tha\", which are then esoterically interpreted as signifying the solar and lunar energies respectively.", "The Tree Pose Yoga is helpful for individuals experiencing postural disfigurements of spine, joint inflammation of joints of upper and lower furthest points, shortcoming of legs and shoulders and gentle happiness.", "The moon has a rich symbolic significance in yoga mythology. In hatha yoga, for example, the sun and the moon represent the two polar energies of the human body. In fact, the word hatha itself is often divided into its two constituent syllables, \"ha\" and \"tha\", which are then esoterically interpreted as signifying the solar and lunar energies respectively.", "The Tree Pose Yoga is helpful for individuals experiencing postural disfigurements of spine, joint inflammation of joints of upper and lower furthest points, shortcoming of legs and shoulders and gentle happiness."};
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_yoga);
        fab = findViewById(R.id.bt_add_pic);
        recyclerView = findViewById(R.id.rv);
        adapter = new ChooseYogaAdapter(name, image, desc, this);
        layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, true);
        ViewCompat.setNestedScrollingEnabled(recyclerView, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);
        fab.setOnClickListener(someview -> {
            Intent i = new Intent(this, UploadAsanActivity.class);
            startActivity(i);
        });
    }
}
