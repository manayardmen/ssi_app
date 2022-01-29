package com.home.simplesysinfoapp.utils;

import android.util.Log;

public class CustomLogger {
    private static CustomLogger instance;

    private CustomLogger() { }

    public static CustomLogger getInstance() {
        if (instance == null)
            instance = new CustomLogger();

        return instance;
    }

    public void println(String message) {
        Log.println(Log.INFO, DefaultConstants.APP_LOG_CODE, message);
    }

    public void printError(String message) {
        Log.println(Log.ERROR, DefaultConstants.APP_LOG_CODE, message);
    }
}
