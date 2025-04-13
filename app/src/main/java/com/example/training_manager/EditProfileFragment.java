package com.example.training_manager;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.text.InputFilter;
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

public class EditProfileFragment extends Fragment  {
    public interface OnProfileUpdatedListener {
        void onProfileUpdated();
    }

    private OnProfileUpdatedListener listener;
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

        LinearLayout userName = rootView.findViewById(R.id.userName);
        LinearLayout userWeight = rootView.findViewById(R.id.userWeight);
        LinearLayout userHeight = rootView.findViewById(R.id.userHeight);
        LinearLayout userYears = rootView.findViewById(R.id.userYears);

        TextView tvUserName = rootView.findViewById(R.id.tvUserName);
        TextView tvWeight = rootView.findViewById(R.id.weight_value);
        TextView tvHeight = rootView.findViewById(R.id.height_value);
        TextView tvYears = rootView.findViewById(R.id.age_value);

        tvUserName.setText(PollManager.getInstance().Name);
        tvWeight.setText(PollManager.getInstance().Weight);
        tvHeight.setText(PollManager.getInstance().Height);
        tvYears.setText(PollManager.getInstance().YearBirthday);

        if (tvUserName != null)
            userName.setOnClickListener(v -> showEditDialog(tvUserName, "Змінити нік", 10));
        if (tvWeight != null)
            userWeight.setOnClickListener(v -> showEditDialog(tvWeight, "Змінити вагу", 3));
        if (tvHeight != null)
            userHeight.setOnClickListener(v -> showEditDialog(tvHeight, "Редагувати ріст", 3));
        if (tvYears != null)
            userYears.setOnClickListener(v -> showEditDialog(tvYears, "Редагувати вік", 2));

        saveImage.setOnClickListener(v -> {
            PollManager.getInstance().UpdateData(tvUserName.getText().toString(), tvWeight.getText().toString(), tvHeight.getText().toString(), tvYears.getText().toString());

            if (listener != null) listener.onProfileUpdated();

            if (getFragmentManager() != null) getFragmentManager().popBackStack();
        });

        return rootView;
    }

    private void showEditDialog(TextView textView, String message, int maxLength) {
        LayoutInflater inflater = LayoutInflater.from(requireContext());
        View dialogView = inflater.inflate(R.layout.dialog_edit_text, null);

        EditText input = dialogView.findViewById(R.id.editTextDialog);
        input.setText(textView.getText().toString());

        input.setFilters(new InputFilter[] { new InputFilter.LengthFilter(maxLength) });

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


    public void setOnProfileUpdatedListener(OnProfileUpdatedListener listener) {
        this.listener = listener;
    }

}