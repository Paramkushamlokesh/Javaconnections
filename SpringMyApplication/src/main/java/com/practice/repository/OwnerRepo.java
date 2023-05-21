package com.practice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.practice.model.Owner;
@Repository
public interface OwnerRepo extends JpaRepository<Owner, Integer> {
		Owner findByUsername(String username);
}
