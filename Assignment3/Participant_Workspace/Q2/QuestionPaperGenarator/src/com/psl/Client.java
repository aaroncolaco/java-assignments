package com.psl;

import com.util.DatabaseConnectionManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Client {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        // Call your functionalities from here to test your code.
        Connection con = new DatabaseConnectionManager().getConnection();

        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM questionBank");

        while (rs.next()) {
            System.out.println(rs.getString("Question"));
        }
    }
}
