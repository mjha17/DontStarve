package medialogy.aau.b140.dont_starve;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import java.util.Date;

public class CalendarActivity extends AppCompatActivity {

    private Date[] plannedDays;
    private Date currentDate = java.util.Date();
    private RecipeListItem[] recipes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);
    }

    private void getRecipes(){

    }
    private void editEntries(){

    }
    private void toDateView(Date date){
        //Switching between daily view and calendar view.
    }
    private void toMainScreen(){
        Intent intent = new Intent(CalendarActivity.this, MainActivity.class);
        CalendarActivity.this.startActivity(intent);
    }

}
