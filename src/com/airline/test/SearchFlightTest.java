package com.airline.test;

import java.util.Scanner;
import java.util.ArrayList;
import com.airline.dao.FlightDAO;
import com.airline.model.Flight;

public class SearchFlightTest {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter source: ");
        String source = sc.nextLine();

        System.out.print("Enter destination: ");
        String destination = sc.nextLine();

        System.out.print("Enter date (YYYY-MM-DD): ");
        String date = sc.nextLine();

        FlightDAO dao = new FlightDAO();
        ArrayList<Flight> flights = dao.searchFlights(source, destination, date);

        if (flights.isEmpty()) {
            System.out.println("❌ No flights found");
        } else {
            System.out.println("✈️ Flights Available:");
            for (Flight f : flights) {
                System.out.println(
                        f.getFlightId() + " | " +
                        f.getFlightName() + " | " +
                        f.getSource() + " → " +
                        f.getDestination() + " | " +
                        f.getDate() + " | " +
                        f.getTime() + " | ₹" +
                        f.getPrice() + " | Seats: " +
                        f.getSeats()
                );
            }
        }

        sc.close();
    }
}
