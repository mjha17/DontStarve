package medialogy.aau.b140.dont_starve;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Calendar;

public class DailyTab extends Fragment {

    private View origin;
    private TextView weekday;
    private TextView dayOfMonth;

    CalendarActivity calendarActivity;

    public DailyTab(){}

    public void setCalendarActivity(CalendarActivity calendarActivity) {
        this.calendarActivity = calendarActivity;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        origin = inflater.inflate(R.layout.tab_daily, container, false);

        weekday = origin.findViewById(R.id.weekday);
        dayOfMonth = origin.findViewById(R.id.today_date);

        return origin;
    }

    @Override
    public void onResume() {
        super.onResume();

        if(weekday != null && dayOfMonth != null) {
            weekday.setText(Integer.toString(calendarActivity.getSelectedDate().get(Calendar.DAY_OF_WEEK)));
            dayOfMonth.setText(Integer.toString(calendarActivity.getSelectedDate().get(Calendar.MONTH)) + Integer.toString(calendarActivity.getSelectedDate().get(Calendar.DATE)));
        }
    }

    public TextView getWeekday() {
        return weekday;
    }

    public TextView getDayOfMonth() {
        return dayOfMonth;
    }
}
