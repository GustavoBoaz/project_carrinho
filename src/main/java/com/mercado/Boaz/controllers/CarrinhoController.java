package com.mercado.Boaz.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mercado.Boaz.models.Carrinho;
import com.mercado.Boaz.models.Venda;
import com.mercado.Boaz.repositories.CarrinhoRepository;
import com.mercado.Boaz.services.CarrinhoServices;

@RestController
public class CarrinhoController {
	
	private @Autowired CarrinhoServices services;
	private @Autowired CarrinhoRepository carrinhoRepository;
	
	@GetMapping("/carrinhos")
	List<Carrinho> all(){
		return carrinhoRepository.findAll();
	}
	
	@PostMapping("/nova")
	public ResponseEntity<Carrinho> novaCompra(@Valid @RequestBody Carrinho carrinho){
		services.novoCarrinho(carrinho);
		return new ResponseEntity<Carrinho>(carrinho, HttpStatus.CREATED);
	}
	
	@PutMapping("/inserir/{idCarrinho}")
	public ResponseEntity<?> inserirProduto(@Valid @RequestBody Venda venda,@PathVariable(value = "idCarrinho") Long id_carrinho){
		services.addVenda(venda, id_carrinho);
		return new ResponseEntity<String>("Produto adcionado a Venda", HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{idCarrinho}")
	public ResponseEntity<?> deletaCarrinho(@PathVariable(value = "idCarrinho") Long id) {
		services.deletarCarrinho(id);
		return new ResponseEntity<String>("Carrinho Deletado", HttpStatus.OK);
	}
}
