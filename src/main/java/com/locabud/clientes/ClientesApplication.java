package com.locabud.clientes;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.locabud.clientes.model.Cliente;
import com.locabud.clientes.repository.ClienteRepository;

@SpringBootApplication
public class ClientesApplication  implements CommandLineRunner {

	@Autowired
	private ClienteRepository clienteRepository;
	
		
	public static void main(String[] args) {
		SpringApplication.run(ClientesApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		
		Cliente cli1 = new Cliente(null,"Maria do Bairro", "12345678910", null);
		
		clienteRepository.saveAll(Arrays.asList(cli1));
		
	}

}
