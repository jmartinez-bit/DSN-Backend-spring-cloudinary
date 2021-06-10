package com.tutorial.cloudinaryrest.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tutorial.cloudinaryrest.entity.Usuario;
import com.tutorial.cloudinaryrest.service.RegisterService;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class RegisterController {

	@Autowired
	RegisterService registerService;
	
	@PostMapping("/save")
	public ResponseEntity<?> create(@RequestBody Usuario usuario) {

		Map<String, Object> response = new HashMap<>();
		
		try {
			registerService.addUser(usuario); 			
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar el insert en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("mensaje", "Usuario registrado satisfactoriamente");
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	
}
