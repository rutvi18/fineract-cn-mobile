package org.apache.fineract.utils;

import android.app.Activity;
import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;

import androidx.core.content.ContextCompat;

import android.graphics.drawable.LayerDrawable;
import android.view.Menu;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.apache.fineract.R;

import java.util.Locale;

/**
 * @author Rajan Maurya
 * On 30/07/17.
 */

public class Utils {

    public static <T> T getStringToPoJo(TypeToken<T> listModel, String jsonName) {
        return new Gson().fromJson(jsonName, listModel.getType());
    }

    public static String getPrecision(Double aDouble) {
        return String.format(Locale.ENGLISH, "%.2f", aDouble);
    }

    public static void setToolbarIconColor(Context context, Menu menu, int color) {
        for (int i = 0; i < menu.size(); i++) {
            Drawable drawable = menu.getItem(i).getIcon();
            if (drawable != null) {
                drawable.mutate();
                drawable.setColorFilter(
                        ContextCompat.getColor(context, color), PorterDuff.Mode.SRC_IN);
            }
        }
    }

    public static LayerDrawable setCircularBackground(int colorId, Context context) {
        Drawable color = new ColorDrawable(ContextCompat.getColor(context, colorId));
        Drawable image = ContextCompat.getDrawable(context, R.drawable.circular_background);
        LayerDrawable ld = new LayerDrawable(new Drawable[]{image, color});
        return ld;
    }

    public static void hideKeyboard(Context context, View view) {
        InputMethodManager imm = (InputMethodManager) context.getSystemService(
                Activity.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }
}
