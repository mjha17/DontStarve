package medialogy.aau.b140.dont_starve;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class CalendarActivity extends AppCompatActivity {

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */

    private Calendar[] plannedDays;
    private ArrayList<RecipeListItem> todaysRecipes = new ArrayList<>();

    private Calendar currentDate;
    private Calendar selectedDate;

    private MonthlyTab mt;
    private DailyTab dt;
    private SectionsPagerAdapter mSectionsPagerAdapter;

    private ArrayList<String> chosenRecipes = new ArrayList<>();
    private ArrayList<Date> recipeDates = new ArrayList<>();

    private boolean editing = false;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);

        selectedDate = Calendar.getInstance();

        /*
        todaysRecipes.add(new RecipeListItem("Test"));
        todaysRecipes.add(new RecipeListItem("Things"));
        todaysRecipes.add(new RecipeListItem("To"));
        todaysRecipes.add(new RecipeListItem("Put"));
        todaysRecipes.add(new RecipeListItem("In"));
        todaysRecipes.add(new RecipeListItem("List"));
        */

        mt = new MonthlyTab();
        mt.setCalendarActivity(this);
        dt = new DailyTab();
        dt.setCalendarActivity(this);
        dt.updateView();

        ImageButton backButton = findViewById(R.id.backButton);
        ImageButton editButton = findViewById(R.id.editButton);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toMainScreen();
            }
        });
        editButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editing = !editing;
                dt.getAdapter().notifyDataSetChanged();
            }
        });
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager(), this);

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);

        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(mViewPager));

        if (getIntent().getStringExtra("clickedRecipe") != null) {
            todaysRecipes.add(new RecipeListItem("" + getIntent().getStringExtra("clickedRecipe")));
            try{
                dt.getAdapter().notifyDataSetChanged();
            }
            catch (NullPointerException e){
                System.err.print(e);
            }
        }
    }


    @Override
    public void onResume(){
        super.onResume();
        dt.updateView();
    }
    public MonthlyTab getMt() {
        return mt;
    }

    public DailyTab getDt() {
        return dt;
    }

    public Calendar getSelectedDate() {
        return selectedDate;
    }

    public void setSelectedDate(Calendar selectedDate) {
        this.selectedDate = selectedDate;
    }

    public ArrayList<RecipeListItem> getTodaysRecipes() {
        return todaysRecipes;
    }

    public boolean getEditing(){
        return editing;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_calendar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        CalendarActivity calendarActivity;

        public SectionsPagerAdapter(FragmentManager fm, CalendarActivity calendarActivity ) {
            super(fm);

            this.calendarActivity = calendarActivity;
        }

        @Override
        public Fragment getItem(int position) {
            switch(position){
                case 0:
                    return calendarActivity.getDt();
                case 1:
                    return calendarActivity.getMt();
            }
            return null;
        }

        @Override
        public int getCount() {
            // Show 2 total pages.
            return 2;
        }
    }

    private void getRecipes(){

    }
    private void editEntries(){

    }
    private void toDateView(Date date){

    }
    private void toMainScreen(){
        Intent toMain = new Intent(getApplicationContext(), MainActivity.class);
        toMain.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        startActivityIfNeeded(toMain, 0);
    }
}
