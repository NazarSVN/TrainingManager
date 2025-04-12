package com.example.training_manager;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.os.Build;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowInsets;
import android.view.WindowInsetsController;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.WindowCompat;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MainActivity extends AppCompatActivity {
    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SetFlags();
        ShowMainPage();
//        FirstTestPager();

    }

    private void FirstTestPager() {
        ViewPager2 pager = findViewById(R.id.pager);
        FragmentStateAdapter pageAdapter = new MyAdapter(this);
        pager.setAdapter(pageAdapter);
        Set<Integer> noSwipePages = new HashSet<>(Arrays.asList(2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18));

        pager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                pager.setUserInputEnabled(!noSwipePages.contains(position));
            }
        });

        pager.setAdapter(pageAdapter);
        pager.setPageTransformer((page, position) -> {
            float scaleFactor = 0.7f + (1 - 0.7f) * (1 - Math.abs(position));
            page.setScaleX(scaleFactor);
            page.setScaleY(scaleFactor);
        });

        pager.getViewTreeObserver().addOnPreDrawListener(() -> {
            if (pager.getVisibility() == View.VISIBLE) {
            } else if (pager.getVisibility() == View.GONE) {
                ShowMainPage();
            }
            return true;
        });
    }

    public void ShowMainPage(){
        loadFragment(new HomeFragment());
        ImageView temp = this.findViewById(R.id.bottom_panel);
        if (temp != null)
            temp.setImageResource(R.drawable.home_bar);

        FrameLayout frameLayout = findViewById(R.id.fragment_container);
        ImageView bottom_panel = findViewById(R.id.bottom_panel);
        ImageView iconHome = findViewById(R.id.image1);
        ImageView iconHot = findViewById(R.id.image2);
        ImageView iconCalendar = findViewById(R.id.image3);

        if (frameLayout != null && bottom_panel != null && iconHome != null && iconHot != null && iconCalendar != null) {
            frameLayout.setVisibility(View.VISIBLE);
            bottom_panel.setVisibility(View.VISIBLE);
            iconHome.setVisibility(View.VISIBLE);
            iconHot.setVisibility(View.VISIBLE);
            iconCalendar.setVisibility(View.VISIBLE);
        }

        ImageView i = this.findViewById(R.id.bottom_panel);
        if (i == null)
            return;

        iconHome.setOnClickListener(v -> {
            loadFragment(new HomeFragment());
            i.setImageResource(R.drawable.home_bar);
        });
        iconHot.setOnClickListener(v -> {
            loadFragment(new FireFragment());
            i.setImageResource(R.drawable.fire_bar);
        });
        iconCalendar.setOnClickListener(v -> {
            loadFragment(new CalendarFragment());
            i.setImageResource(R.drawable.calendar_bar);
        });
    }

    private void SetFlags() {
        Window window = getWindow();

        WindowCompat.setDecorFitsSystemWindows(window, false);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
            getWindow().getAttributes().layoutInDisplayCutoutMode =
                    WindowManager.LayoutParams.LAYOUT_IN_DISPLAY_CUTOUT_MODE_SHORT_EDGES;
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            WindowInsetsController insetsController = window.getInsetsController();
            if (insetsController != null) {
                insetsController.show(WindowInsets.Type.statusBars());
                insetsController.hide(WindowInsets.Type.navigationBars());
            }
        } else {
            window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
            window.getDecorView().setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE |
                            View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN |
                            View.SYSTEM_UI_FLAG_HIDE_NAVIGATION |
                            View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
            );
        }

        window.addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
    }

    private void loadFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .commit();
    }
}