package medialogy.aau.b140.dont_starve;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

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
        View v = view;

        if (v == null){
            v = inflater.inflate(R.layout.suggested_list_item, null);
        }

        TextView name = v.findViewById(R.id.suggested_item);
        ImageButton deleteButton = v.findViewById(R.id.ingredient_decline);
        ImageButton acceptButton = v.findViewById(R.id.ingredient_accept);

        final String currentString = suggestedIngredients.get(i);

        name.setText(currentString);

        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ma.suggestions.remove(currentString);
                ma.mainScreenSuggestions.notifyDataSetChanged();
            }
        });

        acceptButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ma.suggestions.remove(currentString);
                ma.mainScreenSuggestions.notifyDataSetChanged();
                ma.ingredients.add(currentString);
                ma.mainScreenIngredients.notifyDataSetChanged();

            }
        });
        return v;
    }
}
