package medialogy.aau.b140.dont_starve;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by majoh on 07-05-2018.
 */

public class dailyViewAdapter extends BaseAdapter{
    private ArrayList<RecipeListItem> recipes;

    private Context ctx;
    private LayoutInflater inflater;

    public dailyViewAdapter ( ArrayList<String> ingredients, Context ctx){
        this.ingredients = ingredients;
        this.ctx = ctx;
        inflater = LayoutInflater.from(ctx);
    }

    @Override
    public int getCount() {
        return ingredients.size();
    }

    @Override
    public Object getItem(int i) {
        return ingredients.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View v =  view;

        if(v == null){
            v = inflater.inflate(R.layout.ingredients_list_items, null);
        }

        TextView ingredientName = v.findViewById(R.id.ingredient_item);
        ingredientName.setText(ingredients.get(i));
        return v;
    }
}
