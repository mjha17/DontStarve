package medialogy.aau.b140.dont_starve;

import android.content.Context;
import android.support.v4.content.ContextCompat;
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
    private SearchActivity searchActivity;

    //Inflater - Used to inflate list layout later
    private LayoutInflater inflater;

    searchResultAdapter(SearchActivity searchActivity, RecipeListItem[] recipes) {
        this.searchActivity = searchActivity;
        this.recipes = recipes;

        inflater = LayoutInflater.from(searchActivity.getApplicationContext());
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
        final RecipeListItem rli = recipes[i];

        //Getting components from the list layout
        TextView headline = v.findViewById(R.id.searchListItem_headline_TextView);
        TextView description = v.findViewById(R.id.searchListItem_description_TextView);

        ImageView img = v.findViewById(R.id.searchListItem_image_ImageView);
        ImageView matchIndicator = v.findViewById(R.id.searchListItem_matchIndicator_ImageView);

        ImageButton calendar = v.findViewById(R.id.searchListItem_calendar_ImageButton);

        calendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                searchActivity.toCalendar(rli);
            }
        });

        //Sets headline and descrition of the current list item
        headline.setText(rli.getName());
        description.setText(rli.getDesc());

        URLImageLoader loader = new URLImageLoader();
        loader.setView(img);
        loader.execute(rli.getImageSrc());

        //Sets the Match Indicator of the current list item
        switch (rli.getCompatibility()) {

            case 1:
                matchIndicator.setImageResource(R.drawable.ic_compat_tick);
                matchIndicator.setColorFilter(ContextCompat.getColor(v.getContext(), R.color.positiveAction), android.graphics.PorterDuff.Mode.SRC_IN);
                break;
            case 2:
                matchIndicator.setImageResource(R.drawable.ic_compat_excl);
                matchIndicator.setColorFilter(ContextCompat.getColor(v.getContext(), R.color.neutralAction), android.graphics.PorterDuff.Mode.SRC_IN);
                break;
        }

        //Returns the current list item. to be put in the ListView
        return v;
    }
}