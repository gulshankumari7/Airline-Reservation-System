package com.airline.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import com.airline.model.Flight;

public class FlightDAO {

    public ArrayList<Flight> searchFlights(String source, String destination, String date) {

        ArrayList<Flight> list = new ArrayList<>();

        try {
            Connection con = DBConnection.getConnection();

            String sql = "SELECT * FROM flights WHERE source=? AND destination=? AND flight_date=?";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, source);
            ps.setString(2, destination);
            ps.setString(3, date);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Flight f = new Flight(
                        rs.getInt("flight_id"),
                        rs.getString("flight_name"),
                        rs.getString("source"),
                        rs.getString("destination"),
                        rs.getString("flight_date"),
                        rs.getString("flight_time"),
                        rs.getInt("price"),
                        rs.getInt("seats_available")
                );
                list.add(f);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
}
