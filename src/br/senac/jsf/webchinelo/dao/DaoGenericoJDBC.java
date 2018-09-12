package br.senac.jsf.webchinelo.dao;

import java.util.Collection;
import java.util.HashMap;

import br.senac.jsf.webchinelo.modelo.Entidade;
import br.senac.jsf.webchinelo.modelo.Produto;


public class DaoGenericoJDBC <T extends Entidade>{
private HashMap<Long, T> bancoDadosEmMemoria = new HashMap<Long, T>();
	
	public Entidade grava(T novoObjeto) {
		novoObjeto.setId((long) (bancoDadosEmMemoria.size()+1));
		bancoDadosEmMemoria.put(novoObjeto.getId(),novoObjeto);
		return novoObjeto;
	}

	public boolean remove(T objetoARemover) {
		//return bancoDadosEmMemoria.remove(objetoARemover.getId(),objetoARemover);		
		return bancoDadosEmMemoria.remove(objetoARemover.getId(),objetoARemover);
	}

	public boolean atualiza(T objetoAAtualizarNoBanco) {
		return bancoDadosEmMemoria.put(objetoAAtualizarNoBanco.getId(),objetoAAtualizarNoBanco) != null;		
	}
	
	public Collection<T> lista() {
		return bancoDadosEmMemoria.values();
	}
}
