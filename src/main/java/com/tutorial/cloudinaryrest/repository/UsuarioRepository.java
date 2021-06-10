package com.tutorial.cloudinaryrest.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tutorial.cloudinaryrest.entity.Usuario;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Long>{

	public Usuario findByUsername(String username);
	
	public Usuario findByEmail(String email);
	
}
