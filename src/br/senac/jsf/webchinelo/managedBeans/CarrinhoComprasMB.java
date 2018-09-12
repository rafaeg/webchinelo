package br.senac.jsf.webchinelo.managedBeans;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import br.senac.jsf.webchinelo.modelo.Produto;
import br.senac.jsf.webchinelo.modelo.Pedido;

@ManagedBean
@SessionScoped
public class CarrinhoComprasMB {
	private Pedido pedido = new Pedido(); 
	
	public void adicionaItem(Produto produto){
		pedido.adicionaItem(produto);
		apresentaMensagem("item " + produto + " adicionado");
	}
	public void removeItem(Produto produto){
		pedido.removeItem(produto);
		apresentaMensagem("item " + produto + " removido");
	}
	public Pedido getPedido() {
		return pedido;
	}
	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	};
	private void apresentaMensagem(String resumoMensagem) {
		FacesContext contexto = FacesContext.getCurrentInstance();

		FacesMessage mensagem = new FacesMessage(resumoMensagem);
		mensagem.setSeverity(FacesMessage.SEVERITY_INFO);
		
		String idDoComponenteRelacionado = null;  // nenhum componente em particular
		
		contexto.addMessage(idDoComponenteRelacionado, mensagem);
	}
}
