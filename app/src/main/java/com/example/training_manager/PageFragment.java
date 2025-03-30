package com.example.training_manager;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import com.shawnlin.numberpicker.NumberPicker;

public class PageFragment  extends Fragment {
    private int pageNumber;
    public PollManager pollManager = new PollManager();


    public static PageFragment newInstance(int page) {
        PageFragment fragment = new PageFragment();
        Bundle args=new Bundle();
        args.putInt("num", page);
        fragment.setArguments(args);
        return fragment;
    }

    public PageFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pageNumber = getArguments() != null ? getArguments().getInt("num") : 1;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        int layoutId = 0;
        switch (pageNumber) {
            case 0:
                layoutId = R.layout.onboarding_screen_1;
                break;
            case 1:
                layoutId = R.layout.onboarding_screen_2;
                break;
            case 2:
                layoutId = R.layout.onboarding_screen_3;
                break;
            case 3:
                layoutId = R.layout.onboarding_screen_4;
                break;
            case 4:
                layoutId = R.layout.onboarding_screen_5;
                break;
            case 5:
                layoutId = R.layout.onboarding_screen_6;
                break;
            case 6:
                layoutId = R.layout.onboarding_screen_7;
                break;
            case 7:
                layoutId = R.layout.onboarding_screen_8;
                break;
            case 8:
                layoutId = R.layout.onboarding_screen_9;
                break;
            case 9:
                layoutId = R.layout.onboarding_screen_10;
                break;
            case 10:
                layoutId = R.layout.onboarding_screen_11;
                break;
            case 11:
                layoutId = R.layout.onboarding_screen_12;
                break;
            case 12:
                layoutId = R.layout.onboarding_screen_13;
        }

        View view = inflater.inflate(layoutId, container, false);
        ViewPager2 pager = requireActivity().findViewById(R.id.pager);

        SetGender(view, pager);
        SetName(view, pager);
        SetYearBirthday(view, pager);
        SetWeight(view, pager);
        SetHeight(view, pager);
        SetGoal(view, pager);
        SetExperience(view, pager);
        SetBenchpressResult(view, pager);
        SetDeadliftResult(view, pager);
        SetSquatResult(view, pager);
        SetProcentFat(view, pager);

        @SuppressLint({"MissingInflatedId", "LocalSuppress"})
        ImageButton nextButton = view.findViewById(R.id.next_button);
        if (nextButton != null) {
            nextButton.setOnClickListener(v -> {
                pager.setCurrentItem(pageNumber + 1, true);
            });
        }

        return view;
    }

    public void SetProcentFat(View view, ViewPager2 pager){
        SeekBar seekBar = view.findViewById(R.id.seekBar);
        TextView tvPercentage = view.findViewById(R.id.tvPercentage);

        if (seekBar == null && tvPercentage == null)
            return;

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                tvPercentage.setText("("+ progress + "%" + ")");
                pollManager.PercentFat = String.valueOf(progress);
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });
    }

    public void SetSquatResult(View view, ViewPager2 pager) {
        NumberPicker picker = view.findViewById(R.id.squat_picker);
        ImageButton newPage = view.findViewById(R.id.next_button_squat);

        ImageButton upButton = view.findViewById(R.id.button_top_squat);
        ImageButton downButton = view.findViewById(R.id.button_bottom_squat);

        if (picker == null) {
            return;
        }

        String[] data = new String[]{
                "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55",
                "56", "57", "58", "59", "60", "61", "62", "63", "64", "65", "66", "67", "68", "69", "70", "71",
                "72", "73", "74", "75", "76", "77", "78", "79", "80", "81", "82", "83", "84", "85", "86", "87",
                "88", "89", "90", "91", "92", "93", "94", "95", "96", "97", "98", "99", "100", "101", "102",
                "103", "104", "105", "106", "107", "108", "109", "110", "111", "112", "113", "114", "115",
                "116", "117", "118", "119", "120", "121", "122", "123", "124", "125", "126", "127", "128",
                "129", "130", "131", "132", "133", "134", "135", "136", "137", "138", "139", "140", "141",
                "142", "143", "144", "145", "146", "147", "148", "149", "150", "151", "152", "153", "154",
                "155", "156", "157", "158", "159", "160", "161", "162", "163", "164", "165", "166", "167",
                "168", "169", "170", "171", "172", "173", "174", "175", "176", "177", "178", "179", "180",
                "181", "182", "183", "184", "185", "186", "187", "188", "189", "190", "191", "192", "193",
                "194", "195", "196", "197", "198", "199", "200", "201", "202", "203", "204", "205", "206",
                "207", "208", "209", "210", "211", "212", "213", "214", "215", "216", "217", "218", "219",
                "220", "221", "222", "223", "224", "225", "226", "227", "228", "229", "230", "231", "232",
                "233", "234", "235", "236", "237", "238", "239", "240", "241", "242", "243", "244", "245",
                "246", "247", "248", "249", "250", "251", "252", "253", "254", "255", "256", "257", "258",
                "259", "260", "261", "262", "263", "264", "265", "266", "267", "268", "269", "270", "271",
                "272", "273", "274", "275", "276", "277", "278", "279", "280", "281", "282", "283", "284",
                "285", "286", "287", "288", "289", "290", "291", "292", "293", "294", "295", "296", "297",
                "298", "299", "300", "301", "302", "303", "304", "305", "306", "307", "308", "309", "310",
                "311", "312", "313", "314", "315", "316", "317", "318", "319", "320", "321", "322", "323",
                "324", "325", "326", "327", "328", "329", "330", "331", "332", "333", "334", "335", "336",
                "337", "338", "339", "340", "341", "342", "343", "344", "345", "346", "347", "348", "349", "350"
        };

        picker.setMinValue(0);
        picker.setMaxValue(data.length - 1);
        picker.setValue(data.length-1);
        picker.setDisplayedValues(data);

        newPage.setOnClickListener(v -> {
            int value = picker.getValue();
            pollManager.Squat = data[value];
            pager.setCurrentItem(pageNumber + 1, true);
        });

        upButton.setOnClickListener(v -> {
            picker.setValue(picker.getValue()-1);
        });

        downButton.setOnClickListener(v -> {
            picker.setValue(picker.getValue()+1);
        });
    }

    public void SetDeadliftResult(View view, ViewPager2 pager) {
        NumberPicker picker = view.findViewById(R.id.deadlift_picker);
        ImageButton newPage = view.findViewById(R.id.next_button_deadlift);

        ImageButton upButton = view.findViewById(R.id.button_top_deadlift);
        ImageButton downButton = view.findViewById(R.id.button_bottom_deadlift);

        if (picker == null) {
            return;
        }

        String[] data = new String[]{
                "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55",
                "56", "57", "58", "59", "60", "61", "62", "63", "64", "65", "66", "67", "68", "69", "70", "71",
                "72", "73", "74", "75", "76", "77", "78", "79", "80", "81", "82", "83", "84", "85", "86", "87",
                "88", "89", "90", "91", "92", "93", "94", "95", "96", "97", "98", "99", "100", "101", "102",
                "103", "104", "105", "106", "107", "108", "109", "110", "111", "112", "113", "114", "115",
                "116", "117", "118", "119", "120", "121", "122", "123", "124", "125", "126", "127", "128",
                "129", "130", "131", "132", "133", "134", "135", "136", "137", "138", "139", "140", "141",
                "142", "143", "144", "145", "146", "147", "148", "149", "150", "151", "152", "153", "154",
                "155", "156", "157", "158", "159", "160", "161", "162", "163", "164", "165", "166", "167",
                "168", "169", "170", "171", "172", "173", "174", "175", "176", "177", "178", "179", "180",
                "181", "182", "183", "184", "185", "186", "187", "188", "189", "190", "191", "192", "193",
                "194", "195", "196", "197", "198", "199", "200", "201", "202", "203", "204", "205", "206",
                "207", "208", "209", "210", "211", "212", "213", "214", "215", "216", "217", "218", "219",
                "220", "221", "222", "223", "224", "225", "226", "227", "228", "229", "230", "231", "232",
                "233", "234", "235", "236", "237", "238", "239", "240", "241", "242", "243", "244", "245",
                "246", "247", "248", "249", "250", "251", "252", "253", "254", "255", "256", "257", "258",
                "259", "260", "261", "262", "263", "264", "265", "266", "267", "268", "269", "270", "271",
                "272", "273", "274", "275", "276", "277", "278", "279", "280", "281", "282", "283", "284",
                "285", "286", "287", "288", "289", "290", "291", "292", "293", "294", "295", "296", "297",
                "298", "299", "300", "301", "302", "303", "304", "305", "306", "307", "308", "309", "310",
                "311", "312", "313", "314", "315", "316", "317", "318", "319", "320", "321", "322", "323",
                "324", "325", "326", "327", "328", "329", "330", "331", "332", "333", "334", "335", "336",
                "337", "338", "339", "340", "341", "342", "343", "344", "345", "346", "347", "348", "349", "350"
        };

        picker.setMinValue(0);
        picker.setMaxValue(data.length - 1);
        picker.setValue(data.length-1);
        picker.setDisplayedValues(data);

        newPage.setOnClickListener(v -> {
            int value = picker.getValue();
            pollManager.Deadlift = data[value];
            pager.setCurrentItem(pageNumber + 1, true);
        });

        upButton.setOnClickListener(v -> {
            picker.setValue(picker.getValue()-1);
        });

        downButton.setOnClickListener(v -> {
            picker.setValue(picker.getValue()+1);
        });
    }

    public void SetBenchpressResult(View view, ViewPager2 pager) {
        NumberPicker picker = view.findViewById(R.id.benchpress_picker);
        ImageButton newPage = view.findViewById(R.id.next_button_benchpress);

        ImageButton upButton = view.findViewById(R.id.button_top_benchpress);
        ImageButton downButton = view.findViewById(R.id.button_bottom_benchpress);

        if (picker == null) {
            return;
        }

        String[] data = new String[] {
                "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35",
                "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51",
                "52", "53", "54", "55", "56", "57", "58", "59", "60", "61", "62", "63", "64", "65", "66", "67",
                "68", "69", "70", "71", "72", "73", "74", "75", "76", "77", "78", "79", "80", "81", "82", "83",
                "84", "85", "86", "87", "88", "89", "90", "91", "92", "93", "94", "95", "96", "97", "98", "99",
                "100", "101", "102", "103", "104", "105", "106", "107", "108", "109", "110", "111", "112", "113",
                "114", "115", "116", "117", "118", "119", "120", "121", "122", "123", "124", "125", "126", "127",
                "128", "129", "130", "131", "132", "133", "134", "135", "136", "137", "138", "139", "140", "141",
                "142", "143", "144", "145", "146", "147", "148", "149", "150", "151", "152", "153", "154", "155",
                "156", "157", "158", "159", "160", "161", "162", "163", "164", "165", "166", "167", "168", "169",
                "170", "171", "172", "173", "174", "175", "176", "177", "178", "179", "180", "181", "182", "183",
                "184", "185", "186", "187", "188", "189", "190", "191", "192", "193", "194", "195", "196", "197",
                "198", "199", "200", "201", "202", "203", "204", "205", "206", "207", "208", "209", "210", "211",
                "212", "213", "214", "215", "216", "217", "218", "219", "220", "221", "222", "223", "224", "225",
                "226", "227", "228", "229", "230", "231", "232", "233", "234", "235", "236", "237", "238", "239",
                "240", "241", "242", "243", "244", "245", "246", "247", "248", "249", "250"
        };

        picker.setMinValue(0);
        picker.setMaxValue(data.length - 1);
        picker.setValue(data.length-1);
        picker.setDisplayedValues(data);

        newPage.setOnClickListener(v -> {
            int value = picker.getValue();
            pollManager.BenchPress = data[value];
            pager.setCurrentItem(pageNumber + 1, true);
        });

        upButton.setOnClickListener(v -> {
            picker.setValue(picker.getValue()-1);
        });

        downButton.setOnClickListener(v -> {
            picker.setValue(picker.getValue()+1);
        });
    }

    public  void SetExperience(View view, ViewPager2 pager){
        CardView newcomer = view.findViewById(R.id.NewcomerButton);
        CardView baseButton = view.findViewById(R.id.BaseButton);
        CardView advanced = view.findViewById(R.id.AdvancedButton);
        CardView pro = view.findViewById(R.id.ProButton);

        if (newcomer == null && baseButton == null && advanced == null & pro == null){
            return;
        }

        newcomer.setOnClickListener(v -> {
            pollManager.Experience = "NewComer";
            pager.setCurrentItem(pageNumber + 1, true);
        });

        baseButton.setOnClickListener(v -> {
            pollManager.Experience = "Base";
            pager.setCurrentItem(pageNumber + 1, true);
        });

        advanced.setOnClickListener(v -> {
            pollManager.Experience = "Advanced";
            pager.setCurrentItem(pageNumber + 1, true);
        });

        pro.setOnClickListener(v -> {
            pollManager.Experience = "Pro";
            pager.setCurrentItem(pageNumber + 1, true);
        });
    }

    public void SetGoal(View view, ViewPager2 pager) {
        CardView power = view.findViewById(R.id.PowerButton);
        CardView massUp = view.findViewById(R.id.MussUpButton);
        CardView relief = view.findViewById(R.id.ReliefButton);
        CardView functionality = view.findViewById(R.id.FunctionalityButton);

        if (power == null && massUp == null && relief == null & functionality == null){
            return;
        }

        power.setOnClickListener(v -> {
            pollManager.Goal = "Power";
            pager.setCurrentItem(pageNumber + 1, true);
        });

        massUp.setOnClickListener(v -> {
            pollManager.Goal = "MassUp";
            pager.setCurrentItem(pageNumber + 1, true);
        });

        relief.setOnClickListener(v -> {
            pollManager.Goal = "Relief";
            pager.setCurrentItem(pageNumber + 1, true);
        });

        functionality.setOnClickListener(v -> {
            pollManager.Goal = "Functionality";
            pager.setCurrentItem(pageNumber + 1, true);
        });
    }

    public void SetHeight(View view, ViewPager2 pager) {
        NumberPicker picker = view.findViewById(R.id.height_picker);
        ImageButton newPage = view.findViewById(R.id.next_button_check_height);

        ImageButton upButton = view.findViewById(R.id.button_top_height);
        ImageButton downButton = view.findViewById(R.id.button_bottom_height);

        if (picker == null) {
            return;
        }

        String[] data = new String[]{
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

        picker.setMinValue(0);
        picker.setMaxValue(data.length - 1);
        picker.setValue(data.length-1);
        picker.setDisplayedValues(data);

        newPage.setOnClickListener(v -> {
            int value = picker.getValue();
            pollManager.Height = data[value];
            pager.setCurrentItem(pageNumber + 1, true);
        });

        upButton.setOnClickListener(v -> {
            picker.setValue(picker.getValue()-1);
        });

        downButton.setOnClickListener(v -> {
            picker.setValue(picker.getValue()+1);
        });
    }

    public void SetWeight(View view, ViewPager2 pager){
        NumberPicker picker = view.findViewById(R.id.weight_picker);
        ImageButton newPage = view.findViewById(R.id.next_button_check_weight);

        ImageButton upButton = view.findViewById(R.id.button_top_weight);
        ImageButton downButton = view.findViewById(R.id.button_bottom_weight);

        if (picker == null) {
            return;
        }

        String[] data = new String[]{
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

        picker.setMinValue(0);
        picker.setMaxValue(data.length - 1);
        picker.setValue(data.length-1);
        picker.setDisplayedValues(data);

        newPage.setOnClickListener(v -> {
            int value = picker.getValue();
            pollManager.Weight = data[value];
            pager.setCurrentItem(pageNumber + 1, true);
        });

        upButton.setOnClickListener(v -> {
            picker.setValue(picker.getValue()-1);
        });

        downButton.setOnClickListener(v -> {
            picker.setValue(picker.getValue()+1);
        });
    }

    public void SetYearBirthday(View view, ViewPager2 pager){
        NumberPicker picker = view.findViewById(R.id.number_picker);
        ImageButton newPage = view.findViewById(R.id.next_button_check_birthday);

        ImageButton upButton = view.findViewById(R.id.button_top);
        ImageButton downButton = view.findViewById(R.id.button_bottom);

        if (picker == null) {
            return;
        }

        String[] data = new String[]{
                "1961", "1962", "1963", "1964", "1965", "1966", "1967", "1968", "1969",
                "1970", "1971", "1972", "1973", "1974", "1975", "1976", "1977", "1978",
                "1979", "1980", "1981", "1982", "1983", "1984", "1985", "1986", "1987",
                "1988", "1989", "1990", "1991", "1992", "1993", "1994", "1995", "1996",
                "1997", "1998", "1999", "2000", "2001", "2002", "2003", "2004", "2005",
                "2006", "2007", "2008", "2009", "2010", "2011"
        };

        picker.setMinValue(0);
        picker.setMaxValue(data.length - 1);
        picker.setValue(data.length-1);
        picker.setDisplayedValues(data);

        newPage.setOnClickListener(v -> {
            int value = picker.getValue();
            pollManager.YearBirthday = data[value];
            pager.setCurrentItem(pageNumber + 1, true);
        });

        upButton.setOnClickListener(v -> {
            picker.setValue(picker.getValue()-1);
        });

        downButton.setOnClickListener(v -> {
            picker.setValue(picker.getValue()+1);
        });
    }

    public void SetName(View view, ViewPager2 pager){
        EditText editText = view.findViewById(R.id.editTextName);
        ImageButton imageButton = view.findViewById(R.id.next_button_check_name);

        if (imageButton != null && editText != null && pollManager != null) {
            imageButton.setVisibility(View.INVISIBLE);
            imageButton.setEnabled(false);
        }
        else {
            return;
        }

        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int start, int count, int after) {}
            @Override
            public void onTextChanged(CharSequence charSequence, int start, int before, int after) {
            String newText = charSequence.toString().trim();
                if (!newText.isEmpty()) {
                    imageButton.setEnabled(true);
                    imageButton.setVisibility(View.VISIBLE);
                    imageButton.setOnClickListener(v -> {
                        pager.setCurrentItem(pageNumber + 1, true);
                        pollManager.Name = newText;
                    });
                }
                else{
                    imageButton.setVisibility(View.INVISIBLE);
                    imageButton.setEnabled(false);
                }
            }
            @Override
            public void afterTextChanged(Editable s) {}
        });
    }

    public void SetGender(View view, ViewPager2 pager){
        View maleButton = view.findViewById(R.id.male_button);
        View femaleButton = view.findViewById(R.id.female_button);

        if (maleButton != null && pollManager != null) {
            maleButton.setOnClickListener(v -> pollManager.onClickMaleGender(pager, pageNumber));
        }

        if (femaleButton != null && pollManager != null) {
            femaleButton.setOnClickListener(v -> pollManager.onClickFemaleGender(pager, pageNumber));
        }
    }
}
