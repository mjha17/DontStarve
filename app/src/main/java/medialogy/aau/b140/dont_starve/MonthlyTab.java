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

public class MonthlyTab extends Fragment {

    CalendarView calendarView;
    TextView chosenDate;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        //calendarView = (CalendarView) findViewById(R.id.chosenMonth);
        //chosenDate = (TextView) findViewById(R.id.chosenDate);

        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int i, int i1, int i2) {
                String date = (i1 + 1) + "/" + i2 + "/" + i;
                chosenDate.setText(date);
            }
        });
    }
}