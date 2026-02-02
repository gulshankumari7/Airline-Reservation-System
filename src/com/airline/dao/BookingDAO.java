package com.airline.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class BookingDAO {

    public boolean bookTicket(int userId, int flightId) {
        boolean status = false;

        try {
            Connection con = DBConnection.getConnection();

            // 1️⃣ Insert booking
            String bookSql = "INSERT INTO bookings(user_id, flight_id, status) VALUES (?, ?, ?)";
            PreparedStatement ps1 = con.prepareStatement(bookSql);
            ps1.setInt(1, userId);
            ps1.setInt(2, flightId);
            ps1.setString(3, "BOOKED");
            ps1.executeUpdate();

            // 2️⃣ Update seat count
            String seatSql = "UPDATE flights SET seats_available = seats_available - 1 WHERE flight_id = ? AND seats_available > 0";
            PreparedStatement ps2 = con.prepareStatement(seatSql);
            ps2.setInt(1, flightId);

            int rows = ps2.executeUpdate();
            if (rows > 0) {
                status = true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return status;
    }
}
