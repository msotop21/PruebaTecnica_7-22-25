package com.oriontek.crm.clientes.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oriontek.crm.clientes.dto.Cliente;
import com.oriontek.crm.clientes.service.ClientesService;

@RestController
@CrossOrigin(origins="*")
@RequestMapping("/api/clientes")
public class ClienteController {

	 @Autowired
	 ClientesService clientesService;
	 
	 
	  @GetMapping
	  public  List<Cliente> buscaClientes(){
		  return clientesService.buscaTodosClientes();
	  }
	  
	  @PostMapping
	    public Cliente creaClientes(@RequestBody Cliente cliente) {
	        cliente.getDirecciones().forEach(d -> d.setCliente(cliente));
	        return clientesService.save(cliente);
	    }
	  
	  @PutMapping
	    public Cliente actualizaClientes(@RequestBody Cliente cliente) {
		  Cliente updateResponse = clientesService.actualizaCliente(cliente);
		  return updateResponse;
	    }
}
