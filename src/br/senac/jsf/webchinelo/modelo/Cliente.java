package br.senac.jsf.webchinelo.modelo;

import java.util.Date;

import br.senac.jsf.webchinelo.modelo.Sexo;

public class Cliente extends Entidade {
	private String nome;
	private String senha;
	private String gostosPessoais;
	private String tipoCliente; 
	private Sexo sexo;
	private Date dataNascimento;
	private String cpf;
	private Date dataValidadeCartaoCredito;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getGostosPessoais() {
		return gostosPessoais;
	}
	public void setGostosPessoais(String gostosPessoais) {
		this.gostosPessoais = gostosPessoais;
	}
	public String getTipoCliente() {
		return tipoCliente;
	}
	public void setTipoCliente(String tipoCliente) {
		this.tipoCliente = tipoCliente;
	}
	public Sexo getSexo() {
		return sexo;
	}
	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}
	public Date getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getDataValidadeCartaoCredito() {
		return dataValidadeCartaoCredito;
	}
	public void setDataValidadeCartaoCredito(Date dataValidadeCartaoCredito) {
		this.dataValidadeCartaoCredito = dataValidadeCartaoCredito;
	}
	@Override
	public String toString() {
		return "Cliente [nome=" + nome + ", senha=" + senha
				+ ", gostosPessoais=" + gostosPessoais + ", tipoCliente="
				+ tipoCliente + ", sexo=" + sexo + ", dataNascimento="
				+ dataNascimento + ", cpf=" + cpf
				+ ", dataValidadeCartaoCredito=" + dataValidadeCartaoCredito +
	 "]";
	}

}
