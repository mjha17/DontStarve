package medialogy.aau.b140.dont_starve;


import android.os.AsyncTask;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class XMLRecipeParser extends AsyncTask<InputStream, Integer, RecipeListItem[]> {

    Element XML;
    SearchActivity searchActivity;
    String[] searchIngredients;

    XMLRecipeParser(SearchActivity searchActivity, String[] searchIngredients){
        this.searchActivity = searchActivity;
        this.searchIngredients = searchIngredients;
    }

    @Override
    protected RecipeListItem[] doInBackground(InputStream... inputStreams) {

        RecipeListItem[] recipeListItems;
        NodeList recipes;

        setupXML(inputStreams[0]);
        recipes = XML.getElementsByTagName("Recipe");
        System.out.println("    Recipes: " + recipes.getLength());

        recipeListItems = new RecipeListItem[recipes.getLength()];


        for(int i=0; i<recipes.getLength(); i++){
            Element recipeElement = (Element) recipes.item(i);

            String name = "";
            String desc = "";
            URL imageSrc = null;

            ArrayList<String> ingredients = new ArrayList<>();

            try {
                name = recipeElement.getAttribute("Name");
                System.out.println(name);
                desc = recipeElement.getAttribute("Desc");
                imageSrc = new URL(recipeElement.getAttribute("imgSrc"));
                System.out.println(imageSrc.toString());
            } catch (MalformedURLException e) {
                System.err.println("Error when parsing URL in recipe file - Recipe entry number: " + i);
                e.printStackTrace();
            }

            NodeList ingredientElements = recipeElement.getElementsByTagName("Ingredient");

            for(int j=0; j<ingredientElements.getLength(); j++){

                Element ingredient = (Element) ingredientElements.item(j);

                if(!ingredient.getTagName().equals("Ingredient"))
                    continue;

                ingredients.add(ingredient.getAttribute("Name"));
            }

            recipeListItems[i] = new RecipeListItem(name, desc, ingredients.toArray(new String[ingredients.size()]), imageSrc);
            recipeListItems[i].setCompatibility(searchIngredients);
        }

        System.out.println("Done parsing!");
        return recipeListItems;
    }

    private void setupXML(InputStream is){

        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = factory.newDocumentBuilder();
            Document doc = db.parse(is);

            XML = doc.getDocumentElement();

        }catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onPostExecute(RecipeListItem[] recipeListItems) {
        super.onPostExecute(recipeListItems);

        System.out.println("To serch Results: " + recipeListItems.toString());
        searchActivity.getSearchResults(recipeListItems);
    }
}
