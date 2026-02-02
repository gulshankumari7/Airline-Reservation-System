package com.airline.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import com.airline.model.User;

public class UserDAO {
	public boolean loginUser(String email, String password) {
	    boolean status = false;

	    try {
	        Connection con = DBConnection.getConnection();

	        String sql = "SELECT * FROM users WHERE email = ? AND password = ?";
	        PreparedStatement ps = con.prepareStatement(sql);

	        ps.setString(1, email);
	        ps.setString(2, password);

	        var rs = ps.executeQuery();

	        if (rs.next()) {
	            status = true;
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return status;
	}

    public boolean registerUser(User user) {
        boolean status = false;

        try {
            Connection con = DBConnection.getConnection();

            String sql = "INSERT INTO users(name, email, password) VALUES (?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, user.getName());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getPassword());

            int rows = ps.executeUpdate();
            if (rows > 0) {
                status = true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return status;
    }
}
