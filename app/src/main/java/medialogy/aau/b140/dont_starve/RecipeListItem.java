package medialogy.aau.b140.dont_starve;

import java.net.URL;

public class RecipeListItem {
    private String name;
    private String desc;

    private String[] ingredients;
    private URL imageSrc;

    private int compatibility;

    RecipeListItem(String name, String desc, String[] ingredients, URL imageSrc){
        this.name = name;
        this.desc = desc;

        this.ingredients = ingredients;
        this.imageSrc = imageSrc;
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
}