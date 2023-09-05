package org.events;

import java.time.LocalDate;
import java.util.ArrayList;

public class ProgrammEventi {
    private String title;
    static ArrayList<Events> events = new ArrayList<>();

    public ProgrammEventi(String title) {
        this.title = title;
    }

     protected void addEvent(Events event) {
        events.add(event);
    }

    public void deleteEvents() {
            events.clear();
        }


    public String eventsOnDate(LocalDate date) {
        ArrayList<Events> eventsOnDate = new ArrayList<>();
        for (Events event : events) {
            if (event.getDate() == date) {
                eventsOnDate.add(event);
            }
        }
        return eventsOnDate.toString();
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
