package com.proyecto.fasttohome.util;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class ImagenesUtil {
    public Bitmap BaseStringToBitmap(String imageBase64)
    {
        byte[] imageBytes = Convert.FromBase64String(imageBase64);
        return BitmapFactory.decodeByteArray(imageBytes, 0, imageBytes.Length);
    }
}
