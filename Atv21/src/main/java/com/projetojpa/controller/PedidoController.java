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

import com.projetojpa.entities.Pedido;
import com.projetojpa.services.PedidoService;

@RestController
@RequestMapping("/pedido")

public class PedidoController {
	private final PedidoService pedidoService;

	@Autowired
	public PedidoController(PedidoService pedidoService) {
		this.pedidoService = pedidoService;
	}

	@GetMapping("/{id}")
	public ResponseEntity<Pedido> buscaPedidoControlId (@PathVariable Long id){
		Pedido pedido = pedidoService.buscaPedidoById(id);
		if(pedido != null) {
			return ResponseEntity.ok(pedido);
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
	@GetMapping("/")
	public ResponseEntity<List<Pedido>> buscaTodosPedidosControl(){
		List<Pedido> pedido = pedidoService.buscaTodosPedidos();
		return ResponseEntity.ok(pedido);
	}
	@PostMapping("/")
	public ResponseEntity<Pedido> salvaPedidoControl(@RequestBody Pedido pedido){
		Pedido salvaPedido = pedidoService.salvaPedido(pedido);
		return ResponseEntity.status(HttpStatus.CREATED).body(salvaPedido);
	}
	@PutMapping("/{id}")
	public ResponseEntity<Pedido> alteraPedidoControl(@PathVariable Long id, @RequestBody Pedido pedido){
		Pedido alteraPedido = pedidoService.alterarPedido(id, pedido);
		if (alteraPedido != null) {
			return ResponseEntity.ok(pedido);
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<String> apagaPedidoControl(@PathVariable Long id){
		boolean apagar = pedidoService.apagarPedido(id);
		if(apagar) {
			return ResponseEntity.ok().body("O pedido foi excluido com sucesso");
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
}