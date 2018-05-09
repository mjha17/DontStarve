package medialogy.aau.b140.dont_starve;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CalendarView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SearchActivity extends AppCompatActivity {

    private RecipeListItem[] recipes;

    ListView lv;
    searchResultAdapter adapter;
    XMLRecipeParser parser;

    Bundle extras;
    String[] searchIngredients;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        extras = getIntent().getExtras();
        searchIngredients = extras.getString(Intent.EXTRA_TEXT).replace(" ", "").replace("[", "").replace("]", "").split(",");

        ImageButton backButton = findViewById(R.id.backButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toMainScreen();
            }
        });

        lv = findViewById(R.id.search_result_ListView);

        try {

            parser = new XMLRecipeParser(this, searchIngredients);
            parser.execute(getAssets().open("recipes.xml"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void toCalendar(RecipeListItem recipe){
        Toast.makeText(getApplicationContext(), recipe.getName(), Toast.LENGTH_LONG).show();
        Intent gotoCalendar = new Intent(getApplicationContext(), CalendarActivity.class);
        gotoCalendar.putExtra("clickedRecipe", recipe.getName());
        gotoCalendar.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        startActivity(gotoCalendar);
    }

    public void getSearchResults(RecipeListItem[] recipes){
        this.recipes = recipes;

        Arrays.sort(this.recipes);

        adapter = new searchResultAdapter(this, recipes);
        lv.setAdapter(adapter);
    }

    private void gatherRecipes(){

    }

    private void toMainScreen(){
        Intent toMain = new Intent(getApplicationContext(), MainActivity.class);
        toMain.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        startActivityIfNeeded(toMain, 0);
    }
}