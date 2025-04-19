package com.example.ht;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.Gravity;
import android.widget.TextView;
import android.widget.Toast;

public class ToastHelper {

    public static void showErrorToast(Context context, String message) {
        showCustomToast(context, message, Color.RED);
    }

    public static void showSuccessToast(Context context, String message) {
        showCustomToast(context, message, Color.BLACK);
    }

    private static void showCustomToast(Context context, String message, int textColor) {
        Toast toast = new Toast(context);
        toast.setGravity(Gravity.CENTER, 0, 200);
        TextView toastText = new TextView(context);
        toastText.setText(message);
        toastText.setTextColor(textColor);
        toastText.setTextSize(20);
        toastText.setTypeface(toastText.getTypeface(), Typeface.BOLD);
        toast.setView(toastText);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.show();
    }

}
