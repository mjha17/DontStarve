package medialogy.aau.b140.dont_starve;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;


public class searchResultAdapter extends BaseAdapter {

    RecipeListItem[] recipes;
    Context ctx;
    LayoutInflater inflater;

    searchResultAdapter(Context ctx, RecipeListItem[] recipes){
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

        if(v == null)
            v = inflater.inflate(R.layout.search_listitem, null);

        RecipeListItem rli = recipes[i];

        TextView headline = (TextView) v.findViewById(R.id.searchListItem_headline_TextView);
        TextView description = (TextView) v.findViewById(R.id.searchListItem_description_TextView);

        ImageView img = (ImageView) v.findViewById(R.id.searchListItem_image_ImageView);
        ImageView matchIndicator = (ImageView) v.findViewById(R.id.searchListItem_matchIndicator_ImageView);

        ImageButton calendar = (ImageButton) v.findViewById(R.id.searchListItem_calendar_ImageButton);

        headline.setText(rli.name);
        description.setText(rli.desc);

        switch (rli.compatibility){

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

        return v;
    }
}
