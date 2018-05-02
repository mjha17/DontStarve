package medialogy.aau.b140.dont_starve;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;


public class searchResultAdapter extends BaseAdapter {

    RecipeListItem[] recipes;
    LayoutInflater inflater;

    searchResultAdapter(RecipeListItem[] recipes){
        this.recipes = recipes;

        inflater = LayoutInflater.from();
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

    }
}
