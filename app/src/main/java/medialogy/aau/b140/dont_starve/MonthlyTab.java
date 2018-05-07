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

public class MonthlyTab extends Fragment {

    private CalendarView calendarView;

    public MonthlyTab(){}

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.tab_monthly, container, false);

        calendarView = v.findViewById(R.id.calendarView);

        return v;
    }

    public CalendarView getCalendarView() {
        return calendarView;
    }
}