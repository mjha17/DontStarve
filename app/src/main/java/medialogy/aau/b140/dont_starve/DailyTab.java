package medialogy.aau.b140.dont_starve;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

public class DailyTab extends Fragment {

    private View origin;
    private TextView weekday;
    private TextView dayOfMonth;

    public DailyTab(){}

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        origin = inflater.inflate(R.layout.tab_daily, container, false);

        weekday = origin.findViewById(R.id.weekday);
        dayOfMonth = origin.findViewById(R.id.today_date);

        return origin;
    }

    public TextView getWeekday() {
        return weekday;
    }

    public TextView getDayOfMonth() {
        return dayOfMonth;
    }
}
