package Entidades;

import Exceptions.NegocioException;

public interface MetodoDePagamento {
	
	void processarPagamento(double valor) throws NegocioException;
	
}
