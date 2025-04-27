package com.example.training_manager;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import android.graphics.Typeface;
import android.widget.ImageButton;
import android.content.Intent;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;

public class FireFragment extends Fragment {
    private LineChart lineChart;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_fire_fragment, container, false);

        lineChart = rootView.findViewById(R.id.lineChart);

        lineChart.setScaleEnabled(false);
        lineChart.setLayerType(View.LAYER_TYPE_SOFTWARE, null);
        lineChart.setRenderer(new GlowLineChartRenderer(lineChart, lineChart.getAnimator(), lineChart.getViewPortHandler()));

        ArrayList<Entry> entries1 = createEntriesForFirstChart();
        ArrayList<Entry> entries2 = createEntriesForSecondChart();
        LineDataSet dataSet1 = createDataSet(entries1, 0xFF7B58FD, "График 1");
        LineDataSet dataSet2 = createDataSet(entries2, 0xFFBAEC5A, "График 2");
        LineData lineData = new LineData(dataSet1, dataSet2);
        lineChart.setData(lineData);
        configureChartAppearance();
        lineChart.invalidate();

        ImageButton imageButton = rootView.findViewById(R.id.playButton);
        if (imageButton != null){
            imageButton.setOnClickListener(v -> {
                Intent intent = new Intent(getContext(), DialogStartActivity.class);
                startActivity(intent);
            });
        }
        return rootView;
    }

    private ArrayList<Entry> createEntriesForFirstChart() {
        ArrayList<Entry> entries = new ArrayList<>();
        entries.add(new Entry(0, 1f));
        entries.add(new Entry(1, 2f));
        entries.add(new Entry(2, 3f));
        entries.add(new Entry(3, 5f));
        entries.add(new Entry(4, 8f));
        return entries;
    }

    private ArrayList<Entry> createEntriesForSecondChart() {
        ArrayList<Entry> entries = new ArrayList<>();
        entries.add(new Entry(0, 4.2f));
        entries.add(new Entry(1, 7.2f));
        entries.add(new Entry(2, 2.5f));
        entries.add(new Entry(3, 6f));
        entries.add(new Entry(4, 3f));
        return entries;
    }

    private LineDataSet createDataSet(ArrayList<Entry> entries, int color, String label) {
        LineDataSet dataSet = new LineDataSet(entries, label);
        dataSet.setColor(color);
        dataSet.setLineWidth(4f);
        dataSet.setDrawValues(false);
        dataSet.setMode(LineDataSet.Mode.LINEAR);
        dataSet.setDrawCircles(true);
        dataSet.setCircleColor(color);
        dataSet.setCircleHoleColor(color);
        dataSet.setCircleRadius(4.5f);
        return dataSet;
    }

    private void configureChartAppearance() {
        lineChart.getXAxis().setDrawLabels(false);
        lineChart.getXAxis().setDrawGridLines(false);
        lineChart.getAxisLeft().setDrawLabels(false);
        lineChart.getAxisLeft().setDrawGridLines(false);
        lineChart.getAxisRight().setEnabled(false);
        lineChart.getLegend().setEnabled(false);
        lineChart.getDescription().setEnabled(false);
    }
}