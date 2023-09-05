package org.events;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

public class Testconcert {
    public static void main(String[] args) {
        String title="Beatles";
        LocalDate date= LocalDate.parse("2024-12-12");
        LocalTime time= LocalTime.parse("20:00");
        int totalSpots=200000;
        BigDecimal price= BigDecimal.valueOf(50.50);

        Events concert = new Concert(title, date, totalSpots,time,price);

        System.out.println(concert);

    }
}
