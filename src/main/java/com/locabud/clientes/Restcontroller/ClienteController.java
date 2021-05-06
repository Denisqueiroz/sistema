package com.locabud.clientes.Restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.locabud.clientes.model.Cliente;
import com.locabud.clientes.repository.ClienteRepository;

@RestController
@RequestMapping(value="/api/clientes")

public class ClienteController {
	
	@Autowired
	private ClienteRepository repository;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Cliente insert(@RequestBody Cliente cliente) {
		return repository.save(cliente);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public Cliente find(@PathVariable Integer id) {
		return repository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
		
	}
	
	@DeleteMapping(value="/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete (@PathVariable Integer id) {
		repository
		.findById(id)
		.map(cliente ->{ 
			repository.delete(cliente);
			return Void.TYPE ;
			})
		.orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
		
	}
	
	@PutMapping("{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void update(@PathVariable Integer id, @RequestBody Cliente clienteUpdate) {
		repository
		.findById(id)
		.map(cliente ->{ 
			clienteUpdate.setId(cliente.getId());
			return repository.save(clienteUpdate);
			
			})
		.orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}
}
