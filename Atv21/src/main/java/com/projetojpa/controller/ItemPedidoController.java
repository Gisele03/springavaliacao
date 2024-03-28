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

import com.projetojpa.entities.ItemPedido;
import com.projetojpa.services.ItemPedidoService;

@RestController
@RequestMapping("/itemPedido")

public class ItemPedidoController {
	private final ItemPedidoService itemPedidoService;

	@Autowired
	public ItemPedidoController(ItemPedidoService itemPedidoService) {
		this.itemPedidoService = itemPedidoService;
	}

	@GetMapping("/{id}")
	public ResponseEntity<ItemPedido> buscaItemPedidoControlId (@PathVariable Long id){
		ItemPedido itemPedido = itemPedidoService.buscaItemPedidoById(id);
		if(itemPedido != null) {
			return ResponseEntity.ok(itemPedido);
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
	@GetMapping("/")
	public ResponseEntity<List<ItemPedido>> buscaTodosItemPedidosControl(){
		List<ItemPedido> itemPedido = itemPedidoService.buscaTodosItemPedidos();
		return ResponseEntity.ok(itemPedido);
	}
	@PostMapping("/")
	public ResponseEntity<ItemPedido> salvaItemPedidoControl(@RequestBody ItemPedido itemPedido){
		ItemPedido salvaItemPedido = itemPedidoService.salvaItemPedido(itemPedido);
		return ResponseEntity.status(HttpStatus.CREATED).body(salvaItemPedido);
	}
	@PutMapping("/{id}")
	public ResponseEntity<ItemPedido> alteraItemPedidoControl(@PathVariable Long id, @RequestBody ItemPedido itemPedido){
		ItemPedido alteraItemPedido = itemPedidoService.alterarItemPedido(id, itemPedido);
		if (alteraItemPedido != null) {
			return ResponseEntity.ok(itemPedido);
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<String> apagaItemPedidoControl(@PathVariable Long id){
		boolean apagar = itemPedidoService.apagarItemPedido(id);
		if(apagar) {
			return ResponseEntity.ok().body("O ItemPedido foi excluido com sucesso");
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
}