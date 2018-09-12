package br.senac.jsf.webchinelo.managedBeans;

import java.util.Collection;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.senac.jsf.webchinelo.modelo.Produto;

@ManagedBean
@ViewScoped
public class ProdutoMB {

	@ManagedProperty(value="#{aplicacaoMB}")
	private AplicacaoMB aplicacaoMB;
	
	private Produto produto;
	
	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	
	public ProdutoMB() {
		System.out.println("passou no contutor do " + this.getClass().getSimpleName());
	}
		
	@PostConstruct
	public void inicializa() {
		System.out.println("passou no PostContruct do " + this.getClass().getSimpleName());
		produto = new Produto();
		System.out.println("o estado atual do produto neste MB é " + produto);
	}

	@PreDestroy
	public void liberaRecursos() {		
		System.out.println("passou no PreDestrouy do " + this.getClass().getSimpleName());
		System.out.println("o estado atual do produto neste MB é " + produto);
	}

	public String grava() {
		System.out.println("Vai gravar o produto no banco: " +produto);
		
		if (modo==ModoPagina.novo)
			aplicacaoMB.getProdutoDAO().grava(produto);
		else if (modo==ModoPagina.altera)
			aplicacaoMB.getProdutoDAO().atualiza(produto);
		
		String resumoMensagem = "Gravou o produto no banco: " + produto;
		System.out.println(resumoMensagem);
		
		apresentaMensagem(resumoMensagem);
		
		modo=ModoPagina.listagem;
		
		return null;
		
	}
	
	public String remove(Produto produto) {
		aplicacaoMB.getProdutoDAO().remove(produto);
		return null;
	}
	
	public Collection<Produto> getLista() {
		Collection<Produto> lista = aplicacaoMB.getProdutoDAO().lista(); 
		return lista;
	}
		
	private void apresentaMensagem(String resumoMensagem) {
		FacesContext contexto = FacesContext.getCurrentInstance();

		FacesMessage mensagem = new FacesMessage(resumoMensagem);
		mensagem.setSeverity(FacesMessage.SEVERITY_INFO);
		
		String idDoComponenteRelacionado = null;  // nenhum componente em particular
		
		contexto.addMessage(idDoComponenteRelacionado, mensagem);
	}

	public AplicacaoMB getAplicacaoMB() {
		return aplicacaoMB;
	}

	public void setAplicacaoMB(AplicacaoMB aplicacaoMB) {
		this.aplicacaoMB = aplicacaoMB;
	}
	
	public boolean isNaoEstaEmModoListagem() {
		return modo != ModoPagina.listagem;
	}
	
	public boolean isNaoEstaEmModoInclusaoOuEdicao() {
		return modo != ModoPagina.altera && modo != ModoPagina.novo;
	}
	
	public String novo() {
		modo=ModoPagina.novo;
		this.produto = new Produto();
		System.out.println("Dado um reset nas informações do novo produtol.");
		return null;
	}
	
	public String preparaAlteracao(Produto produto) {
		modo = ModoPagina.altera;
		this.produto = produto;
		return null;		
	}
	
	public String mostraDetalhes(Produto produto) {
		modo = ModoPagina.consulta;
		this.produto = produto;
		return null;
		
	}

	public enum ModoPagina {
		consulta,
		altera,
		novo,
		listagem
	}
	
	private ModoPagina modo = ModoPagina.listagem;
	
}
