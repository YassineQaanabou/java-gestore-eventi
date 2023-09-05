package org.events;

import java.time.LocalDate;

public class Events {
    private String title;
    private LocalDate date;
    private int totalSpots;
    private int  bookedSpots;

    public Events(String title, LocalDate date, int totalSpots) {
        isValidDate(date);
        isValidSpots(totalSpots);
        this.title = title;
        this.date = date;
        this.totalSpots = totalSpots;
        this.bookedSpots=0;
    }

    private void isValidDate(LocalDate date){
        if (date.isBefore(LocalDate.now())){
            throw new RuntimeException();
        }
    }

    private void isValidSpots(int totalSpots){
        if (totalSpots<0){
            throw new RuntimeException();
        }
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public LocalDate getDate() {
        return date;
    }

    public int getTotalSpots() {
        return totalSpots;
    }

    public int getBookedSpots() {
        return bookedSpots;
    }

    public void bookSpots(int spotsToBook){
        if(date.isAfter(LocalDate.now()) && bookedSpots<totalSpots){
            bookedSpots+=spotsToBook;
        } else {
            throw new RuntimeException();
        }

    }

    public void cancelBookedSpots(int spotsToCancel){
        if(date.isAfter(LocalDate.now()) && bookedSpots>0){
            bookedSpots-=spotsToCancel;
        } else {
            throw new RuntimeException();
        }

    }

    @Override
    public String toString() {
        return "Event:" + date+
                "-" + title;
    }
}
