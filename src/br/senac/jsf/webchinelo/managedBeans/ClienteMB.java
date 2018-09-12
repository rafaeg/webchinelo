package br.senac.jsf.webchinelo.managedBeans;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.senac.jsf.webchinelo.managedBeans.ProdutoMB.ModoPagina;
import br.senac.jsf.webchinelo.modelo.Cliente;
import br.senac.jsf.webchinelo.modelo.Produto;
import br.senac.jsf.webchinelo.modelo.Sexo;

@ManagedBean
@ViewScoped
public class ClienteMB {

	@ManagedProperty(value="#{aplicacaoMB}")
	private AplicacaoMB aplicacaoMB;
	
	private Cliente cliente;

	private Sexo sexos = Sexo.naoInformado;
	
	private boolean naoEscolhido;

		
	public ClienteMB() {
		System.out.println("passou no contutor do " + this.getClass().getSimpleName());
	}
		
	@PostConstruct
	public void inicializa() {
		System.out.println("passou no PostContruct do " + this.getClass().getSimpleName());
		cliente = new Cliente();
		naoEscolhido = true;
		System.out.println("o estado atual do cliente neste MB é " + cliente);
	}

	@PreDestroy
	public void liberaRecursos() {		
		System.out.println("passou no PreDestrouy do " + this.getClass().getSimpleName());
		System.out.println("o estado atual do cliente neste MB é " + cliente);
	}
	
	public Cliente getCliente() {
		System.out.println("passou no getCliente()" + cliente);
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		System.out.println("passou no setCliente(): " + cliente);
		this.cliente = cliente;
	}
	
	public String grava() {
		System.out.println("Vai gravar o cliente no banco: " + cliente);
		aplicacaoMB.getClienteDAO().grava(cliente);
		String resumoMensagem = "Gravou o cliente no banco: " + cliente;
		System.out.println(resumoMensagem);
		apresentaMensagem(resumoMensagem);
		return null;
	}

	private void apresentaMensagem(String resumoMensagem) {
		
		FacesContext contexto = FacesContext.getCurrentInstance();

		FacesMessage mensagem = new FacesMessage(resumoMensagem);
		mensagem.setSeverity(FacesMessage.SEVERITY_INFO);
		
		String idDoComponenteRelacionado = null;  // nenhum componente em particular
		
		contexto.addMessage(idDoComponenteRelacionado, mensagem);
	}
	
	public Collection<Cliente> getLista() {
		Collection<Cliente> lista = aplicacaoMB.getClienteDAO().lista(); 
		System.out.println("passou no getLista()" + lista);
		return lista;
	}
	
	public Collection<String> getTiposClientes() {
		Collection<String> lista = new ArrayList<String>();
		lista.add("Internacional");
		lista.add("Gold");
		lista.add("Platinum");  
		System.out.println("passou no getTiposClientes()" + lista);
		return lista;
	}

	public Sexo[] getSexos() {		
		System.out.println("passou no getSexos()" + sexos.getClass().getEnumConstants());
		return this.sexos.getClass().getEnumConstants();
	}

	public void setSexos(Sexo[] sexos) { 
		System.out.println("passou no setSexos()" + sexos);		
	}

	public AplicacaoMB getAplicacaoMB() {
		return aplicacaoMB;
	}

	public void setAplicacaoMB(AplicacaoMB aplicacaoMB) {
		this.aplicacaoMB = aplicacaoMB;
	}

	public boolean isNaoEscolhido() {
		return naoEscolhido;
	}

	public void setNaoEscolhido(boolean naoEscolhido) {
		this.naoEscolhido = naoEscolhido;
	}
		
}
