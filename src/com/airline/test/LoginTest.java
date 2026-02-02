package com.airline.test;

import java.util.Scanner;
import com.airline.dao.UserDAO;

public class LoginTest {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter email: ");
        String email = sc.nextLine();

        System.out.print("Enter password: ");
        String password = sc.nextLine();

        UserDAO dao = new UserDAO();
        boolean result = dao.loginUser(email, password);

        if (result) {
            System.out.println("✅ Login successful");
        } else {
            System.out.println("❌ Invalid email or password");
        }

        sc.close();
    }
}
