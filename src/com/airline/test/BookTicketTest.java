package com.airline.test;

import java.util.Scanner;
import com.airline.dao.BookingDAO;

public class BookTicketTest {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter User ID: ");
        int userId = sc.nextInt();

        System.out.print("Enter Flight ID to book: ");
        int flightId = sc.nextInt();

        BookingDAO dao = new BookingDAO();
        boolean result = dao.bookTicket(userId, flightId);

        if (result) {
            System.out.println("🎉 Ticket booked successfully");
        } else {
            System.out.println("❌ Booking failed (No seats available)");
        }

        sc.close();
    }
}
