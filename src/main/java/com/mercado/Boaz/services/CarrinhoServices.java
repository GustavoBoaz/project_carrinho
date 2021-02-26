package com.mercado.Boaz.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mercado.Boaz.models.Carrinho;
import com.mercado.Boaz.models.Venda;
import com.mercado.Boaz.repositories.CarrinhoRepository;
import com.mercado.Boaz.repositories.VendaRepository;

@Service
public class CarrinhoServices {

	private @Autowired CarrinhoRepository carrinhoRepository;
	private @Autowired VendaRepository vendaRepository;
	
	// Passando novo carrinho do Cliente.
	public Carrinho novoCarrinho(Carrinho carrinho){	
		return carrinhoRepository.save(carrinho);
	}
	
	// Caso o cliente desista da compra
	public void deletarCarrinho(Long id) {
		carrinhoRepository.deleteById(id);
	}
	
	// Adcionando venda de produto
	public void addVenda(Venda venda, Long idCarrinho) {
		carrinhoRepository.findById(idCarrinho)
				.ifPresent(carrinho -> {
					Venda novaVenda = new Venda();
					novaVenda.setProduto(venda.getProduto());
					novaVenda.setCarrinho(carrinho);
					vendaRepository.save(novaVenda);
				});
	}
}
