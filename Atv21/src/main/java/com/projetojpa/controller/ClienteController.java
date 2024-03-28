package com.projetojpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projetojpa.entities.Cliente;
import com.projetojpa.services.ClienteService;

@RestController
@RequestMapping("/cliente")

public class ClienteController {
	private final ClienteService clienteService;

	@Autowired
	public ClienteController(ClienteService clienteService) {
		this.clienteService = clienteService;
	}

	@GetMapping("/{id}")
	public ResponseEntity<Cliente> buscaClienteControlId (@PathVariable Long id){
		Cliente cliente = clienteService.buscaClienteById(id);
		if(cliente != null) {
			return ResponseEntity.ok(cliente);
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
	@GetMapping("/")
	public ResponseEntity<List<Cliente>> buscaTodosClientesControl(){
		List<Cliente> cliente = clienteService.buscaTodosClientes();
		return ResponseEntity.ok(cliente);
	}
	@PostMapping("/")
	public ResponseEntity<Cliente> salvaClienteControl(@RequestBody Cliente cliente){
		Cliente salvaCliente = clienteService.salvaCliente(cliente);
		return ResponseEntity.status(HttpStatus.CREATED).body(salvaCliente);
	}
	@PutMapping("/{id}")
	public ResponseEntity<Cliente> alteraClienteControl(@PathVariable Long id, @RequestBody Cliente cliente){
		Cliente alteraCliente = clienteService.alterarCliente(id, cliente);
		if (alteraCliente != null) {
			return ResponseEntity.ok(cliente);
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<String> apagaClienteControl(@PathVariable Long id){
		boolean apagar = clienteService.apagarCliente(id);
		if(apagar) {
			return ResponseEntity.ok().body("O cliente foi excluido com sucesso");
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
}