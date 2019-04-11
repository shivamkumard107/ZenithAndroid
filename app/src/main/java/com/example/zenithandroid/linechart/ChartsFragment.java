package com.example.zenithandroid.linechart;


import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.zenithandroid.R;
import com.example.zenithandroid.linechart.LineCardOne;


/**
 * A simple {@link Fragment} subclass.
 */
public class ChartsFragment extends Fragment {


    public ChartsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.charts, container, false);

        ((AppCompatActivity) getActivity()).setSupportActionBar(
                (Toolbar) layout.findViewById(R.id.toolbar));
        ((TextView) layout.findViewById(R.id.title)).setTypeface(
                Typeface.createFromAsset(getContext().getAssets(), "Ponsi-Regular.otf"));

        (new LineCardOne((CardView) layout.findViewById(R.id.card1), getContext())).init();

        return layout;
    }

}
