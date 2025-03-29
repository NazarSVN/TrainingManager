package com.example.training_manager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

public class PollManager extends AppCompatActivity {
    public String Gender = "";
    public String Name = "";
    public String YearBirthday = "";
    public String Weight = "";
    public String Height = "";


    public void onClickMaleGender(ViewPager2 pager, int pageNumber) {
        Gender = "MALE";
        pager.setCurrentItem(pageNumber + 1, true);
    }

    public void onClickFemaleGender(ViewPager2 pager, int pageNumber) {
        Gender = "FEMALE";
        pager.setCurrentItem(pageNumber + 1, true);
    }
}
