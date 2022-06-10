package com.proyecto.fasttohome.util;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.util.Base64;

public class ImagenesUtil {
    public Bitmap BaseStringToBitmap(String imageBase64)
    {
        byte[] imageBytes = Base64.getDecoder().decode(imageBase64);
        return BitmapFactory.decodeByteArray(imageBytes, 0, imageBytes.Length);
    }
}
