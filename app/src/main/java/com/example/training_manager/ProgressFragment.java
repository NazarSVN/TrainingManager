package com.example.training_manager;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class ProgressFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.progress, container, false);

        ImageView editProfile = rootView.findViewById(R.id.editProfileIcon);
        if (editProfile != null){
            editProfile.setOnClickListener(v -> {
                EditProfileFragment editFragment = new EditProfileFragment();
                FragmentTransaction transaction = getParentFragment().getParentFragmentManager().beginTransaction();                transaction.replace(R.id.fragment_container, editFragment);
                transaction.addToBackStack(null);
                transaction.commit();
            });
        }
        return rootView;
    }
}
