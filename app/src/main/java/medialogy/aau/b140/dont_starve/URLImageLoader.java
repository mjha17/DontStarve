package medialogy.aau.b140.dont_starve;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/**
 * Created by majoh on 01-05-2018.
 */

public class URLImageLoader extends AsyncTask<URL, Integer, Bitmap> {

    private int id;
    private BitmapFactory bf = new BitmapFactory();
    private AsyncResponse responce;

    private URLImageLoader(){}

    public void setId(int id) {
        this.id = id;
    }

    @Override
    protected Bitmap doInBackground(URL... urls) {

        Bitmap bitmap = null;

        try {
            InputStream is = urls[0].openStream();
            bf.decodeStream(is);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return bitmap;
    }

    @Override
    protected void onPostExecute(Bitmap bitmap) {
        super.onPostExecute(bitmap);

        responce.asyncResponse(bitmap, id);

    }
}