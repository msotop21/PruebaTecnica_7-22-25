package com.oriontek.crm.clientes.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oriontek.crm.clientes.dao.ClienteRepository;
import com.oriontek.crm.clientes.dto.Cliente;

import jakarta.transaction.Transactional;

@Service
public class ClientesService {
	
	@Autowired
	ClienteRepository dao;
	
	@Autowired
	public ClientesService(ClienteRepository clienteRepository) {
		this.dao = dao;
	}
	
	public Cliente save(Cliente cliente) {
		return dao.saveAndFlush(cliente);
	}

	public List<Cliente> buscaTodosClientes() {
        return dao.findAll();
    }
	
	public Optional buscaClientePorId(Long id) {
	    Optional<Cliente> optionalCliente = dao.findById(id);
	    
	    return optionalCliente;
	}
	
	@Transactional
	public Cliente actualizaCliente(Cliente cliente) {
	   
		   Cliente updateResponse = dao.save(cliente);
		   
		   return updateResponse;
	}
}
