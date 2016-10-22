package com.example;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;


public class SendSMS {

    // Find your Account Sid and Token at twilio.com/user/account
    public static final String ACCOUNT_SID = "ACd2ac14154410d277d4ed72f55e884b7c";
    public static final String AUTH_TOKEN = "89ee10f7d5b95b031e8e74bb0731f6cf";

    public static void main(String[] args) {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

        Message message = Message.creator(new PhoneNumber("+12085907358"),
                new PhoneNumber("+12085918302"),
                "Test").create();

        System.out.println(message.getSid());
    }
}