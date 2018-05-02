package medialogy.aau.b140.dont_starve;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

public class SearchActivity extends AppCompatActivity {

    private RecipeListItem[] recipes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    private RecipeListItem[] getSearchResults(){

        return null;
    }

    private void toCaldender(RecipeListItem recipe){

    }

    private void toMainScreen(){

    }
}