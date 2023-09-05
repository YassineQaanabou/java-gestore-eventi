package org.events;

import java.time.LocalDate;

/*La consegna è di creare una classe Evento che abbia le seguenti proprietà:
        ● titolo
        ● data
        ● numero di posti in totale
        ● numero di posti prenotati
        Quando si istanzia un nuovo evento questi attributi devono essere tutti valorizzati nel costruttore ,
        tranne posti prenotati che va inizializzato a 0.
        Inserire il controllo che la data non sia già passata e che il numero di posti totali sia positivo.
         In caso contrario sollevare opportune eccezioni.
        Aggiungere metodi getter e setter in modo che:
        ● titolo sia in lettura e in scrittura
        ● data sia in lettura e scrittura
        ● numero di posti totale sia solo in lettura
        ● numero di posti prenotati sia solo in lettura*/
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
}
