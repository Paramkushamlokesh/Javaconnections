package com.practice.service;

import java.util.List;

import com.practice.model.Owner;

public interface OwnerService {
		Owner save(Owner owner);
		Owner findOwnerbyid(Integer id);
		Owner findOwnerbyusername(String username);
		List<Owner> findAllOwners();
}
