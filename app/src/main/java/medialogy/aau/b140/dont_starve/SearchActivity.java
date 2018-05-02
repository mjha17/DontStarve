package medialogy.aau.b140.dont_starve;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

public class SearchActivity extends AppCompatActivity implements AsyncResponse{

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

        recipes = new RecipeListItem[20];

        for(int i=0; i<recipes.length; i++){
            recipes[i] = new RecipeListItem();
        }


        adapter = new searchResultAdapter(getApplicationContext(), recipes);
        lv.setAdapter(adapter);

    }

    private void toCaldender(RecipeListItem recipe){

    }

    private void toMainScreen(){

    }

    @Override
    public void asyncResponse(Bitmap bitmap, int id) {

        View v = (View) adapter.getItem(id);
        ImageView iv = v.findViewById(R.id.searchListItem_calendar_ImageButton);

        iv.setImageBitmap(bitmap);

    }
}