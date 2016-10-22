package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * Created by sean on 10/21/16.
 */
@RestController
public class HelloController {

    @RequestMapping("/")
    public String index() {

        return "Greetings from Spring Boot!";
    }
}
