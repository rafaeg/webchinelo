package br.senac.jsf.webchinelo.managedBeans;

import java.util.ArrayList;
import java.util.Collection;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.senac.jsf.webchinelo.managedBeans.ProdutoMB.ModoPagina;
import br.senac.jsf.webchinelo.modelo.Funcionario;
import br.senac.jsf.webchinelo.modelo.Produto;
import br.senac.jsf.webchinelo.modelo.Sexo;

@ManagedBean
@ViewScoped
public class FuncionarioMB {

	@ManagedProperty(value="#{aplicacaoMB}")
	private AplicacaoMB aplicacaoMB;
	
	private Funcionario funcionario;
	
	private Sexo sexos = Sexo.naoInformado;
	
	
	public FuncionarioMB() {		
		System.out.println("passou no contutor do " + this.getClass().getSimpleName());
	}
	
	@PostConstruct
	public void inicializa() {
		funcionario = new Funcionario();
		System.out.println("o estado atual do produto neste MB é " + funcionario);
	}
	
	@PreDestroy
	public void liberaRecursos() {		
		System.out.println("passou no PreDestrouy do " + this.getClass().getSimpleName());
		System.out.println("o estado atual do produto neste MB é " + funcionario);
	}
	
	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
	
	public String grava() {
		System.out.println("Vai gravar o produto no banco: " +funcionario);
		aplicacaoMB.getFuncionarioDAO().grava(funcionario);
		String resumoMensagem = "Gravou o produto no banco: " + funcionario;
		System.out.println(resumoMensagem);
		apresentaMensagem(resumoMensagem);
		return null;
	}
	
	public Collection<Funcionario> getLista() {
		return getAplicacaoMB().getFuncionarioDAO().lista();
	}
	
	public Collection<String> getFuncoesFuncionarios() {
		Collection<String> lista = new ArrayList<String>();
		lista.add("");
		lista.add("Coordenador");
		lista.add("Professor");
		lista.add("Secretario");
		return lista;
	}
	
	public Sexo[] getSexos() {
		return sexos.getClass().getEnumConstants();
	}


	public void setSexos(Sexo[] sexos) {
		
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
	
	
}
