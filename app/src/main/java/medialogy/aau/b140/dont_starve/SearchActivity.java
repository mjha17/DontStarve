package medialogy.aau.b140.dont_starve;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

public class SearchActivity extends AppCompatActivity implements URLImageResponse {

    private RecipeListItem[] recipes;

    ListView lv;
    searchResultAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);


        lv = findViewById(R.id.search_result_ListView);

        getSearchResults();
    }

    private void getSearchResults(){

        gatherRecipes();

        adapter = new searchResultAdapter(getApplicationContext(), recipes);
        lv.setAdapter(adapter);

    }

    private void gatherRecipes(){

    }

    private void toCaldender(RecipeListItem recipe){

    }

    private void toMainScreen(){

    }

    @Override
    public void onURLImageLoaded(Bitmap bitmap, int id) {

        View v = (View) adapter.getItem(id);
        ImageView iv = v.findViewById(R.id.searchListItem_calendar_ImageButton);

        iv.setImageBitmap(bitmap);
    }
}