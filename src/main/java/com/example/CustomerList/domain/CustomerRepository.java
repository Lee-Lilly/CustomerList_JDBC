package com.example.CustomerList.domain;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.CustomerList.domain.CustomerRowMapper;

@Repository
public class CustomerRepository{
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	
	//Creates an instance of JdbcTemplate and supply a data source object.
   // JdbcTemplate template = new JdbcTemplate(this.dataSource); 
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	@Transactional(readOnly=true)
	public List<Customer> findAll() {
		return jdbcTemplate.query("select * from customers", new CustomerRowMapper());
	}
	

	public void save(Customer customer) {
		String sql = "insert into customers(first_name, last_name, email) values(?,?,?)";
		Object[] parameters = new Object[]{customer.getFirstName(), customer.getLastName(), customer.getEmail()};
		
		jdbcTemplate.update(sql, parameters);
	}
	
	public void delete(Long id) {
		String sql = "delete from customers where id = ?";
		jdbcTemplate.update(sql, id);

	}
	
	public List<Customer> findByName(String lastName) {
		String sql = "select * from customers where last_name = ?";
		RowMapper<Customer> mapper = new CustomerRowMapper();
		
		return jdbcTemplate.query(sql, mapper, lastName);
		
	} 
	
	public Customer findOne(Long id) {
		String sql = "select id, first_name, last_name, email from customers where id = ?";
		RowMapper<Customer> mapper = new CustomerRowMapper();

		Customer customer= jdbcTemplate.queryForObject(sql, mapper, id);
		return customer;
	}
	
}
