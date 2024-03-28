package com.projetojpa.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "fornecedor")
public class Fornecedor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name = "id", nullable = false)
	private Long Id;
	
	@NotNull
	@NotBlank
	@Column (name = "cnpj", nullable = false, length = 255)
	private String cnpj;
	
	@NotNull
	@NotBlank 
	@Email
	@Column (name = "email", nullable = false, length = 255)
	private String email;
	
	@NotNull
	@NotBlank
	@Column (name = "nome", nullable = false, length = 255)
	private String nome;
	
	@NotNull
	@NotBlank
	@Column (name = "telefone", nullable = false, length = 255)
	private String telefone;
	

	

}