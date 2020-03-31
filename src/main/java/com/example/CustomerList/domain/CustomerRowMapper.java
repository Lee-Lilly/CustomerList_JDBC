package com.example.CustomerList.domain;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import com.example.CustomerList.domain.Customer;

public class CustomerRowMapper implements RowMapper<Customer> {
	@Override
	public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
		Customer customer = new Customer();
		customer.setId(rs.getLong("id")); //get "id" from table column "id"
		customer.setFirstName(rs.getString("first_name")); //get "firsName" from table column "first_name"
		customer.setLastName(rs.getString("last_name"));
		customer.setEmail(rs.getString("email"));

		return customer;
	}

}
