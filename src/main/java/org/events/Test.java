package org.events;

import java.sql.*;
import java.time.LocalDate;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String url = "jdbc:mysql://localhost:3306/db_eventi";
        String user = "root";
        String password = "Root6912";

        try(Connection conn= DriverManager.getConnection(url,user,password)) {
            System.out.println(conn.getCatalog());

            System.out.println("Scegliere l'opzione desiderata: 1-prenotare o cancellare posti da un evento già esistente 2-creare un nuovo evento");
            String choice1 = scan.nextLine();

            if(choice1.equals("1")){
                String printEvents="SELECT * FROM eventi";
                Events event=null;
                try(PreparedStatement ps= conn.prepareStatement(printEvents)){
                    try(ResultSet rs=ps.executeQuery()){
                        while(rs.next()){
                            int id=rs.getInt("id");
                            String title=rs.getString("title");
                            LocalDate date= rs.getDate("date").toLocalDate();
                            int totalSpots=rs.getInt("total_spots");
                            int bookedSpots=rs.getInt("booked_spots");


                            System.out.println(id +" "+title+" "+date);

                        }
                    }
                }

                System.out.println("Inserire l'ID dell'evento:");
                String idEvent = scan.nextLine();

                System.out.println("Scegliere l'opzione desiderata: 1-effettuare una prenotazione 2-cancellare una prenotazione");
                String choice2 = scan.nextLine();

                if(choice2.equals("1")){
                    System.out.println("Quanti posti vuoi prenotare?");
                    String spotsToBook = scan.nextLine();

                } else if(choice2.equals("2")){
                    System.out.println("Quanti posti vuoi disdire?");
                    String spotsToCancel = scan.nextLine();
                }

                String searchEventbyID="SELECT * FROM eventi WHERE id='"+idEvent+"'";


                try(PreparedStatement ps= conn.prepareStatement(searchEventbyID)){
                    try(ResultSet rs=ps.executeQuery()){
                        while(rs.next()){
                            int id=rs.getInt("ID");
                            String title=rs.getString("title");
                            LocalDate date= rs.getDate("date").toLocalDate();

                        }
                    }
                }



            } else if (choice1.equals("2")) {

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
        } catch (SQLException e) {
            System.out.println("an error occured");
        }
    }

}

