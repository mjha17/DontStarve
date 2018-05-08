package medialogy.aau.b140.dont_starve;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;

public class dailyViewAdapter extends BaseAdapter{
    private ArrayList<RecipeListItem> recipes;

    private DailyTab dt;
    private LayoutInflater inflater;

    public dailyViewAdapter ( ArrayList<RecipeListItem> recipes, DailyTab dt){
        this.recipes = recipes;
        this.dt = dt;
        inflater = LayoutInflater.from(dt.getCalendarActivity().getApplicationContext());


    }

    @Override
    public int getCount() {
        return recipes.size();
    }

    @Override
    public Object getItem(int i) {
        return recipes.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View v =  view;

        if(v == null){
            v = inflater.inflate(R.layout.daily_listitem, null);
        }

        final RecipeListItem recipe = recipes.get(i);

        TextView ingredientName = v.findViewById(R.id.recipe_item);
        ImageButton delete = v.findViewById(R.id.recipe_delete);

        delete.setVisibility(dt.getCalendarActivity().getEditing() ? View.VISIBLE : View.GONE);

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recipes.remove(recipe);
                dt.getAdapter().notifyDataSetChanged();
            }
        });

        ingredientName.setText(recipe.getName());
        return v;
    }
}
