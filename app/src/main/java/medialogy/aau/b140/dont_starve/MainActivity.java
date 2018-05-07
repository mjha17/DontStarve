package medialogy.aau.b140.dont_starve;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.ImageButton;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ingredientListAdpter mainScreenAdapter;
    ArrayAdapter<String> autoCompleteAdapter;
    ArrayList<String> Ingredients = new ArrayList<String>();

    Button searchButton;
    ImageButton calendarButton, addButton;
    AutoCompleteTextView input;
    ListView addedIngredients;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Getting components in from the layout
        searchButton = findViewById(R.id.main_search_Button);
        calendarButton = findViewById(R.id.main_calendar_ImageButton);
        addButton = findViewById(R.id.main_addIngredient_ImageButton);

        String[] autoCompleteIngredients = getResources().getStringArray(R.array.ingredients_array);
        autoCompleteAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, autoCompleteIngredients);

        input = findViewById(R.id.main_inputIngredient_EditText);
        input.setAdapter(autoCompleteAdapter);

        addedIngredients = findViewById(R.id.addedIngredients);
        mainScreenAdapter = new ingredientListAdpter(Ingredients, getApplicationContext());
        addedIngredients.setAdapter(mainScreenAdapter);

        //Demo ingredient
        //!! - SHOULD BE REMOVED AT A LATER POINT !!
        Ingredients.add("asparagus");

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

        addedIngredients.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Ingredients.remove(i);
                mainScreenAdapter.notifyDataSetChanged();
            }
        });
    }

    private void addIngredient(){
        //Add the ingredient/leftover written in the input field
        String ingredient = input.getText().toString();

        if(ingredient.equals("") || ingredient == null) return;

        Ingredients.add(ingredient);
        mainScreenAdapter.notifyDataSetChanged();

        input.setText("");
    }

    private void toSearch(){
        Intent toSearch = new Intent(getApplicationContext(), SearchActivity.class);
        toSearch.putExtra(Intent.EXTRA_TEXT, Ingredients.toString());
        startActivity(toSearch);
    }

    private void toCalendar(){
        Intent toCalendar = new Intent(getApplicationContext(), CalendarActivity.class);
        toCalendar.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        startActivityIfNeeded(toCalendar, 0);
    }
}