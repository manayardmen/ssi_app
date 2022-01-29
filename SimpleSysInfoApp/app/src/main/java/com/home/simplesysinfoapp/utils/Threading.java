package com.home.simplesysinfoapp.utils;

import com.home.simplesysinfoapp.interfaces.ICustomRunnable;

public class Threading {
    private static Threading instance;

    private Threading() { }

    public static Threading getInstance() {
        if (instance == null)
            instance = new Threading();

        return instance;
    }

    public void runInBackground(ICustomRunnable runnable) {
        Thread thread = new Thread() {
            @Override
            public void run() {
                runnable.run();
            }
        };
        thread.start();
    }
}
