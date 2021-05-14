package com.tutorial.cloudinaryrest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tutorial.cloudinaryrest.entity.Imagen;

@Repository
public interface ImagenRepository extends JpaRepository<Imagen, Integer> {

	List<Imagen> findByOrderById();
	
}
