package medialogy.aau.b140.dont_starve;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.GetChars;
import android.text.TextWatcher;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ingredientListAdapter mainScreenIngredients;
    suggestionListAdapter mainScreenSuggestions;
    ArrayAdapter<String> autoCompleteAdapter;
    ArrayList<String> ingredients = new ArrayList<String>();
    ArrayList<String> suggestions = new ArrayList<String>();

    Button searchButton;
    ImageButton calendarButton, addButton;
    AutoCompleteTextView input;
    ListView addedIngredients;
    ListView suggestedIngredients;

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
        mainScreenIngredients = new ingredientListAdapter(ingredients, this);
        addedIngredients.setAdapter(mainScreenIngredients);

        suggestedIngredients = findViewById(R.id.suggested_ingredients);
        mainScreenSuggestions = new suggestionListAdapter(suggestions, this);
        suggestedIngredients.setAdapter(mainScreenSuggestions);

        //Demo suggested ingredients
        suggestions.add("Salt");
        suggestions.add("Pork");
        suggestions.add("Sour cream");

        //Demo ingredient
        //!! - SHOULD BE REMOVED AT A LATER POINT !!
        ingredients.add("Flour");
        ingredients.add("Milk");
        ingredients.add("Sugar");

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

        input.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @TargetApi(Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(charSequence.length() == 0){
                    addButton.setBackgroundTintList(getResources().getColorStateList(R.color.darkGray));
                }else{
                    addButton.setBackgroundTintList(getResources().getColorStateList(R.color.positiveAction));
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

    private void addIngredient(){
        //Add the ingredient/leftover written in the input field
        String ingredient = input.getText().toString();

        if(ingredient.equals("") || ingredient == null) return;

        ingredients.add(ingredient);
        mainScreenIngredients.notifyDataSetChanged();

        input.setText("");
        try {
            InputMethodManager imm = (InputMethodManager)getSystemService(INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    private void toSearch(){
        Intent toSearch = new Intent(getApplicationContext(), SearchActivity.class);
        toSearch.putExtra(Intent.EXTRA_TEXT, ingredients.toString());
        startActivity(toSearch);
    }

    private void toCalendar(){
        Intent toCalendar = new Intent(getApplicationContext(), CalendarActivity.class);
        toCalendar.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        startActivityIfNeeded(toCalendar, 0);
    }
}