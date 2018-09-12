package br.senac.jsf.webchinelo.managedBeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import br.senac.jsf.webchinelo.dao.ProdutoDAO;
import br.senac.jsf.webchinelo.dao.ClienteDao;
import br.senac.jsf.webchinelo.dao.FuncionarioDAO;
import br.senac.jsf.webchinelo.modelo.Produto;
import br.senac.jsf.webchinelo.modelo.Cliente;
import br.senac.jsf.webchinelo.modelo.Funcionario;

@ManagedBean(name="aplicacaoMB")
@ApplicationScoped()
public class AplicacaoMB implements Serializable {

	private static final long serialVersionUID = 4426094906591297538L;
	
	private String estadoOndeEstaOCliente;
	
	private ProdutoDAO produtoDAO = new ProdutoDAO();
	private ClienteDao clienteDAO = new ClienteDao();
	private FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
	private List<String> marca;
	
	public List<String> getMarca() {
		return marca;
	}

	@PostConstruct
	private void logoAposInstanciarOManagedBean() {		
		marca = criaBaseDadosMarca();
		criaBaseDadosProdutos();
		criaBaseDadosFuncionario();
	}

	@PreDestroy
	private void antesDeDestruirOManagedBean() {
		System.out.println("Managed Bean AplicacaoMB será destruído em 1,2,3....");
	}
	
		
	private void criaBaseDadosProdutos() {
		Produto havaiana,nike,reebok;
			
		havaiana = new Produto();
		havaiana.setMarca("havaiana");
		havaiana.setModelo("Tropical");
		havaiana.setTamanho(38);
		havaiana.setValor(21.0);
		produtoDAO.grava(havaiana);
		
		nike = new Produto();
		nike.setMarca("nike");
		nike.setModelo("Sports");
		nike.setTamanho(42);
		nike.setValor(39.0);
		produtoDAO.grava(nike);
		
		reebok = new Produto();
		reebok.setMarca("reebok");
		reebok.setModelo("Social");
		reebok.setTamanho(42);
		reebok.setValor(42.0);
		produtoDAO.grava(reebok);
		
	}
	
	private void criaBaseDadosFuncionario() {
		Funcionario f1, f2;
			
		f1 = new Funcionario();
		f1.setNome("Rafael da Costa Gon�alves");
		f1.setFuncao("Professor");
		f1.setCurriculo("Desenvolvedor de Sistema");
		f1.setSenha("12345");
		funcionarioDAO.grava(f1);
		
		f2 = new Funcionario();
		f2.setNome("Bruno Gall");
		f2.setFuncao("Professor");
		f2.setCurriculo("Desenvolvedor de Sistema");
		f2.setSenha("12345");
		funcionarioDAO.grava(f2);
		
	}
	
	
	public List<String> criaBaseDadosMarca() {
		List<String> lista = new ArrayList<String>();
		lista.add("Havaiana");
		lista.add("Nike");
		lista.add("Reebok");
		return lista;
	}
	
	
	public ProdutoDAO getProdutoDAO() {
		return produtoDAO;
	}

	public void setProdutoDAO(ProdutoDAO produtoDAO) {
		this.produtoDAO = produtoDAO;
	}

	public ClienteDao getClienteDAO() {
		return clienteDAO;
	}

	public void setClienteDAO(ClienteDao clienteDAO) {
		this.clienteDAO = clienteDAO;
	}

	public FuncionarioDAO getFuncionarioDAO() {
		return funcionarioDAO;
	}

	public void setFuncionarioDAO(FuncionarioDAO funcionarioDAO) {
		this.funcionarioDAO = funcionarioDAO;
	}

	
}
