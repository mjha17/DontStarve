package medialogy.aau.b140.dont_starve;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by majoh on 01-05-2018.
 */

public class URLImageLoader extends AsyncTask<URL, Integer, Bitmap> {

    private ImageView view;
    private BitmapFactory bf = new BitmapFactory();

    public URLImageLoader(){}

    public void setView(ImageView view) {
        this.view = view;
    }

    @Override
    protected Bitmap doInBackground(URL... urls) {

        Bitmap bitmap = null;
        URL url = urls[0];

        try {
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoInput(true);
            connection.connect();

            InputStream is = connection.getInputStream();

            bitmap = bf.decodeStream(is);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return bitmap;
    }

    @Override
    protected void onPostExecute(Bitmap bitmap) {
        super.onPostExecute(bitmap);

        view.setImageBitmap(bitmap);
    }
}