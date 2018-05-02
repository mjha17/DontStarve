package medialogy.aau.b140.dont_starve;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

public class SearchActivity extends AppCompatActivity {

    private RecipeListItem[] recipes;
    ListView lv = findViewById(R.id.search_result_ListView);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        getSearchResults();
    }

    private void getSearchResults(){

        recipes = new RecipeListItem[20];

        for(int i=0; i<recipes.length; i++){
            recipes[i] = new RecipeListItem();
        }


        searchResultAdapter adapter = new searchResultAdapter(getApplicationContext(), recipes);
        lv.setAdapter(adapter);

    }

    private void toCaldender(RecipeListItem recipe){

    }

    private void toMainScreen(){

    }
}