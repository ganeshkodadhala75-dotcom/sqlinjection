package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SQLInjection {

    public static void main(String[] args) {

        String username = "admin' OR '1'='1";

        try {

            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/test",
                    "root",
                    "password");

            Statement stmt = con.createStatement();

            String query =
                    "SELECT * FROM users WHERE username='" + username + "'";

            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                System.out.println(rs.getString("username"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
