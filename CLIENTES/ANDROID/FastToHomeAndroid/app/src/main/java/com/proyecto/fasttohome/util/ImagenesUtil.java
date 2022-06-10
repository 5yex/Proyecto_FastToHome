package com.proyecto.fasttohome.util;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;


public class ImagenesUtil {
    public static Bitmap BaseStringToBitmap(String imageBase64)
    {
        byte[] imageBytes = Base64.decode(imageBase64,Base64.DEFAULT);
        return BitmapFactory.decodeByteArray(imageBytes, 0, imageBytes.length);
    }
}
