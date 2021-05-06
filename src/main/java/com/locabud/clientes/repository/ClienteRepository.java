package com.locabud.clientes.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.locabud.clientes.model.Cliente;

public interface ClienteRepository  extends JpaRepository<Cliente, Integer>{

}
