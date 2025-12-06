package entidades;

import exceptions.NegocioException;

public interface MetodoDePagamento {
	void processarPagamento(double valor) throws NegocioException;
	String getNome();
}
