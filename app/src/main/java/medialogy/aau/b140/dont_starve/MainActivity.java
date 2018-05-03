package medialogy.aau.b140.dont_starve;

import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ingredientListAdpter mainScreenAdapter;
    ArrayList<String> Ingredients = new ArrayList<String>();

    Button searchButton;
    ImageButton calendarButton, addButton;
    EditText input;
    ListView addingIngredients;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Getting components in from the layout
        searchButton = findViewById(R.id.main_search_Button);
        calendarButton = findViewById(R.id.main_calendar_ImageButton);
        addButton = findViewById(R.id.main_addIngredient_ImageButton);

        input = findViewById(R.id.main_inputIngredient_EditText);

        addingIngredients = findViewById(R.id.addedIngredients);
        mainScreenAdapter = new ingredientListAdpter(Ingredients, getApplicationContext());
        addingIngredients.setAdapter(mainScreenAdapter);

        //Demo ingredient
        //!! - SHOULD BE REMOVED AT A LATER POINT !!
        Ingredients.add("Lettuce");

        //What happend when the 'search' button is clicked
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toSearch();
            }
        });

        //What happend when the 'calendar' button is clicked
        calendarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toCalendar();
            }
        });

        //What happend when the '+' button is clicked
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addIngredient();
            }
        });
    }

    private void addIngredient(){
        //Add the ingredient/leftover written in the input field
        //? - Check if valid ingredient
        Ingredients.add(input.getText().toString());
    }

    private void toSearch(){
        Intent toSearch = new Intent(getApplicationContext(), SearchActivity.class);
        toSearch.putExtra(Intent.EXTRA_TEXT, Ingredients.toString());
        startActivity(toSearch);
    }

    private void toCalendar(){
        Intent toCalendar = new Intent(getApplicationContext(), CalendarActivity.class);
        startActivity(toCalendar);
    }
}