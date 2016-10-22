package com.example.SMS;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class SMSToMySQL {

    private final String JDBC_DRIVER = "com.mysql.jdbc.Driver",
                         DATABASE    = "<DB URL>",
                         USER        = "<Username>",
                         PASS        = "<Password";
    private String phoneNum, body, timeStamp;

    public SMSToMySQL(String[] data) {
        //Phone num, body, time stamp.
        try {
            phoneNum = data[0];
            body = data[1];
            timeStamp = data[2];
        } catch(ArrayIndexOutOfBoundsException e) {
            System.err.println("Missing field in array: " + e.getMessage());
        }
    }

    public void parse() {

    }

    private void insertIntoDatabase() {
        try {
            //Register the driver.
            Class.forName(JDBC_DRIVER);

            //Connect to the database.
            System.out.println("Connecting to database...");
            Connection dbConnection = DriverManager.getConnection(DATABASE, USER, PASS);
            System.out.println("Connection successful.");

            //Execute query.
            String sql = "INSERT INTO Homeless()" +
                         "VALUES()";
            System.out.println("Executing query...");
            Statement editor = dbConnection.createStatement();
            editor.executeUpdate(sql);
            System.out.println("Query executed successfully.");
            dbConnection.close();
        } catch(ClassNotFoundException e) {
            e.printStackTrace();
        } catch(SQLException e) {

        }
    }
}