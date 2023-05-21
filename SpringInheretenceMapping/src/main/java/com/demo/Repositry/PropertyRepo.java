package com.demo.Repositry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.model.Property;


@Repository
public interface PropertyRepo extends JpaRepository<Property, Integer>{

}
