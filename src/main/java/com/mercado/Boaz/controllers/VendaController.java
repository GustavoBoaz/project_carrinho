package com.mercado.Boaz.controllers;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mercado.Boaz.models.Venda;
import com.mercado.Boaz.repositories.VendaRepository;

@RestController
@RequestMapping(path="/vendas") 
public class VendaController {
	
	private @Autowired VendaRepository repository;
	
	@GetMapping
	List<Venda> all(){
		return repository.findAll();
	}
	
}
