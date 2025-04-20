package com.example.training_manager;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.fragment.app.Fragment;

public class SupportFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.support, container, false);

        EditText problemInput = rootView.findViewById(R.id.problemInput);
        problemInput.setMovementMethod(new ScrollingMovementMethod());

        return rootView;
    }
}
