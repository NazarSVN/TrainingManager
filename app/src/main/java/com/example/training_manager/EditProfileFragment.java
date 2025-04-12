package com.example.training_manager;

import android.app.AlertDialog;
import android.os.Bundle;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

public class EditProfileFragment extends Fragment {
    View RootView;

    public EditProfileFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.edit_profile_page, container, false);
        ImageView imageView = rootView.findViewById(R.id.cancel_btn);
        ImageView saveImage = rootView.findViewById(R.id.save_image);
        RootView = rootView;

        imageView.setOnClickListener(v -> {
            if (getFragmentManager() != null) {
                getFragmentManager().popBackStack();
            }
        });

        saveImage.setOnClickListener(v -> {
            // ЗБЕРЕЖЕННЯ ДАННИХ ЯКІ ВІДРЕДАГОВАНІ
            if (getFragmentManager() != null) {
                getFragmentManager().popBackStack();
            }
        });

        LinearLayout userName = rootView.findViewById(R.id.userName);
        LinearLayout userSurname = rootView.findViewById(R.id.userSurname);
        LinearLayout userWeight = rootView.findViewById(R.id.userWeight);
        LinearLayout userHeight = rootView.findViewById(R.id.userHeight);
        LinearLayout userYears = rootView.findViewById(R.id.userYears);

        TextView tvUserName = rootView.findViewById(R.id.tvUserName);
        TextView tvUserSurname = rootView.findViewById(R.id.tvUserSurname);
        TextView tvWeight = rootView.findViewById(R.id.weight_value);
        TextView tvHeight = rootView.findViewById(R.id.height_value);
        TextView tvYears = rootView.findViewById(R.id.age_value);

        if (tvUserName != null)
            userName.setOnClickListener(v -> showEditDialog(tvUserName, "Змінити ім'я"));
        if (tvUserSurname != null)
            userSurname.setOnClickListener(v -> showEditDialog(tvUserSurname, "Змінити фамілію"));
        if (tvWeight != null)
            userWeight.setOnClickListener(v -> showEditDialog(tvWeight, "Змінити вагу"));
        if (tvHeight != null)
            userHeight.setOnClickListener(v -> showEditDialog(tvHeight, "Редагувати ріст"));
        if (tvYears != null)
            userYears.setOnClickListener(v -> showEditDialog(tvYears, "Редагувати вік"));

        return rootView;
    }

    private void showEditDialog(TextView textView, String message) {
        LayoutInflater inflater = LayoutInflater.from(requireContext());
        View dialogView = inflater.inflate(R.layout.dialog_edit_text, null);

        EditText input = dialogView.findViewById(R.id.editTextDialog);
        input.setText(textView.getText().toString());

        AlertDialog.Builder builder = new AlertDialog.Builder(requireContext(), R.style.CustomDialogStyle);
        builder.setTitle(message);
        builder.setView(dialogView);

        builder.setPositiveButton("ОК", (dialog, which) -> {
            String newText = input.getText().toString();
            textView.setText(newText);
        });

        builder.setNegativeButton("Скасувати", (dialog, which) -> dialog.dismiss());

        AlertDialog dialog = builder.create();
        dialog.show();

        dialog.getButton(AlertDialog.BUTTON_POSITIVE)
                .setTextColor(ContextCompat.getColor(requireContext(), R.color.primary));
        dialog.getButton(AlertDialog.BUTTON_NEGATIVE)
                .setTextColor(ContextCompat.getColor(requireContext(), R.color.gray));
    }
}