package com.tutorial.cloudinaryrest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tutorial.cloudinaryrest.entity.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Integer> {

	List<Producto> findByOrderById();
	
}
