package com.example.zenithandroid;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.db.chart.model.LineSet;
import com.db.chart.view.LineChartView;

public class MonitorAct extends AppCompatActivity {
    LineChartView mCharts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monitor);
        mCharts = findViewById(R.id.chart);
        String[] mLabels = {"", "", "", "", ""};
        float[] mValues = {10.0f, 20.0f, 19.0f, 25.0f, 8.0f};
        LineSet dataset = new LineSet(mLabels, mValues);
        mCharts.addData(dataset);
        mCharts.show();
    }
}
