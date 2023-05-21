package com.demo.Repositry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.model.Broker;
import com.demo.model.User;

@Repository
public interface BrokerRepo extends JpaRepository<Broker, Integer>{

}
