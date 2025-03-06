package com.example.securify.id.Utils.Customs;

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.ScrollView;
import android.widget.SearchView;

import com.example.securify.id.R;

import java.util.Arrays;
import java.util.List;

public class CustomizedPopup {
    private List<String> buttonLabels = Arrays.asList(
            "Seçenek 1", "Seçenek 2", "Seçenek 3", "Seçenek 4", "Seçenek 5",
            "Seçenek 6", "Seçenek 7", "Seçenek 8", "Seçenek 9", "Seçenek 10",
            "Seçenek 11", "Seçenek 12", "Seçenek 13", "Seçenek 14", "Seçenek 15"
    );

    private PopupWindow popupWindow;

    public void showPopup(Context context, View view) {
        // LayoutInflater ile popup layout'unu yükle
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View popupView = inflater.inflate(R.layout.popup, null);

        // PopupWindow'u oluştur
        popupWindow = PopupDesign.popupDesign(popupView);
        // Popup içindeki container'ı bul
        LinearLayout popupContainer = popupView.findViewById(R.id.popupContainer);

        // ScrollView'i bul , scroll'u design et
        ScrollView scrollView = popupView.findViewById(R.id.popupScrollView);
        scrollView.setLayoutParams(PopupDesign.scrollDesign(context));


        // Butonları dinamik olarak ekleyelim
        PopupDesign.addAccountBtn(buttonLabels,popupWindow,popupContainer,context);


        // SearchView için listener ekleyelim
        SearchView searchView = popupView.findViewById(R.id.searchView);
        PopupDesign.searchOperation(searchView,popupContainer);


        // Popup'ı ekranda göster
        int[] location = new int[2];
        view.getLocationOnScreen(location);
        int x = location[0] + view.getWidth() / 2;
        int y = location[1] + view.getHeight();
        popupWindow.showAtLocation(view, Gravity.NO_GRAVITY, x, y);
    }


}
