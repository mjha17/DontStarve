package medialogy.aau.b140.dont_starve;

import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> Ingredients;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void toSearch(){
        Intent toSearch = new Intent(getApplicationContext(), SearchActivity.class);
        toSearch.putExtra(Intent.EXTRA_TEXT, Ingredients.toString());
        startActivity(toSearch);
    }

    public void toCalendar(){
        Intent toCalendar = new Intent(getApplicationContext(), CalendarActivity.class);
        startActivity(toCalendar);
    }
}