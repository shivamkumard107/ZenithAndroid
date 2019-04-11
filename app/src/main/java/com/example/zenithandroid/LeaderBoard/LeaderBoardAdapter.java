package com.example.zenithandroid.LeaderBoard;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.zenithandroid.R;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class LeaderBoardAdapter extends RecyclerView.Adapter<LeaderBoardAdapter.RecyclerViewHolder> {

    String[] username;
    Integer[] userphoto;
    double[] accuracy;
    Context context;

    public LeaderBoardAdapter(Context context) {
//        this.username = username;
//        this.userphoto = images;
//        this.accuracy = accuracy;
        this.context = context;
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.leaderboard_row_layout, parent, false);
        RecyclerViewHolder recyclerViewHolder = new RecyclerViewHolder(view);
        return recyclerViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, final int position) {
        holder.username.setText(username[position]);
        holder.image.setImageResource(userphoto[position]);
        holder.accuracy.setText(String.valueOf(accuracy[position]));
    }


    @Override
    public int getItemCount() {
        return username.length;
    }


    public static class RecyclerViewHolder extends RecyclerView.ViewHolder {
        CircleImageView image;
        TextView username;
        TextView accuracy;

        public RecyclerViewHolder(View view) {
            super(view);
            image = view.findViewById(R.id.user_photo);
            username = view.findViewById(R.id.tv_username);
            accuracy = view.findViewById(R.id.tv_user_acc);
        }
    }

    public void updatelist(List<String> newList, List<Integer> user_image, List<Double> acc) {
        String[] users = new String[newList.size()];
        userphoto = new Integer[user_image.size()];
        accuracy = new double[acc.size()];
        for (int i = 0; i < newList.size(); i++) {
            users[i] = newList.get(i);
            userphoto[i] = user_image.get(i);
            accuracy[i] = acc.get(i);
        }
        username = users;
        notifyDataSetChanged();
    }
}
