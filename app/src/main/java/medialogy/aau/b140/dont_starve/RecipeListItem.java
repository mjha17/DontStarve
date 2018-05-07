package medialogy.aau.b140.dont_starve;

import android.support.annotation.NonNull;

import java.net.URL;
public class RecipeListItem implements Comparable<RecipeListItem> {
    private String name;
    private String desc;

    private String[] ingredients;
    private URL imageSrc;

    private int compatibility;

    public RecipeListItem(String name, String desc, String[] ingredients, URL imageSrc){
        this.name = name;
        this.desc = desc;

        this.ingredients = ingredients;
        this.imageSrc = imageSrc;

        this.compatibility = 2;
    }

    public RecipeListItem(String name){
        this(name, null, null, null);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String[] getIngredients() {
        return ingredients;
    }

    public void setIngredients(String[] ingredients) {
        this.ingredients = ingredients;
    }

    public URL getImageSrc() {
        return imageSrc;
    }

    public void setImageSrc(URL imageSrc) {
        this.imageSrc = imageSrc;
    }

    public int getCompatibility() {
        return compatibility;
    }

    public void setCompatibility(String[] searchArray) {
        int matches = 0;

        for (String s : ingredients) {
            for (String z : searchArray) {
                System.out.println("Comparing: " + s.toLowerCase() + " and " + z.toLowerCase());
                if ((s.toLowerCase()).equals(z.toLowerCase())) {
                    System.out.println("X");
                    matches++;
                }
            }
        }

        System.out.println(name + ": " + matches);

        if (searchArray.length <= matches) {
            this.compatibility = 1;
        } else {
            this.compatibility = 2;
        }
    }

    @Override
    public int compareTo(@NonNull RecipeListItem recipeListItem) {
        return this.getCompatibility() - recipeListItem.getCompatibility();
    }
}