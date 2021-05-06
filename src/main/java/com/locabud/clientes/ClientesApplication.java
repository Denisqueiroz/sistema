package com.locabud.clientes;



import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ClientesApplication  implements CommandLineRunner {

//	@Autowired
//	private ClienteRepository clienteRepository;
	
		
	public static void main(String[] args) {
		SpringApplication.run(ClientesApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		
//		Cliente cli1 = new Cliente(null,"Maria do Bairro", "1234567810", null);
//		
//		clienteRepository.saveAll(Arrays.asList(cli1));
		
	}

}
