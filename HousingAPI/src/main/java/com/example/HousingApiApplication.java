package com.example;

import com.example.Client.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
public class HousingApiApplication implements CommandLineRunner {

	@Autowired
	JdbcTemplate jdbcTemplate;

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(HousingApiApplication.class, args);
//		SpringApplication.run(HousingApiApplication.class, args);

//		jdbcTemplate.execute("");

//		System.out.println("Let's inspect the beans provided by Spring Boot:");
//
//		String[] beanNames = ctx.getBeanDefinitionNames();
//		Arrays.sort(beanNames);
//		for (String beanName : beanNames) {
//			System.out.println(beanName);
//		}
	}

	@Override
	public void run(String... strings) throws Exception {


		jdbcTemplate.execute("DROP TABLE clients IF EXISTS");
		jdbcTemplate.execute("CREATE TABLE clients(id INT, name VARCHAR(255))");

		List<Object[]> splitUpNames = Arrays.asList("Ian Lim", "Jerry Quintero I", "Eduardo Salas", "Derek Rose").stream()
				.map(name -> {
					String[] arrs = {name};
					return arrs;
				})
				.collect(Collectors.toList());

		splitUpNames.forEach(name -> System.out.println("Creating Client: " + name[0]));
		jdbcTemplate.batchUpdate("INSERT INTO clients(name) VALUES(?)", splitUpNames);
		System.out.println("Querying for 'Derek'");

		jdbcTemplate.query(
				"SELECT id, name FROM clients WHERE name = ?", new Object[] { "Derek Rose"},
				(rs, rowNum) -> new Client(rs.getLong("id"), rs.getString("name"))
		).forEach(client -> System.out.println(client.toString()));


	}
}
