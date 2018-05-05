package medialogy.aau.b140.dont_starve;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.net.MalformedURLException;
import java.net.URL;


public class searchResultAdapter extends BaseAdapter {

    //List of recipes to fill the ListView with
    private RecipeListItem[] recipes;

    //Context from the ListViews origin
    private Context ctx;

    //Inflater - Used to inflate list layout later
    private LayoutInflater inflater;

    searchResultAdapter(Context ctx, RecipeListItem[] recipes) {
        this.ctx = ctx;
        this.recipes = recipes;

        inflater = LayoutInflater.from(this.ctx);
    }

    @Override
    public int getCount() {
        return recipes.length;
    }

    @Override
    public Object getItem(int i) {
        return recipes[i];
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View v = view;

        if (v == null)
            //Inflates the list layout
            v = inflater.inflate(R.layout.search_listitem, null);

        //Initiates 'rli' - Stores the RecipeListItem currently being inflated
        RecipeListItem rli = recipes[i];

        //Getting components from the list layout
        TextView headline = v.findViewById(R.id.searchListItem_headline_TextView);
        TextView description = v.findViewById(R.id.searchListItem_description_TextView);

        ImageView img = v.findViewById(R.id.searchListItem_image_ImageView);
        ImageView matchIndicator = v.findViewById(R.id.searchListItem_matchIndicator_ImageView);

        ImageButton calendar = v.findViewById(R.id.searchListItem_calendar_ImageButton);

        //Sets headline and descrition of the current list item
        headline.setText(rli.getName());
        description.setText(rli.getDesc());

        URLImageLoader loader = new URLImageLoader();
        loader.setView(img);
        loader.execute(rli.getImageSrc());

        //Sets the Match Indicator of the current list item
        switch (rli.getCompatibility()) {

            case 1:
                matchIndicator.setImageResource(R.drawable.ic_tick_black_24dp);
                break;
            case 2:
                matchIndicator.setImageResource(R.drawable.ic_tick_black_24dp);
                break;
            case 3:
                matchIndicator.setImageResource(R.drawable.ic_tick_black_24dp);
                break;
        }

        //Returns the current list item. to be put in the ListView
        return v;
    }
}