package com.airline.test;

import java.util.Scanner;
import com.airline.dao.UserDAO;
import com.airline.model.User;

public class RegisterTest {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter name: ");
        String name = sc.nextLine();

        System.out.print("Enter email: ");
        String email = sc.nextLine();

        System.out.print("Enter password: ");
        String password = sc.nextLine();

        User user = new User(name, email, password);

        UserDAO dao = new UserDAO();
        boolean result = dao.registerUser(user);

        if (result) {
            System.out.println("✅ User registered successfully");
        } else {
            System.out.println("❌ Registration failed");
        }

        sc.close();
    }
}
