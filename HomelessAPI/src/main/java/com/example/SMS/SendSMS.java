package com.example.SMS;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;


public class SendSMS {

    // Find your Account Sid and Token at twilio.com/user/account
    private static final String ACCOUNT_SID = "ACd2ac14154410d277d4ed72f55e884b7c";
    private static final String AUTH_TOKEN = "89ee10f7d5b95b031e8e74bb0731f6cf";
    private static final String PHONE_NUMBER = "+12085907358";

    private Message message;
    private String number = "";
    private String messageBody = "";

    public SendSMS(String num, String msg) {
        number = num;
        messageBody = msg;
    }

    public void send(){
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

        message = Message.creator(new PhoneNumber(PHONE_NUMBER),
                new PhoneNumber(number), messageBody).create();
    }

    public void setMessage(String msg){
        messageBody = msg;
    }

    public void setNumber(String num){
        number = num;
    }

    public Message.Status status(){
        return message.getStatus();
    }
}