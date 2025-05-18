package com.example.training_manager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import java.util.Arrays;
import java.util.Calendar;

public class PollManager extends AppCompatActivity {
    private static PollManager instance;

    public String Gender = ""; //MALE FEMALE

    public String Name = "Назаренко";
    public String YearBirthday = "19";
    public String Weight = "89";
    public String Height = "182";

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

    public void setName(String name) {
        this.Name = name;
        if (listener != null) {
            listener.onNameChanged(name);
        }
    }

    private OnNameChangeListener listener;
    public interface OnNameChangeListener {
        void onNameChanged(String newName);
    }

    public void setOnNameChangeListener(OnNameChangeListener listener) {
        this.listener = listener;
    }

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

    public boolean UpdateData(String name, String weight, String height, String years){
        if (name == null || name.trim().isEmpty())
            return false;
        if (name.length() >= 14)
            return false;

        int yearInt = Integer.parseInt(years);
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        years = String.valueOf(currentYear - yearInt);

        try {
             if (Arrays.asList(heightArr).contains(height) && Arrays.asList(weightArr).contains(weight) && Arrays.asList(yearsBirthdayArr).contains(years)){
                 setName(name);
                 Weight = weight;
                 Height = height;
                 YearBirthday = String.valueOf(yearInt);

                return true;
            }

        } catch (NumberFormatException e) {
            return false;
        }

        return true;
    }


    private final String[] heightArr = new String[]{
        "130", "131", "132", "133", "134", "135", "136", "137", "138", "139",
        "140", "141", "142", "143", "144", "145", "146", "147", "148", "149",
        "150", "151", "152", "153", "154", "155", "156", "157", "158", "159",
        "160", "161", "162", "163", "164", "165", "166", "167", "168", "169",
        "170", "171", "172", "173", "174", "175", "176", "177", "178", "179",
        "180", "181", "182", "183", "184", "185", "186", "187", "188", "189",
        "190", "191", "192", "193", "194", "195", "196", "197", "198", "199",
        "200", "201", "202", "203", "204", "205", "206", "207", "208", "209",
        "210", "211", "212", "213", "214", "215", "216", "217", "218", "219",
        "220"
    };

    private final String[] weightArr = new String[]{
        "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59", "60",
        "61", "62", "63", "64", "65", "66", "67", "68", "69", "70", "71", "72", "73", "74", "75", "76",
        "77", "78", "79", "80", "81", "82", "83", "84", "85", "86", "87", "88", "89", "90", "91", "92",
        "93", "94", "95", "96", "97", "98", "99", "100", "101", "102", "103", "104", "105", "106", "107",
        "108", "109", "110", "111", "112", "113", "114", "115", "116", "117", "118", "119", "120", "121",
        "122", "123", "124", "125", "126", "127", "128", "129", "130", "131", "132", "133", "134", "135",
        "136", "137", "138", "139", "140", "141", "142", "143", "144", "145", "146", "147", "148", "149",
        "150", "151", "152", "153", "154", "155", "156", "157", "158", "159", "160", "161", "162", "163",
        "164", "165", "166", "167", "168", "169", "170", "171", "172", "173", "174", "175", "176", "177",
        "178", "179", "180", "181", "182", "183", "184", "185", "186", "187", "188", "189", "190", "191",
        "192", "193", "194", "195", "196", "197", "198", "199", "200", "201", "202", "203", "204", "205",
        "206", "207", "208", "209", "210", "211", "212", "213", "214", "215", "216", "217", "218", "219",
        "220"
    };

    private final String[] yearsBirthdayArr = new String[]{
            "1961", "1962", "1963", "1964", "1965", "1966", "1967", "1968", "1969",
            "1970", "1971", "1972", "1973", "1974", "1975", "1976", "1977", "1978",
            "1979", "1980", "1981", "1982", "1983", "1984", "1985", "1986", "1987",
            "1988", "1989", "1990", "1991", "1992", "1993", "1994", "1995", "1996",
            "1997", "1998", "1999", "2000", "2001", "2002", "2003", "2004", "2005",
            "2006", "2007", "2008", "2009", "2010", "2011"
    };
}
