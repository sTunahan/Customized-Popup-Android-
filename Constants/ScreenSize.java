package com.example.securify.id.Utils.Constants.Functions;

import static androidx.core.content.ContextCompat.getSystemService;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;

public class ScreenSize {


    public static DisplayMetrics viewScreenSize(Context context) {
        // Ekran boyutlarını almak için DisplayMetrics kullanımı
        WindowManager windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Display display = windowManager.getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        display.getMetrics(displayMetrics);


        return displayMetrics;
    }
}
