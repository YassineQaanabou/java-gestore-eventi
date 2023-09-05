package org.events;

import java.time.LocalDate;
import java.util.ArrayList;

public class ProgrammEventi {
    private String title;
    static ArrayList<Events> events = new ArrayList<>();

    public ProgrammEventi(String title) {
        this.title = title;
    }

    public static void addEvent(String title, LocalDate date, int totalSpots) {
        Events veicolo = new Events(title, date, totalSpots);
        events.add(veicolo);
    }

    public static void deleteEvents() {
        for (int i = 0; i < events.size(); i++) {
            events.remove(i);
        }
    }

    public ArrayList<Events> eventsOnDate(LocalDate date) {
        ArrayList<Events> eventsOnDate = new ArrayList<>();
        for (int i = 0; i < events.size(); i++) {
            if (events.get(i).getDate() == date) {
                eventsOnDate.add(events.get(i));
            }
        }
        return eventsOnDate;
    }

    public int countEvents() {
        int counter = 0;
        for (int i = 0; i < events.size(); i++) {
            counter += 1;
        }
        return counter;
    }

    @Override
    public String toString() {
        return "Title:" + title + events;
    }
}
