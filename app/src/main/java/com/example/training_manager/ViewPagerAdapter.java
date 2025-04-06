package com.example.training_manager;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class ViewPagerAdapter extends FragmentStateAdapter {
    public ViewPagerAdapter(@NonNull Fragment fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return new ProgressFragment();
            case 1:
                return new SupportFragment();
            case 2:
                return new InstructionFragment();
            default:
                return new ProgressFragment();
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
