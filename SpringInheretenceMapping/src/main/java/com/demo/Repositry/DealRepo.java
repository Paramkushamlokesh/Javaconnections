package com.demo.Repositry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.model.Deal;

@Repository
public interface DealRepo extends JpaRepository<Deal, Integer>{

}
