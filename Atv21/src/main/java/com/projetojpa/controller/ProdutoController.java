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

import com.projetojpa.entities.Produto;
import com.projetojpa.services.ProdutoService;

@RestController
@RequestMapping("/produto")

public class ProdutoController {
	private final ProdutoService produtoService;

	@Autowired
	public ProdutoController(ProdutoService produtoService) {
		this.produtoService = produtoService;
	}

	@GetMapping("/{id}")
	public ResponseEntity<Produto> buscaProdutoControlId (@PathVariable Long id){
		Produto produto = produtoService.buscaProdutoById(id);
		if(produto != null) {
			return ResponseEntity.ok(produto);
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
	@GetMapping("/")
	public ResponseEntity<List<Produto>> buscaTodosProdutosControl(){
		List<Produto> produto = produtoService.buscaTodosProdutos();
		return ResponseEntity.ok(produto);
	}
	@PostMapping("/")
	public ResponseEntity<Produto> salvaProdutoControl(@RequestBody Produto produto){
		Produto salvaProduto = produtoService.salvaProduto(produto);
		return ResponseEntity.status(HttpStatus.CREATED).body(salvaProduto);
	}
	@PutMapping("/{id}")
	public ResponseEntity<Produto> alteraProdutoControl(@PathVariable Long id, @RequestBody Produto produto){
		Produto alteraProduto = produtoService.alterarProduto(id, produto);
		if (alteraProduto != null) {
			return ResponseEntity.ok(produto);
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<String> apagaProdutoControl(@PathVariable Long id){
		boolean apagar = produtoService.apagarProduto(id);
		if(apagar) {
			return ResponseEntity.ok().body("O produto foi excluido com sucesso");
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
}