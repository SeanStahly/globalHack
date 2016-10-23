package com.example.SMS;

import java.io.IOException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ReceiveSMS extends HttpServlet {
    public void service(HttpServletRequest request, HttpServletResponse response) throws IOException {

        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy-HH:mm:ss");

        String timeStamp = sdf.format(cal.getTime());
        String body = request.getParameter("Body");
        String phoneNum = request.getParameter("From");

        String[] received = new String[3];
        received[0] = phoneNum;
        received[1] = body;
        received[2] = timeStamp;

        SMSToMySQL parser = new SMSToMySQL(received);

        parser.parse();
        parser.insertIntoDatabase();
    }
}