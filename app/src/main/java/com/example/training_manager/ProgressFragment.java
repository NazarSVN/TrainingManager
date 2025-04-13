package com.example.training_manager;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class ProgressFragment extends Fragment {
    public View RootView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.progress, container, false);

        ImageView editProfile = rootView.findViewById(R.id.editProfileIcon);
        if (editProfile != null){
            editProfile.setOnClickListener(v -> {
                EditProfileFragment editFragment = new EditProfileFragment();
                editFragment.setOnProfileUpdatedListener(() -> UpdateData(rootView));
                FragmentTransaction transaction = getParentFragment().getParentFragmentManager().beginTransaction();                transaction.replace(R.id.fragment_container, editFragment);
                transaction.addToBackStack(null);
                transaction.commit();
            });
        }
        UpdateData(rootView);
        RootView = rootView;
        return rootView;
    }

    public void UpdateData(View v){
        TextView userName = v.findViewById(R.id.userName);
        TextView weight = v.findViewById(R.id.weight_value);
        TextView height = v.findViewById(R.id.height_value);
        TextView years = v.findViewById(R.id.age_value);

        userName.setText(PollManager.getInstance().Name);
        weight.setText(PollManager.getInstance().Weight);
        height.setText(PollManager.getInstance().Height);
        years.setText(PollManager.getInstance().YearBirthday);
    }
}
