package br.senac.jsf.webchinelo.modelo;

import java.util.Date;

import br.senac.jsf.webchinelo.modelo.Entidade;
import br.senac.jsf.webchinelo.modelo.Sexo;


public class Funcionario extends Entidade {
	
	private String nome;
	private String funcao;
	private String curriculo;
	private String senha;
	private Sexo sexo;
	private Date dataNascimento;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getFuncao() {
		return funcao;
	}
	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}
	public String getCurriculo() {
		return curriculo;
	}
	public void setCurriculo(String curriculo) {
		this.curriculo = curriculo;
	}

	@Override
	public String toString() {
		return "Funcionario [id=" + id + ", nome=" + nome + ", funcao="
				+ funcao + ", senha=" + senha + "]";
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
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
	

}
