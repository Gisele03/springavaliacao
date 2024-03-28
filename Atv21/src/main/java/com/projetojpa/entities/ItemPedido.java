package com.projetojpa.entities;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "itemPedido")
public class ItemPedido {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name = "id", nullable = false)
	private Long Id;
	
	@NotNull
	@NotBlank
	@Column (name = "categoria", nullable = false, length = 255)
	private String categoria;
	
	@NotNull
	@NotBlank
	@Column (name = "descricao", nullable = false, length = 255)
	private String descricao;
	
	@NotNull
	@NotBlank
	@Column (name = "nome", nullable = false, length = 255)
	private String nome;
	
	@NotNull
	@NotBlank 
	@Column (name = "preco", nullable = false)
	private double preco;
	
	@ManyToOne (fetch = FetchType.LAZY)
	@JoinColumn(name = "id_produto", nullable = false)
	private Produto produto;
	
	@ManyToOne (fetch = FetchType.LAZY)
	@JoinColumn(name = "id_pedido", nullable = false)
	private Pedido pedido;
	

}