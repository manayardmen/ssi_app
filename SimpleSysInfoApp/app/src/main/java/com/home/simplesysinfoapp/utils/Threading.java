package com.home.simplesysinfoapp.utils;

import com.home.simplesysinfoapp.interfaces.ICustomRunnable;

public class Threading {
    private static Threading instance;

    private static final long ZERO_DELAY = 0L;

    private final CustomLogger logger;

    private Threading() {
        logger = CustomLogger.getInstance();
    }

    public static Threading getInstance() {
        if (instance == null)
            instance = new Threading();

        return instance;
    }

    public void runInBackground(ICustomRunnable runnable) {
        runWithDelay(runnable, ZERO_DELAY);
    }

    public void runWithDelay(ICustomRunnable runnable, long delayMilliseconds) {
        Thread thread = new Thread() {
            @Override
            public void run() {
                try {
                    if (delayMilliseconds > ZERO_DELAY)
                        sleep(delayMilliseconds);

                    runnable.run();
                } catch (InterruptedException e) {
                    logger.printError(e.getMessage());
                    Thread.currentThread().interrupt();
                }
            }
        };
        thread.start();
    }

    public void runWithDefaultDelay(ICustomRunnable runnable) {
        runWithDelay(runnable, DefaultConstants.DEFAULT_DELAY_IN_MILLISECONDS);
    }
}
