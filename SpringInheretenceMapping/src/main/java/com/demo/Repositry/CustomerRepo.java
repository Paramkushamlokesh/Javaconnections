package com.demo.Repositry;

import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.model.Customer;
import com.demo.model.User;


@Repository
public interface CustomerRepo extends JpaRepository<Customer, Integer> {

}
