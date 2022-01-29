package com.home.simplesysinfoapp.utils;

import android.content.Context;
import android.widget.Toast;

public class Toasts {
    private static Toasts instance;

    private final CustomLogger logger = CustomLogger.getInstance();

    private Toasts () { }

    public static Toasts getInstance() {
        if (instance == null)
            instance = new Toasts();

        return instance;
    }

    public void debugMessage(Context c, String text) {
        if (DefaultConstants.IS_DEBUG) {
            logger.println(text);
            Toast.makeText(c, text, Toast.LENGTH_SHORT).show();
        }
    }

    public void errorMessage(Context c, String text) {
        logger.printError(text);
        Toast.makeText(c, text, Toast.LENGTH_SHORT).show();
    }

    public void makeText(Context c, String text) {
        Toast.makeText(c, text, Toast.LENGTH_SHORT).show();
    }
}
