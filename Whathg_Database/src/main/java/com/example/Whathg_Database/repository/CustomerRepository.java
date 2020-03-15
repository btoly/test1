package com.example.Whathg_Database.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.Whathg_Database.model.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
	List<Customer> findByAge(int age);
}
