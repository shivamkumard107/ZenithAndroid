package com.example.zenithandroid;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class ChooseYogaAdapter extends RecyclerView.Adapter<ChooseYogaAdapter.RecyclerViewHolder> {
    String[] name = {"vrikshasana", "Virabhadrasana", "Utthita Hasta Padangusthasana", "ardha chandrasana", "Yoga Asan"};

    Integer[] image = {R.drawable.vrikshasana, R.drawable.warrior_pose, R.drawable.extended_hand_big_toe_pose, R.drawable.half_moon_pose,
            R.drawable.star_asan};
    String[] desc ;
    Context context;

    public ChooseYogaAdapter() {

    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_choose_yoga, viewGroup, false);
        RecyclerViewHolder recyclerViewHolder = new RecyclerViewHolder(view);
        return recyclerViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int i) {
        holder.tv_yoga_name.setText(name[i]);
        holder.tv_yoga_desc.setText(desc[i]);
        holder.yoga_image.setImageResource(image[i]);
    }

    @Override
    public int getItemCount() {
        return image.length;
    }

    public ChooseYogaAdapter(String[] yoga_name, Integer[] yoga_image, String[] yoga_desc, Context context) {
        image = yoga_image;
        name = yoga_name;
        desc = yoga_desc;
        this.context = context;
    }

    public static class RecyclerViewHolder extends RecyclerView.ViewHolder {
        TextView tv_yoga_desc, tv_yoga_name;
        ImageView yoga_image;

        public RecyclerViewHolder(View view) {
            super(view);
            tv_yoga_desc = view.findViewById(R.id.yoga_desc);
            tv_yoga_name = view.findViewById(R.id.yoga_name);
            yoga_image = view.findViewById(R.id.yoga_image);
        }
    }
}
