package org.events;

import java.time.LocalDate;

public class TestProgrammEventi {
    public static void main(String[] args) {
        String title = "concerto";
        LocalDate date = LocalDate.parse("2024-12-12");
        int spots = 134;

        String title1 = "concerto1";
        LocalDate date1 = LocalDate.parse("2024-02-12");
        int spots1 = 1345;

        String title2 = "concerto2";
        LocalDate date2 = LocalDate.parse("2024-12-12");
        int spots2 = 134;

        String titleArrray = "eventi";

        Events event1 = new Events(title, date, spots);
        Events event2 = new Events(title1, date1, spots1);
        Events event3 = new Events(title2, date2, spots2);

        ProgrammEventi events = new ProgrammEventi(titleArrray);

        events.addEvent(event1);
        events.addEvent(event2);
        events.addEvent(event3);

        System.out.println(events);
        System.out.println(events.eventsOnDate("2024-12-12"));
        System.out.println(events.countEvents());
        events.deleteEvents();
        System.out.println(events.countEvents());

    }


}
