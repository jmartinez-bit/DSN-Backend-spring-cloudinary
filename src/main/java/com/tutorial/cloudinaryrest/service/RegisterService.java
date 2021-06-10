package com.tutorial.cloudinaryrest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tutorial.cloudinaryrest.entity.Role;
import com.tutorial.cloudinaryrest.entity.Usuario;
import com.tutorial.cloudinaryrest.repository.RoleRepository;
import com.tutorial.cloudinaryrest.repository.UsuarioRepository;

@Service
public class RegisterService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Transactional
	public void addUser(Usuario usuario) {
		
		if(usuario != null) {
			
			usuario.setEnabled(true);
			usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
			usuarioRepository.save(usuario);
			
			Role role = new Role();
			role.setUsuario(usuario);
			roleRepository.save(role);
			
		}
	}
	
}
