package com.example.SMS;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SMSToMySQL {

    private final String JDBC_DRIVER = "com.mysql.jdbc.Driver",
                         DATABASE    = "GlobalHack2.il1.rdbs.ctl.io",
                         USER        = "devlopers",
                         PASS        = "Eightspaces8";
    private String phoneNum, timeStamp, body, gender, age, vetStatus, abused;

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
        String[] values = body.split(" ");




        age = values[0];
        vetStatus = values[1];
        abused = values[2];
    }

    private void insertIntoDatabase() {
        try {
            //Register the driver.
            Class.forName(JDBC_DRIVER);

            //Connect to the database.
            System.out.println("Connecting to database...");
            Connection dbConnection = DriverManager.getConnection(DATABASE, USER, PASS);
            System.out.println("Connection successful.");

            String creationDate = new SimpleDateFormat("dd-MM-yy").format(new Date());
            String fields ="Phone_num, Time, Gender, Age, Vet_status, Abused, Recommended_location, Record_creation_date";
            String values = phoneNum + ", " + timeStamp + ", " + gender + ", " +  age + ", " + vetStatus + ", " +
                    abused + ", NULL, " + creationDate;

            //Execute query.
            String sql= String.format("INSERT INTO Homeless(%d)" +
                                      "VALUES(%d)", fields, values);
            System.out.println("Executing query...");
            Statement editor = dbConnection.createStatement();
            editor.executeUpdate(sql);
            System.out.println("Query executed successfully.");

            dbConnection.close();
        } catch(ClassNotFoundException e) {
            System.err.println("Error in registering the driver: " + e.getMessage());
        } catch(SQLException e) {
            System.err.println("Error in connection with the database: " + e.getMessage());
        }
    }
}