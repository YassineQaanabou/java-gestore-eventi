package org.events;

import java.time.LocalDate;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        boolean isEventValid = false;

        Events event = null;
        while (!isEventValid) {

            System.out.println("Inserire il nome dell'evento:");
            String title = scan.nextLine();

            System.out.println("Inserire la data dell'evento: (yyyy-mm-dd)");
            LocalDate date = LocalDate.parse(scan.nextLine());

            System.out.println("Inserire i posti totali dell'evento:");
            int totalSpots = Integer.parseInt(scan.nextLine());

            try {
                event = new Events(title, date, totalSpots);
                isEventValid = true;
                System.out.println("L'evento è stato creato");

            } catch (RuntimeException e) {
                System.out.println("Data evento già trascorsa o numero posti negativo");
            }
        }

        System.out.println(event);

        boolean isBookingValid = false;

        while (!isBookingValid) {
            System.out.println("Vuoi prenotare dei posti? y/n");
            String choiceBooking = scan.nextLine();

            if (choiceBooking.equalsIgnoreCase("y")) {
                try {
                    System.out.println("Quanti posti vuoi prenotare?");
                    int spotsToBook = Integer.parseInt(scan.nextLine());

                    event.bookSpots(spotsToBook);
                    isBookingValid = true;
                    System.out.println("La prenotazione è stata effettuata");


                } catch (RuntimeException e) {
                    System.out.println("Data evento già trascorsa o posti non disponibili");
                }
            } else {
                isBookingValid = true;
            }
        }

        System.out.println("Posti prentotati:" + event.getBookedSpots());
        System.out.println("Posti disponibili:" + (event.getTotalSpots() - event.getBookedSpots()));

        boolean isCancelationValid = false;

        while (!isCancelationValid) {
            System.out.println("Vuoi disdire delle prenotazioni? y/n");
            String choiceBooking = scan.nextLine();

            if (choiceBooking.equalsIgnoreCase("y")) {
                try {
                    System.out.println("Quanti posti vuoi disdire?");
                    int spotsToCancel = Integer.parseInt(scan.nextLine());

                    event.cancelBookedSpots(spotsToCancel);
                    isCancelationValid = true;
                    System.out.println("La prenotazione è stata cancellata");


                } catch (RuntimeException e) {
                    System.out.println("Data evento già trascorsa o prenotazione non trovata");
                }
            } else {
                isCancelationValid = true;
            }
        }
        System.out.println("Posti prentotati:" + event.getBookedSpots());
        System.out.println("Posti disponibili:" + (event.getTotalSpots() - event.getBookedSpots()));
    }

}

