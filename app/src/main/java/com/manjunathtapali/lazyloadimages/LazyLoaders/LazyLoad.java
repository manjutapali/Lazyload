package com.manjunathtapali.lazyloadimages.LazyLoaders;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableWrapper;

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
    private static HashMap<String, Drawable> ImageStorer = null;

    public LazyLoad()
    {
        ImageStorer = new HashMap<>();
    }

    public Drawable GetImage(String ImageURL)
    {
        if(ImageStorer.containsKey(ImageURL))
        {
            return ImageStorer.get(ImageURL);
        }
        Drawable drawable = null;
        try
        {
            InputStream img = GetImageFile(ImageURL);
            drawable = DrawableWrapper.createFromStream(img, "img");

            ImageStorer.put(ImageURL, drawable);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            drawable = null;
        }

        return drawable;
    }

    private InputStream GetImageFile(String ImageURL) throws IOException
    {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(ImageURL).build();

        Response response = client.newCall(request).execute();
        InputStream inputStream =  response.body().byteStream();

        return inputStream;
    }
}
