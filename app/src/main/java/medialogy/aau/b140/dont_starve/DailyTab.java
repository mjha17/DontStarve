package medialogy.aau.b140.dont_starve;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class DailyTab extends Fragment {

    private View origin;
    private ListView recipeList;
    private TextView weekday;
    private TextView dayOfMonth;

    private dailyViewAdapter dailyViewAdapter;

    private CalendarActivity calendarActivity;

    public DailyTab(){}

    public void setCalendarActivity(CalendarActivity calendarActivity) {
        this.calendarActivity = calendarActivity;
    }

    public CalendarActivity getCalendarActivity() {
        return calendarActivity;
    }

    public dailyViewAdapter getAdapter() {
        return dailyViewAdapter;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        origin = inflater.inflate(R.layout.tab_daily, container, false);

        weekday = origin.findViewById(R.id.weekday);
        dayOfMonth = origin.findViewById(R.id.today_date);

        recipeList = origin.findViewById(R.id.dailyOverview);
        dailyViewAdapter = new dailyViewAdapter(calendarActivity.getTodaysRecipes(), this);
        recipeList.setAdapter(dailyViewAdapter);

        return origin;
    }

    @Override
    public void onResume() {
        super.onResume();

        updateView();
    }

    public void updateView(){
        if(weekday != null && dayOfMonth != null) {
            weekday.setText(new SimpleDateFormat("EEEE", Locale.ENGLISH).format(calendarActivity.getSelectedDate().getTime()));
            dayOfMonth.setText(new SimpleDateFormat("MMMM d", Locale.ENGLISH).format(calendarActivity.getSelectedDate().getTime()));
        }
    }

    public TextView getWeekday() {
        return weekday;
    }

    public TextView getDayOfMonth() {
        return dayOfMonth;
    }
}
