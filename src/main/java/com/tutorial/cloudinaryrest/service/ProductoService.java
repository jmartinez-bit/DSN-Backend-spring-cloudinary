package com.tutorial.cloudinaryrest.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tutorial.cloudinaryrest.entity.Imagen;
import com.tutorial.cloudinaryrest.entity.Producto;
import com.tutorial.cloudinaryrest.repository.ImagenRepository;
import com.tutorial.cloudinaryrest.repository.ProductoRepository;

@Service
@Transactional
public class ProductoService {
	
	@Autowired
	ProductoRepository productoRepository;
	
	@Autowired
	ImagenRepository imagenRepository;
	
	@Transactional(readOnly = true)
	public List<Producto> list() {
		return productoRepository.findByOrderById();
	}
	
	@Transactional(readOnly = true)
	public Optional<Producto> getOne(int id) {
		return productoRepository.findById(id);
	}
	
	@Transactional
	public Producto save(Producto producto) {
		return productoRepository.save(producto);
	}
	
	@Transactional
	public void delete(int id) {
		productoRepository.deleteById(id);
	}
	
	@Transactional(readOnly = true)
	public boolean exists(int id) {
		return productoRepository.existsById(id);
	}
}
