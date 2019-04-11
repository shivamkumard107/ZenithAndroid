package com.example.zenithandroid.LeaderBoard;

import android.os.Bundle;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import com.example.zenithandroid.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeaderBoardActivity extends AppCompatActivity {
    private String[] username = {"Shivam kumar", "Devesh Singh", "Mohit Ranjan", "Harshit Gupta", "Shivang Garg", "Vaishali Kashyap", "Sameep Yadav", "Yash Gautam", "Pranav Sharma", "Ruchika", "Chirag", "Rahul"};
    private Integer[] userphoto = {R.drawable.shivam_kumar_small, R.drawable.devesh, R.drawable.mohit, R.drawable.harshit,
            R.drawable.shivang, R.drawable.vaishali, R.drawable.sameep, R.drawable.yash, R.drawable.ic_boy, R.drawable.ic_girl, R.drawable.ic_boy, R.drawable.ic_boy};
    private double[] accuracy = {60.8, 70.5, 90.23, 87.5, 89, 97, 39, 59, 90, 100, 80.50, 69.5};

    private RecyclerView recyclerView;
    private LeaderBoardAdapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private EditText etSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leader_board);
        etSearch = findViewById(R.id.search);
        recyclerView = findViewById(R.id.aboutteam_recycler);
        Arrays.sort(accuracy);

        List<String> user_names = new ArrayList<>();
        List<Integer> user_image = new ArrayList<>();
        List<Double> acc = new ArrayList<>();
        for (int i = 0; i < username.length; i++) {
            user_names.add(username[i]);
            user_image.add(userphoto[i]);
            acc.add(accuracy[i]);
        }
        adapter = new LeaderBoardAdapter(this);
        adapter.updatelist(user_names, user_image, acc);
        layoutManager = new GridLayoutManager(this, 1);
        ViewCompat.setNestedScrollingEnabled(recyclerView, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);
        etSearch.addTextChangedListener(new TextWatcher() {

            public void afterTextChanged(Editable s) {
                String userInput = etSearch.getText().toString().trim();
                List<String> newList = new ArrayList<>();
                List<Integer> user_image = new ArrayList<>();
                List<Double> acc = new ArrayList<>();
                for (int i = 0; i < username.length; i++) {
                    if (username[i].toLowerCase().contains(userInput)) {
                        newList.add(username[i]);
                        user_image.add(userphoto[i]);
                        acc.add(accuracy[i]);
                    }
                }
                adapter.updatelist(newList,user_image, acc);
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
        });
    }

}

