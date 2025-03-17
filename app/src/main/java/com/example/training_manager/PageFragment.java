package com.example.training_manager;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class PageFragment  extends Fragment {
    private int pageNumber;

    public static PageFragment newInstance(int page) {
        PageFragment fragment = new PageFragment();
        Bundle args=new Bundle();
        args.putInt("num", page);
        fragment.setArguments(args);
        return fragment;
    }

    public PageFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pageNumber = getArguments() != null ? getArguments().getInt("num") : 1;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        int layoutId = 0;
        switch (pageNumber) {
            case 0:
                layoutId = R.layout.onboarding_screen_1;
                break;
            case 1:
                layoutId = R.layout.onboarding_screen_2;
                break;
        }

        View result = inflater.inflate(layoutId, container, false);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) TextView pageHeader = result.findViewById(R.id.displayText);
        String header = "Фрагмент " + (pageNumber + 1);
        pageHeader.setText(header);
        return result;
    }

//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//        View result = inflater.inflate(R.layout.onboarding_screen_1, container, false);
//        TextView pageHeader = result.findViewById(R.id.displayText);
//        String header = "Фрагмент " + (pageNumber+1);
//        pageHeader.setText(header);
//        return result;
//    }
}
