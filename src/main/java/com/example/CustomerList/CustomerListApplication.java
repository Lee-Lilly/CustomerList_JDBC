package com.example.CustomerList;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
//import org.springframework.jdbc.core.JdbcTemplate;

import com.example.CustomerList.domain.Customer;
import com.example.CustomerList.domain.CustomerRepository;

@SpringBootApplication
public class CustomerListApplication {
	
	private static final Logger log = LoggerFactory.getLogger(CustomerListApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(CustomerListApplication.class, args);
	}
	
//	@Autowired
//	private JdbcTemplate jdbcTemplate;
	
	@Bean
	public CommandLineRunner customerDemo(CustomerRepository customerRepos) {
		return (args) -> {
			
			// Database "Customers" is created by using mySQL command line
			log.info("create table");
			// Table "customers" is created by "schema.sql"
//			 jdbcTemplate.execute("CREATE TABLE IF NOT EXISTS customers (\n" + 
//			 		"    id int(5) NOT NULL AUTO_INCREMENT,\n" + 
//			 		"    first_name varchar(50) DEFAULT NULL,\n" + 
//			 		"    last_name varchar(50) DEFAULT NULL,\n" + 
//			 		"    email varchar(50) DEFAULT NULL,\n" + 
//			 		"    PRIMARY KEY(id),\n" + 
//			 		"    CONSTRAINT email_unique UNIQUE(email)\n" + 
//			 		"    )");
			
			log.info("Save some customer records");
			//customers' records are added by "schema.sql" 

//			 customerRepos.save(new Customer("John", "West", "West.John@gmail.com"));
//		     customerRepos.save(new Customer("Mike", "Mars", "Mar.Mike@yahoo.com"));
//		     customerRepos.save(new Customer("Kate", "Johnson", "Johnson.kate@hotmail.com"));
											
			log.info("retrieve some records");
			
			List<Customer> customers = customerRepos.findByName("West");
			log.info(customers.toString());
			
		};
	}
	
	
}
