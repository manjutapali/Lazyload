package com.manjunathtapali.lazyloadimages.LazyLoaders;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableWrapper;
import android.util.Log;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by tapalim on 10/2/17.
 */

public class LazyLoad {
    private static HashMap<String, Drawable> ImageStorer = new HashMap<>();
    private static InputStream inputStream;

    public static void GetImage(final String ImageURL, Context mContext, final ImageView view)
    {
        if(ImageStorer.containsKey(ImageURL))
        {
            view.setImageDrawable(ImageStorer.get(ImageURL));
        }
        final Drawable[] drawable = {null};
        try
        {

            Loader loader = new Loader() {
                @Override
                public void success() {
                    drawable[0] = DrawableWrapper.createFromStream(inputStream, "img");
                    view.setImageDrawable(drawable[0]);
                }

                @Override
                public void failure() {
                    Log.e("LazyLoad", "Image loading is failed");
                }
            };



        }
        catch (Exception e)
        {
            e.printStackTrace();

        }


    }

    private void GetImageFile(String ImageURL, Loader loader) throws IOException
    {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(ImageURL).build();

        Response response = client.newCall(request).execute();
        inputStream =  response.body().byteStream();

        if(inputStream != null)
        {
            loader.success();
        }
        else
        {
            loader.failure();
        }

    }
}
