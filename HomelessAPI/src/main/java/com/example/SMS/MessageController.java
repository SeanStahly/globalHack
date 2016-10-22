package com.example.SMS;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class MessageController {

    @RequestMapping("/sms/")
    public String index() {

        return "Greetings from Spring Boot!";
    }

}