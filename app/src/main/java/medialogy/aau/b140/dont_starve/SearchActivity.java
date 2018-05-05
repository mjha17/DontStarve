package medialogy.aau.b140.dont_starve;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import java.io.IOException;

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


        lv = findViewById(R.id.search_result_ListView);

        try {

            parser = new XMLRecipeParser(this, searchIngredients);
            parser.execute(getAssets().open("recipes.xml"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void getSearchResults(RecipeListItem[] recipes){
        this.recipes = recipes;

        adapter = new searchResultAdapter(getApplicationContext(), recipes);
        lv.setAdapter(adapter);
    }

    private void gatherRecipes(){

    }

    private void toCaldender(RecipeListItem recipe){

    }

    private void toMainScreen(){

    }
}