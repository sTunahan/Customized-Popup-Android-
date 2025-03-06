package com.example.securify.id.Utils.Customs;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.text.Html;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.SearchView;

import androidx.core.content.ContextCompat;

import com.example.securify.id.R;
import com.example.securify.id.Utils.Constants.Functions.ScreenSize;

import java.lang.reflect.Array;
import java.util.List;


public class PopupDesign {


    public static PopupWindow popupDesign(View popUpView) {
        // PopupWindow oluştur
        PopupWindow popupWindow = new PopupWindow(
                popUpView,
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT,
                true // Focusable
        );

        // Arka planı ayarla
        popupWindow.setBackgroundDrawable(new ColorDrawable());
        popupWindow.setElevation(10); // Gölge efekti

        return popupWindow; // Oluşturulan PopupWindow'u döndür
    }

    public static LinearLayout.LayoutParams scrollDesign(Context context){
        // Ekran boyutlarını al
        DisplayMetrics size = ScreenSize.viewScreenSize(context);
        int screenHeight = size.heightPixels;
        int screenWidth = size.widthPixels;
        // ScrollView'in yüksekliğini sınırlamak için LayoutParams
        LinearLayout.LayoutParams scrollViewParams = new LinearLayout.LayoutParams(
                (int) (screenWidth * 0.7),
                (int) (screenHeight * 0.5) / 2 // Popup'ın max yüksekliği
        );

        return  scrollViewParams;
    }

    public static void addAccountBtn(List<String> list, PopupWindow popupWindow , LinearLayout popupContainer,Context context) {

        for (String label : list) {
            Button button = new Button(context);
            button.setBackgroundResource(R.drawable.customized_frame);
            button.setText(label);
            button.setTextColor(ContextCompat.getColor(context, R.color.black)); // 'context' burada geçerli context olacaktır

            // Butonun layout params
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            );
            button.setLayoutParams(params);

            params.setMargins(0,0,0,20);
            // Butona tıklama olayını ekle
            button.setOnClickListener(v -> {
                popupWindow.dismiss(); // Popup'ı kapat
                String selectedLabel = ((Button) v).getText().toString();
                System.out.println("Seçilen buton: " + selectedLabel);
            });

            // Butonu popupContainer'a ekle
            popupContainer.addView(button);
        }
    }

    public static  void searchOperation (SearchView searchView,LinearLayout popupContainer) {


        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                // Kullanıcı arama yaptı, burada ek bir işlem yapabiliriz
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                // Arama sırasında butonları filtrele
                filterButtons(newText,popupContainer);
                return true;
            }
        });


    }
    // Butonları arama kriterine göre filtrele
    public static void filterButtons(String query, LinearLayout popupContainer) {
        for (int i = 0; i < popupContainer.getChildCount(); i++) {
            View buttonView = popupContainer.getChildAt(i);
            Button button = (Button) buttonView;

            if (button.getText().toString().toLowerCase().contains(query.toLowerCase())) {
                button.setVisibility(View.VISIBLE);
            } else {
                button.setVisibility(View.GONE);
            }
        }
    }
}