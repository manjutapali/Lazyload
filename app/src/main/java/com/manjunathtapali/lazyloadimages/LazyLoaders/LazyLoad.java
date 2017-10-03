package com.manjunathtapali.lazyloadimages.LazyLoaders;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableWrapper;

import java.io.InputStream;
import java.nio.charset.MalformedInputException;
import java.util.HashMap;

/**
 * Created by tapalim on 10/2/17.
 */

public class LazyLoad {
    private HashMap<String, Drawable> ImageStorer = null;

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
        }
        catch (Exception e)
        {
            e.printStackTrace();
            drawable = null;
        }

        return drawable;
    }

    private InputStream GetImageFile(String ImageURL)
    {
        
    }
}
