package com.home.simplesysinfoapp.utils;

public class EventsHub {
    private static EventsHub instance;

    private EventsHub() { }

    public static EventsHub getInstance() {
        if (instance == null)
            instance = new EventsHub();

        return instance;
    }

    // TODO: Ограниченный набор глобальных событий
}
