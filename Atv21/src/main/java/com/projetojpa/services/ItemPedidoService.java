package com.projetojpa.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetojpa.entities.ItemPedido;
import com.projetojpa.repository.ItemPedidoRepository;

@Service 
public class ItemPedidoService { 
	private final ItemPedidoRepository itemPedidoRepository; 

	@Autowired 
	public ItemPedidoService(ItemPedidoRepository itemPedidoRepository) { 
        this.itemPedidoRepository = itemPedidoRepository; 
    } 

	public List<ItemPedido> buscaTodosItemPedidos(){ 
		return itemPedidoRepository.findAll(); 
	} 
	
    public ItemPedido buscaItemPedidoById(Long id) { 
    	Optional <ItemPedido> itemPedido = itemPedidoRepository.findById(id); 
        return itemPedido.orElse(null); 
    } 

    public ItemPedido salvaItemPedido(ItemPedido itemPedido) { 
        return itemPedidoRepository.save(itemPedido); 
    } 

    public ItemPedido alterarItemPedido(Long id, ItemPedido alterarItemPedido) { 
    	Optional <ItemPedido> existeItemPedido = itemPedidoRepository.findById(id); 
    	if(existeItemPedido.isPresent()) { 
    		alterarItemPedido.setId(id); 
    		return itemPedidoRepository.save(alterarItemPedido); 
    	} 
    	return null; 
    } 
    public boolean apagarItemPedido(Long id) { 
    	Optional <ItemPedido> existeItemPedido = itemPedidoRepository.findById(id); 
    	if(existeItemPedido.isPresent()) { 
    		itemPedidoRepository.deleteById(id); 
    		return true; 
    	} 
    	return false; 
    } 

}