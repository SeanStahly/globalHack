package com.example.Client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by sean on 10/22/16.
 */

@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    JdbcTemplate jdbcTemplate;

    final String selectClients = "SELECT id, first_name, last_name, date_of_birth, nationality, gender, veteran_status," +
            "medical_status, phone_number, identifying_number, abused, current_shelter FROM clients";

    @RequestMapping("/getClients")
    public List<Client> getClients() {
        return jdbcTemplate.query(selectClients,
                (rs, rowNum) -> new Client(rs.getLong("id"), rs.getString("first_name"), rs.getString("last_name"),
                        rs.getDate("date_of_birth"), rs.getString("nationality"), rs.getString("gender").charAt(0),
                        rs.getString("veteran_status").charAt(0), rs.getString("medical_status"),
                        rs.getString("phone_number"), rs.getInt("identifying_number"),
                        rs.getBoolean("abused"), rs.getInt("current_shelter")))
                .stream()
                .collect(Collectors.toList());
    }
}
