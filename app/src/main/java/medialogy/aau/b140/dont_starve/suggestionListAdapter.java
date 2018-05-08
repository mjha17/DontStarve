package medialogy.aau.b140.dont_starve;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class suggestionListAdapter extends BaseAdapter {
    private ArrayList<String> suggestedIngredients;

    private MainActivity ma;
    private LayoutInflater inflater;

    public suggestionListAdapter (ArrayList<String> suggestedIngredients, MainActivity ma){
        this.suggestedIngredients = suggestedIngredients;
        this.ma = ma;
        inflater = LayoutInflater.from(ma.getApplicationContext());
    }


    @Override
    public int getCount() {
        return suggestedIngredients.size();
    }

    @Override
    public Object getItem(int i) {
        return suggestedIngredients.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        return null;
    }
}
