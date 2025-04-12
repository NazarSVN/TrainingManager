package com.example.training_manager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

public class PollManager extends AppCompatActivity {
    private static PollManager instance;

    public String Gender = ""; //MALE FEMALE

    public String Name = "";
    public String YearBirthday = "";
    public String Weight = "";
    public String Height = "";

    public String Goal = "";
    public String Experience = "";
    public String BenchPress = "";
    public String Deadlift = "";
    public String Squat= "";
    public String PercentFat = "";

    public int PressVisibility = 0; //1-4 where 1(visible) 4(big belly)
    public int LookOfMuscles = 0; //1-4 where (1 very embossed, there are veins) 4(not pronounced, soft)
    public int WaistShape = 0; // 1-4 where (1 no fat, very dry) and (4 fat hanging above the waist)
    public int Veins = 0; // 1-4 where (1 is a lot of veins) and (2 is no veins at all)

    private PollManager() {}

    public static PollManager getInstance() {
        if (instance == null) {
            instance = new PollManager();
        }
        return instance;
    }

    public double CalculateBodyFat() {
        double weight, height;
        try {
            weight = Double.parseDouble(Weight);
            height = Double.parseDouble(Height);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Неверный формат веса или роста");
        }

        height = height / 100.0;
        double bmi = weight / (height * height);

        int visualScore = PressVisibility + LookOfMuscles + WaistShape + Veins;
        double visualFactor = (visualScore - 4) / 12.0;

        double minFat = Gender.equals("MALE") ? 6 : 14;
        double maxFat = Gender.equals("MALE") ? 25 : 35;

        double bmiFactor = 0.5;
        if (bmi > 25) {
            bmiFactor = 1.2;
        } else if (bmi < 18.5) {
            bmiFactor = 0.8;
        }

        double estimatedBodyFat = minFat + (maxFat - minFat) * visualFactor * bmiFactor;
        PercentFat = String.valueOf((Math.round(estimatedBodyFat * 10.0) / 10.0));
        return Math.round(estimatedBodyFat * 10.0) / 10.0;
    }

    public void onClickMaleGender(ViewPager2 pager, int pageNumber) {
        Gender = "MALE";
        pager.setCurrentItem(pageNumber + 1, true);
    }

    public void onClickFemaleGender(ViewPager2 pager, int pageNumber) {
        Gender = "FEMALE";
        pager.setCurrentItem(pageNumber + 1, true);
    }

    public boolean UpdateData(String name, String surname, String weight, String height, String years){
        return true;
    }
}
