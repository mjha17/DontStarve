package medialogy.aau.b140.dont_starve;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;
import android.widget.TextView;

import java.time.chrono.ChronoLocalDate;
import java.util.GregorianCalendar;

public class MonthlyTab extends Fragment {

    private CalendarView calendarView;

    CalendarActivity calendarActivity;

    public MonthlyTab(){}

    public void setCalendarActivity(CalendarActivity calendarActivity) {
        this.calendarActivity = calendarActivity;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.tab_monthly, container, false);

        calendarView = v.findViewById(R.id.calendarView);

        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int year, int month, int dayOfMonth) {
                calendarActivity.setSelectedDate(new GregorianCalendar(year, month, dayOfMonth));
            }
        });

        return v;
    }

    public CalendarView getCalendarView() {
        return calendarView;
    }
}