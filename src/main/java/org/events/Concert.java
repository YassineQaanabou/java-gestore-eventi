package org.events;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.LocalTime;

public class Concert extends Events {
    private LocalTime time;
    private BigDecimal price;

    public Concert(String title, LocalDate date, int totalSpots, LocalTime time, BigDecimal price) {
        super(title, date, totalSpots);
        this.time = time;
        this.price = price;
    }

    public LocalTime getTime() {
        return time;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public static String currencyFormat(BigDecimal n) {
        return NumberFormat.getCurrencyInstance().format(n);
    }

    @Override
    public String toString() {
        return "Concert:" + getDate() + " " + time +
                "-" + getTitle() + "-" + currencyFormat(price);
    }
}
