package com.tutorial.cloudinaryrest.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tutorial.cloudinaryrest.entity.Role;

@Repository
public interface RoleRepository extends CrudRepository<Role, Long>{
	
}
