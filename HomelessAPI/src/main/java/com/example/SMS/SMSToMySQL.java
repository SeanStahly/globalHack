package com.example.SMS;

public class SMSToMySQL {

    private String phoneNum, body, timeStamp;
    private final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private final String DATABASE = "<DB URL>";
    


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

    }

}