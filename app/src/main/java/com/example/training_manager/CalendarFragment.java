package com.example.training_manager;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.applandeo.materialcalendarview.CalendarView;
import com.applandeo.materialcalendarview.EventDay;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class CalendarFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.activity_calendar_fragment, container, false);
        CalendarView calendarView = root.findViewById(R.id.calendarView);

        markMondayWednesdayFriday(calendarView);
        return root;
    }
    public static void markMondayWednesdayFriday(CalendarView calendarView) {
        List<EventDay> events = new ArrayList<>();

        Calendar calendar = Calendar.getInstance();

        calendar.set(Calendar.DAY_OF_MONTH, 1);

        int month = calendar.get(Calendar.MONTH);

        while (calendar.get(Calendar.MONTH) == month) {
            int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);

            if (dayOfWeek == Calendar.MONDAY ||
                    dayOfWeek == Calendar.WEDNESDAY ||
                    dayOfWeek == Calendar.FRIDAY) {

                events.add(new EventDay((Calendar) calendar.clone(), R.drawable.flash_icon));
            }

            calendar.add(Calendar.DAY_OF_MONTH, 1);
        }

        calendarView.setEvents(events);
    }
}