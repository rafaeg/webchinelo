package br.senac.jsf.webchinelo.modelo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.senac.jsf.webchinelo.modelo.Produto;
import br.senac.jsf.webchinelo.modelo.Cliente;
import br.senac.jsf.webchinelo.modelo.ItemPedido;

public class Pedido extends Entidade{
	private Date data; 
	private Cliente cliente; 
	private List<ItemPedido> itens = new ArrayList<ItemPedido>(); 
	private double valorTotal; 
	public void adicionaItem(Produto produto) {
		ItemPedido novoItem = new ItemPedido();
		novoItem.setProduto(produto);
		novoItem.setQuantidade(1);		
		int posicaoNaLista = itens.indexOf(novoItem);
		ItemPedido itemProdutoJaAdicionado;
		if (posicaoNaLista>=0) {
			itemProdutoJaAdicionado = itens.get(posicaoNaLista);
			itemProdutoJaAdicionado.setQuantidade(itemProdutoJaAdicionado.getQuantidade()+novoItem.getQuantidade());
		} else {
			itens.add(novoItem);
			itemProdutoJaAdicionado = novoItem;
		}
		itemProdutoJaAdicionado.setValorTotal(itemProdutoJaAdicionado.getQuantidade() * itemProdutoJaAdicionado.getProduto().getValor());
	}; 
	public void removeItem(Produto produto) {
		ItemPedido item = new ItemPedido();
		item.setProduto(produto);
		itens.remove(item);
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public List<ItemPedido> getItens() {
		return itens;
	}
	public void setItens(List<ItemPedido> itens) {
		this.itens = itens;
	}
	public double getValorTotal() {
		valorTotal = 0.0;
		for (ItemPedido item : this.itens)
			valorTotal += item.getValorTotal();
		return valorTotal;
	}

}
